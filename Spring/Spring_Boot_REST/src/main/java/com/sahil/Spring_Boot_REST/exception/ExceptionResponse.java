package com.sahil.Spring_Boot_REST.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "ERROR")
@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {

	private int errorCode;
	private String errorMessage;
	private List<String> errorDetails;
	
}
