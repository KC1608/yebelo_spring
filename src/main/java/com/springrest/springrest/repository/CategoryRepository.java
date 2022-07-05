package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.CategoryValues;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryValues, Integer>  {
   public List<CategoryValues> findByCategoryCode(String categoryCode);	
 
   
   
   
   
}