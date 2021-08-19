package com.example.demo.Jpa;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pservice {  
	@Autowired
	ProductRepository pr;
	
	public Employee23 saveProduct(Employee23 e)
	{
		return pr.save(e);
	} 
	public List<Employee23> saveAll23(List<Employee23> e) 
	{
		return pr.saveAll(e);
	}
	public Employee23 getproductbyId(Employee23 e)
	{
		return pr.findById(e.getId()).orElse(null);
	}
	public List<Employee23> getProducts()
	{
		return pr.findAll();
	} 
	public Employee23 getProductByName(String name)
	{
		return pr.findByName(name);
	} 
	public String deleteProductById(int id)
	{
		pr.deleteById(id);
		return "Product with id  "+id+"  deleted";
	} 
	public Employee23 updateProduct(Employee23 product)
	{
		Employee23 ep=pr.findById(product.getId()).orElse(null);
		ep.setName(product.getName());
		ep.setPhno(product.getPhno()); 
		return pr.save(ep);
		
	}
	

}
