package cn.mrdear.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.mrdear.entity.Person2;

public interface PersonRepository3 extends MongoRepository<Person2, String>  {
	
	 Person2 findByName(String name);
		
	 @Query("{'age': ?0}")
	 List<Person2> withQueryFindByAge(Integer age);

}
