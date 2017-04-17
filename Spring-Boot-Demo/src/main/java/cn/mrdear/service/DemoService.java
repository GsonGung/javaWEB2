package cn.mrdear.service;

import cn.mrdear.entity.Person;

public interface DemoService {
	
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);

}
