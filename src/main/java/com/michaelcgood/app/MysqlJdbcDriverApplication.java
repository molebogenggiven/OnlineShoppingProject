package com.michaelcgood.app;

import javax.sql.DataSource;

import com.michaelcgood.Service.StorageService;
import com.michaelcgood.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.michaelcgood.model.Given;

import com.michaelcgood.dao.SystemRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//
//@SpringBootApplication
//@EnableJpaRepositories("com.michaelcgood.dao")
//@EntityScan("com.michaelcgood.model")
@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.michaelcgood.Controller","com.michaelcgood.dao","com.michaelcgood.Service"})
@EnableJpaRepositories(basePackages = {"com.michaelcgood.dao",})
@EntityScan("com.michaelcgood.model")



public class MysqlJdbcDriverApplication implements CommandLineRunner{

	
	//@Qualifier("dataSource")
	//DataSource dataSource;
//
//    @Autowired
//    ProductRepository productRepository;
//{}
//
//    @Autowired
//	SystemRepository systemRepository;
	@Autowired
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(MysqlJdbcDriverApplication.class, args);
		//SpringApplication.run(MysqlJdbcDriverApplication.class,args);

	}

	@Override
	public void run(String... args) {
		storageService.deleteAll();
		storageService.init();
		
	}

	//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Our DataSource is = " + dataSource);
//		Iterable<com.michaelcgood.model.Given> systemList = systemRepository.findAll();
//		for(com.michaelcgood.model.Given systemmodel:systemList){
//			System.out.println("Here is a system: " + systemmodel.toString());
//		}
//
//        Iterable<com.michaelcgood.model.Product> productDetails = productRepository.findAll();
//
//        for (com.michaelcgood.model.Product productModel: productDetails) {
//
//            System.out.println("Here is a productDetails:"+productModel.toString());
//
//        }
//
//	}

}
