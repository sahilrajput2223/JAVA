package com.sahil.SpringProjectLombok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.SpringProjectLombok.model.DataModel;
import com.sahil.SpringProjectLombok.service.ServiceInterface;

@RestController
public class LombokController {

	@Autowired
	private ServiceInterface serviceInterface;
	
	@PostMapping(value="addNewUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataModel> addNewUser(@RequestBody DataModel dataModel){
		serviceInterface.addData(dataModel);
		return new ResponseEntity<DataModel>(dataModel, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "allUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DataModel> allUserData(){
		return serviceInterface.getData();
	} 
	
}
