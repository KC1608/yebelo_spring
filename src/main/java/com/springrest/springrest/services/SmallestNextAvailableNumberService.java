package com.springrest.springrest.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.CategoryValues;
import com.springrest.springrest.repository.CategoryRepository;

@Service
public class SmallestNextAvailableNumberService {
	
	@Autowired
	private CategoryRepository categoryRepository;  
	
	
	
	public int getNextSmallestNumber(int prev){
        int i =prev+1;
       while(digSum(i)!=1){
           i++;
       }
       return i;
    }

    public int digSum(int n)
    {
        int sum = 0;
        // 192 -> 12 ->3
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    public CategoryValues getCategoryValue(String cc) {
    	return (CategoryValues) categoryRepository.findByCategoryCode(cc);
    }
    
    public void updateValue(String cc, int value) {
    	    CategoryValues cvFromDb = (CategoryValues) categoryRepository.findByCategoryCode(cc);
    	    // crush the variables of the object found
    	    cvFromDb.setValue(value);    	   
    	    categoryRepository.save(cvFromDb);
    	}
    
    
    public int getResponseValue(String cc) {
    	CategoryValues cvFromDb = getCategoryValue(cc);
    	
    	int newVal = 0;
    	if(!Objects.isNull(cvFromDb)) {
    		newVal = getNextSmallestNumber(cvFromDb.getValue());
    		updateValue(cc, newVal);    
    	}
    		
    	return newVal;
    }
}

