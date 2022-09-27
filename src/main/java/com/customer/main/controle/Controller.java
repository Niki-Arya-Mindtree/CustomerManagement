package com.customer.main.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.main.exception.EmptyData;
import com.customer.main.exception.WrongId;
import com.customer.main.model.Model;
import com.customer.main.service.*;

@RestController
public class Controller {
	
	@Autowired
	private Service serv;

	@GetMapping("/cus-data")
	public ResponseEntity<Object> getFindAll() throws Exception
	{
		try {
			return new ResponseEntity<>(serv.getAll() ,HttpStatus.FOUND);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
			
	}
	

	@GetMapping("/cus-data/{Id}")
	public ResponseEntity<Object> getOneData(@PathVariable int Id) throws Exception
	{
		try {
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
			
	}
	
	@PutMapping("/cus-data")
	public ResponseEntity<Object> getUpdateModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.updateModel(mdd);
			return new ResponseEntity<>(serv.oneData(mdd.getId()) ,HttpStatus.ACCEPTED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
			
	}
	
	
	@PostMapping("/cus-data")
	public ResponseEntity<Object> getOneSaveModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.oneSave(mdd);
			return new ResponseEntity<>("Data added into Data Base",HttpStatus.CREATED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
			
	}
	
	@DeleteMapping("/cus-data/{Id}")
	public ResponseEntity<Object> getOneSaveModel(@PathVariable int Id) throws Exception
	{
		try {
			serv.deleteOne(Id);
			return new ResponseEntity<>("Data deleted from Data Base",HttpStatus.ACCEPTED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
			
	}
}
