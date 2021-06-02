package com.sahil.SpringProjectLombok.service;


import java.util.List;


import com.sahil.SpringProjectLombok.model.DataModel;



public interface ServiceInterface {

	public void addData(DataModel dataModel);
	
	public List<DataModel> getData();
	
}
