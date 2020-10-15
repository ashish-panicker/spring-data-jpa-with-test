package com.easyskillup.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TraineeNotFoundException extends Exception{
	
	public TraineeNotFoundException() {
		super("Trainee does not exist.");
	}

}
