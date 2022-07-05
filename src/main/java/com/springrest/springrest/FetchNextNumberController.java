package com.springrest.springrest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.CategoryValues;
import com.springrest.springrest.model.NextNumberResponse;
import com.springrest.springrest.model.Request;
import com.springrest.springrest.services.SmallestNextAvailableNumberService;

@RestController
public class FetchNextNumberController {

	@Autowired
	SmallestNextAvailableNumberService smallestNextAvailableNumberService;
	
	@PostMapping("/FetchNextNumber")
    public ResponseEntity<NextNumberResponse> fetchNextNumber(@RequestBody Request reqObj) {
		CategoryValues oldCategoryValue = smallestNextAvailableNumberService.getCategoryValue(reqObj.getCategoryCode());
		int oldValue = 0;
		if(!Objects.isNull(oldCategoryValue)) {
			oldValue = oldCategoryValue.getValue();
		}
		int nextVal = smallestNextAvailableNumberService.getResponseValue(reqObj.getCategoryCode());
		NextNumberResponse res = new NextNumberResponse();
		
		res.setOldValue(oldValue);
		res.setNewValue(nextVal);
		 HttpHeaders headers = new HttpHeaders();
         
	       return  new ResponseEntity<NextNumberResponse>(res,headers,HttpStatus.OK);
    }

}
