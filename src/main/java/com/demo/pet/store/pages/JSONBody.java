package com.demo.pet.store.pages;

public class JSONBody {

	public Object body()
	{
		Category category = new Category();
		category.setId(13);
		category.setName("Doggy");
		
		PhotoURLs photoUrls = new PhotoURLs();
		photoUrls.setString("String");
		
		Tags tags = new Tags();
		tags.setId(13);
		tags.setName("Pet");
		
		RequestBodyPOJO body = new RequestBodyPOJO();
		body.setId(13);
		body.setCategory(category);
		body.setName("puppy");
		body.setPhotoUrls(photoUrls);
		body.setTags(tags);
		body.setStatus("available");
		return body;
	}
}
