package com.demo.pet.store.pages;

public class RequestBodyPOJO {
	private int id;
	private Category category;
	private String name;
	private PhotoURLs photoUrls;
	private Tags tags;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PhotoURLs getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(PhotoURLs photoUrls) {
		this.photoUrls = photoUrls;
	}
	public Tags getTags() {
		return tags;
	}
	public void setTags(Tags tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
