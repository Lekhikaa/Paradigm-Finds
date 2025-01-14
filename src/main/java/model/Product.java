package model;

import java.io.Serializable;

public class Product implements Serializable {
	private String productName;
	private String productCategory;
	private String productDescription;
	private int productPrice;
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	private byte[] image_data;
	private String image_name;
	private String base64ImageData;
	public byte[] getImage_data() {
		return image_data;
	}
	public void setImage_data(byte[] image_data) {
		this.image_data = image_data;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getBase64ImageData() {
		return base64ImageData;
	}
	public void setBase64ImageData(String base64ImageData) {
		this.base64ImageData = base64ImageData;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
