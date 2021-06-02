package com.sahil.SpringProjectLombok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sahil.SpringProjectLombok.model.DataModel;

@Service
public class ServiceImplimentation implements ServiceInterface{

	List<DataModel> dataList = new ArrayList<DataModel>();
	
	@Override
	public void addData(DataModel dataModel) {
		dataList.add(dataModel);
	}

	@Override
	public List<DataModel> getData() {
		return dataList;
	}

}
