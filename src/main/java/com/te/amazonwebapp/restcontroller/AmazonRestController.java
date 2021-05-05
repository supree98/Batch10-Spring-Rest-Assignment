package com.te.amazonwebapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.amazonwebapp.bean.AmazonResponse;
import com.te.amazonwebapp.bean.Item;
import com.te.amazonwebapp.service.AmazonService;

@RestController
public class AmazonRestController {

	@Autowired
	AmazonService service;
	
	@GetMapping(path = "/getItem", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse getItem(Integer id) {

		Item item = service.searchItem(id);
		AmazonResponse response = new AmazonResponse();
		
		if(item != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItem(item);
		} else {
			response.setStatusCode(404);
			response.setMessage("item does not presesnt");
		}
		return response;
		
	}
	
	@GetMapping(path = "/getAllItems", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse getAllItem() {
		AmazonResponse response  =  new AmazonResponse();
		List<Item> itemList = service.getAllItems();
		if(itemList != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItemList(itemList);
		} else {
			response.setStatusCode(404);
			response.setMessage("Items do not present");
		}
		return response;
	}
	
	@PostMapping(path = "/addItem", produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE}, consumes = 
			{MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public AmazonResponse addItem(@RequestBody Item item) {
		AmazonResponse response  =  new AmazonResponse();
		if(service.addItem(item)) {
			response.setStatusCode(200);
			response.setMessage("success");
	
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure , Could not add the data");
		}
		return response;
	}
	
	@PutMapping(path = "/updateItem", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AmazonResponse updateItem(@RequestBody Item item) {
		AmazonResponse response  =  new AmazonResponse();
		if(service.updateItem(item)) {
			response.setStatusCode(200);
			response.setMessage("success");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure , Could not add the data");
		}
		return response;
	}
	
	@DeleteMapping(path = "/deleteItem/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public AmazonResponse deleteItem(@PathVariable(name = "id") Integer id) {
		AmazonResponse response  =  new AmazonResponse();
		if(service.removeItem(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure , Could not add the data");
		}
		return response;
	}
}
