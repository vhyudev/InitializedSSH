package com.lxtech.ssh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lxtech.ssh.entity.Cheque;
import com.lxtech.ssh.service.ChequeService;
import com.lxtech.ssh.vo.MessegeDto;

@Controller
public class UploadDownLoadAction {
	
	@Autowired
	private ChequeService chequeService;
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
    public MessegeDto upload(HttpServletRequest request,HttpServletResponse response){
		//文件上传的请求
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
       // MultipartFile file1 = mRequest.getFile("iconImg");
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
//        String ctxPath = request.getSession().getServletContext().getRealPath("/")
//                + FileOperateUtil.FILEDIR;
        Map<String, Object> result = new HashMap<String, Object>();
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();
        
        MessegeDto mt = new MessegeDto();
       
        while(it.hasNext()){
            Map.Entry<String, MultipartFile> entry = it.next(); 
            MultipartFile mFile = entry.getValue(); 
            String fileName = mFile.getOriginalFilename();//获取文件名称
            InputStream is = null;
            Workbook wookbook = null;
            try {
				is =  mFile.getInputStream();
				if(fileName == null && "".equals(fileName)){
					mt.setStatus("1");
					mt.setMessage("上传失败");
					return mt;
				}else if(fileName.toLowerCase().endsWith("xls")){//2003excel
					wookbook = new HSSFWorkbook(is);
				}else if(fileName.toLowerCase().endsWith("xlsx")){//2007excel
					wookbook = new XSSFWorkbook(is);//得到工作簿
				}else{
					mt.setStatus("1");
					mt.setMessage("上传文件类型不对！");
					return mt;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				mt.setStatus("1");
				mt.setMessage("上传失败");
				return mt;
			}
          //得到一个工作表
            Sheet sheet = wookbook.getSheetAt(0);
            //获得表头
            Row rowHead = sheet.getRow(0);
            //判断表头是否正确
//            if(rowHead.getPhysicalNumberOfCells() != 3)
//            {
//                System.out.println("表头的数量不对!");
//            }
            
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            
            //要获得属性
            String num = "";
            String amount = "";
            String date = "";
            List<Cheque> chequeList = new ArrayList<Cheque>();
           //获得所有数据
            for(int i = 1 ; i <= totalRowNum ; i++)
            {
            	Cheque cheque = new Cheque();//支票实体类
                //获得第i行对象
                Row row = sheet.getRow(i);
                
                //获得获得第i行第0列的 String类型对象   支票号
                Cell cell = row.getCell((short)0);
                num = cell.getNumericCellValue()+"";
                cheque.setChequeNum(num);
                //获得2列数据  金额
                cell = row.getCell((short)1);
                amount =  cell.getNumericCellValue()+"";
                cheque.setAmount(new BigDecimal(amount));
              //获得3列数据  开票日期
                cell = row.getCell((short)2);
                cheque.setOpenDate(cell.getDateCellValue());
                chequeList.add(cheque);
                //System.out.println("名字："+name+",经纬度："+latitude);
               
            }
            try{
            	chequeService.saveAll(chequeList);
            }catch(ConstraintViolationException cve){
            	cve.printStackTrace();
				mt.setStatus("1");
				mt.setMessage("重复上传");
				return mt;
            }catch (Exception e) {
            	mt.setStatus("1");
				mt.setMessage("上传失败");
				return mt;
			}
            
        } 
       // response.setContentType("text/html");
        mt.setStatus("0");
		mt.setMessage("上传成功");
        return mt;
    }
	@RequestMapping(value = "downLoad")
    public void downLoad(HttpServletResponse response,String userName){
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + "qwq.xlsx");
        OutputStream os = null;
        InputStream inputStream  = null;
        MessegeDto mt = new MessegeDto();
        try {
            String path = "C:\\Users\\Administrator\\Desktop\\com";
            inputStream = new FileInputStream(new File(path
                    + File.separator + "aaa.xlsx"));

            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            mt.setStatus("1");
        } catch (IOException e) {
        	mt.setStatus("1");
            e.printStackTrace();
        }finally{
        	if(os != null){
        		try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	if(inputStream != null){
        		try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
        mt.setStatus("0");
       // return mt;
	}
}
