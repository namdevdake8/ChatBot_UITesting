package com.chatbot.pojoclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetQueries {

	@SerializedName("image")
	@Expose
	private String image;
	@SerializedName("product_url")
	@Expose
	private String productUrl;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("xc_sku")
	@Expose
	private String xcSku;
	@SerializedName("_score")
	@Expose
	private String score;
	@SerializedName("client_id")
	@Expose
	private String clientId;
	@SerializedName("colorsavailable")
	@Expose
	private String colorsavailable;
	@SerializedName("size")
	@Expose
	private String size;
	@SerializedName("price")
	@Expose
	private String price;
	@SerializedName("productname")
	@Expose
	private String productname;
	@SerializedName("subcategory")
	@Expose
	private String subcategory;
	@SerializedName("sku")
	@Expose
	private String sku;
	@SerializedName("client_name")
	@Expose
	private String clientName;
	@SerializedName("brand")
	@Expose
	private String brand;
	@SerializedName("confidence")
	@Expose
	private String confidence;
	@SerializedName("suggested")
	@Expose
	private String suggested;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getXcSku() {
		return xcSku;
	}

	public void setXcSku(String xcSku) {
		this.xcSku = xcSku;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getColorsavailable() {
		return colorsavailable;
	}

	public void setColorsavailable(String colorsavailable) {
		this.colorsavailable = colorsavailable;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public String getSuggested() {
		return suggested;
	}

	public void setSuggested(String suggested) {
		this.suggested = suggested;
	}

}