package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.atguigu.dao.PersonDao;

@Service
public class PersonService {
	
	@Qualifier("personDao02")
	@Autowired
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public String toString() {
		return "PersonService [personDao=" + personDao.toString() + "]";
	}
	
	

}
