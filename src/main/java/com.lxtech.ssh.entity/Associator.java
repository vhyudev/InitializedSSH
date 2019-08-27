package com.lxtech.ssh.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "t_associator",uniqueConstraints = {@UniqueConstraint(columnNames={"idCardNo"})})
public class Associator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @GenericGenerator(name="foreignGenerator", strategy="foreign", parameters={@Parameter(value="t_users", name="property")})
   @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 性别
	 */
	@ManyToOne(optional=true)  
	@JoinColumn(name="gender_id",  nullable = false) 
	private Gender gender;
	
	/**
	 * 年龄
	 */
	@Column(name = "age") 
	private int age;
	
	/**
	 * 会员类型  绑定服务会员 未绑定服务会员
	 */
	@ManyToOne(optional=true)  
	@JoinColumn(name="associator_Type_id",  nullable = false)
	private AssociatorType associatorType;
	
	/**
	 * 会员购买的产品
	 */
	@ManyToMany
	@JoinTable(name="associator_product_mid",//中间表名
	joinColumns=@JoinColumn(name="associator_id"),//这个类在表中的id
	inverseJoinColumns=@JoinColumn(name="product_id")//反转的类在联合表中的id
	)
	private Set<Product> products = new HashSet<Product>();
	
	/**
	 * 会员购买产品的详细信息（包括金额等）
	 */
	@OneToMany(mappedBy = "associator")
	private Set<ProductSales> sales = new HashSet<ProductSales>();
	
	/**
	 * 会员购买产品的详细信息（包括金额等）
	 */
	@OneToMany(mappedBy = "associator")
	private Set<Cheque> cheques = new HashSet<Cheque>();
	
	/**
	 * 户口所在省
	 */
	@Column(name = "register_province")
	private String registerProvince;
	
	/**
	 * 户口所在市
	 */
	@Column(name = "register_city")
	private String registerCity;
	
	/**
	 * 户口所在区/县
	 */
	@Column(name = "register_district")
	private String registerDistrict;
	
	
	/**
	 * 户口所在详细地址（区县级以下地址）
	 */
	@Column(name = "register_DetailedAddress")
	private String registerDetailedAddress;
	
	/**
	 * 现居住省
	 */
	@Column(name = "Living_province")
	private String LivingProvince;
	
	/**
	 * 现居住市
	 */
	@Column(name = "Living_city")
	private String LivingCity;
	
	/**
	 * 现居住区/县
	 */
	@Column(name = "Living_district")
	private String LivingDistrict;
	
	
	/**
	 * 现居住详细地址（区县级以下地址）
	 */
	@Column(name = "Living_DetailedAddress")
	private String LivingDetailedAddress;
	
	/**
	 * 联系省
	 */
	@Column(name = "contact_province")
	private String contactProvince;
	
	/**
	 * 联系市
	 */
	@Column(name = "contact_city")
	private String contactCity;
	
	/**
	 * 联系区/县
	 */
	@Column(name = "contact_district")
	private String contactDistrict;
	
	
	/**
	 * 联系详细地址（区县级以下地址）
	 */
	@Column(name = "contact_DetailedAddress")
	private String contactDetailedAddress;
	
	
	@ManyToOne(optional=true)  
	@JoinColumn(name="associator_Grade_id")
	private AssociatorGrade associatorGrade;//會員等級	

	/**
	 * 身份证号
	 */
	@Column(name = "idCardNo")
	private String idCardNo;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "createTime")
	private Time createTime;
	
	@Column(name = "updateTime")
	private Time updateTime;
	
	/**
	 * 备注说明
	 */
	@Column(name = "remark")
	private String remark;
	
	/**
	 * 移动电话号码
	 */
	private String mobile;
	
	/**
	 * 固话
	 */
	private String telphone;
	
	/**
	 * 邮箱
	 * @return
	 */
	private String email;
	
	/**
	 * 翼支付会员
	 */
	@OneToOne(mappedBy="associator")
	private YipayAssociator yipayAssociator;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AssociatorType getAssociatorType() {
		return associatorType;
	}

	public void setAssociatorType(AssociatorType associatorType) {
		this.associatorType = associatorType;
	}

	public AssociatorGrade getAssociatorGrade() {
		return associatorGrade;
	}

	public void setAssociatorGrade(AssociatorGrade associatorGrade) {
		this.associatorGrade = associatorGrade;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Time getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}

	public Time getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Time updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegisterProvince() {
		return registerProvince;
	}

	public void setRegisterProvince(String registerProvince) {
		this.registerProvince = registerProvince;
	}

	public String getRegisterCity() {
		return registerCity;
	}

	public void setRegisterCity(String registerCity) {
		this.registerCity = registerCity;
	}

	public String getRegisterDistrict() {
		return registerDistrict;
	}

	public void setRegisterDistrict(String registerDistrict) {
		this.registerDistrict = registerDistrict;
	}

	public String getRegisterDetailedAddress() {
		return registerDetailedAddress;
	}

	public void setRegisterDetailedAddress(String registerDetailedAddress) {
		this.registerDetailedAddress = registerDetailedAddress;
	}

	public String getLivingProvince() {
		return LivingProvince;
	}

	public void setLivingProvince(String livingProvince) {
		LivingProvince = livingProvince;
	}

	public String getLivingCity() {
		return LivingCity;
	}

	public void setLivingCity(String livingCity) {
		LivingCity = livingCity;
	}

	public String getLivingDistrict() {
		return LivingDistrict;
	}

	public void setLivingDistrict(String livingDistrict) {
		LivingDistrict = livingDistrict;
	}

	public String getLivingDetailedAddress() {
		return LivingDetailedAddress;
	}

	public void setLivingDetailedAddress(String livingDetailedAddress) {
		LivingDetailedAddress = livingDetailedAddress;
	}

	public String getContactProvince() {
		return contactProvince;
	}

	public void setContactProvince(String contactProvince) {
		this.contactProvince = contactProvince;
	}

	public String getContactCity() {
		return contactCity;
	}

	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	public String getContactDistrict() {
		return contactDistrict;
	}

	public void setContactDistrict(String contactDistrict) {
		this.contactDistrict = contactDistrict;
	}

	public String getContactDetailedAddress() {
		return contactDetailedAddress;
	}

	public void setContactDetailedAddress(String contactDetailedAddress) {
		this.contactDetailedAddress = contactDetailedAddress;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<ProductSales> getSales() {
		return sales;
	}

	public void setSales(Set<ProductSales> sales) {
		this.sales = sales;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public YipayAssociator getYipayAssociator() {
		return yipayAssociator;
	}

	public void setYipayAssociator(YipayAssociator yipayAssociator) {
		this.yipayAssociator = yipayAssociator;
	}

	public Set<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(Set<Cheque> cheques) {
		this.cheques = cheques;
	}


	
	
	
	
}
