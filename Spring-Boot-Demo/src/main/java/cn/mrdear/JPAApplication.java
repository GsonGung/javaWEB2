package cn.mrdear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cn.mrdear.dao.PersonRepository2;
import cn.mrdear.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class JPAApplication {
	
	@Autowired
	PersonRepository2 personRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
        
    }

}
