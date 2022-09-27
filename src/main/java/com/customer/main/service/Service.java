package com.customer.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.main.exception.EmptyData;
import com.customer.main.exception.WrongId;
import com.customer.main.model.Model;
import com.customer.main.repos.CustRepo;


@org.springframework.stereotype.Service
public class Service{

	@Autowired
	private CustRepo repos;

	public List<Model> getAll() throws EmptyData
	{
		if(repos.findAll().size()==0)
			throw new EmptyData("Empty Data Base");
		return repos.findAll();
	}

	public Model oneData(int Id) throws WrongId
	{
		if(repos.findById(Id).isEmpty())
			throw new WrongId("Entered Id is not present in the Data Base.");
		return repos.findById(Id).get();
	}

	
	
	public void updateModel(Model md) throws WrongId
	{
		if(!repos.findById(md.getId()).isPresent())
			throw new WrongId("Entered Id is not present in the Data Base.");
		Model tempmd = repos.findById(md.getId()).get();
		tempmd.setName(md.getName());
		tempmd.setAge(md.getAge());
		tempmd.setGender(md.getGender());
		repos.saveAndFlush(tempmd);	
	}
	
	
	public void oneSave(Model md) throws WrongId
	{
		if(repos.findById(md.getId()).isPresent())
			throw new WrongId("Id is already Present");
		repos.saveAndFlush(md);
	}
	
	

	public void deleteOne(@PathVariable int Id) throws WrongId
	{
		if(repos.findById(Id).isEmpty())
			throw new WrongId("Entered Id is not present in the Data Base.");
		repos.deleteById(Id);
	}
	
}
