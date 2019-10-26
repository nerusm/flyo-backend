package com.flyosports2.manage.InventoryManagementApp;

import com.flyosports2.manage.InventoryManagementApp.Model.Manufacturer;
import com.flyosports2.manage.InventoryManagementApp.Model.Product;
import com.flyosports2.manage.InventoryManagementApp.Model.Sport;
import com.flyosports2.manage.InventoryManagementApp.Model.Supplier;
import com.flyosports2.manage.InventoryManagementApp.Repository.ManufacturerRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.ProductRepository;
import com.flyosports2.manage.InventoryManagementApp.Repository.SupplierRespository;
import com.flyosports2.manage.InventoryManagementApp.Repository.SportRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InventoryManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementAppApplication.class, args);


        //clean install spring-boot:run -e
    }

    @Bean
    public CommandLineRunner commandLineRunner(SportRepository sportRepository, SupplierRespository supplierRespository,
                                               ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
        return (args -> {

            System.out.println("**** Count: "+sportRepository.countBySportNameNotNull());
            System.out.println("cricket prods: "+productRepository.countBySportSportName("CRICKET"));
            productRepository.deleteAll();
           sportRepository.deleteAll();
           manufacturerRepository.deleteAll();
//           supplierRespository.deleteAll();
            Sport badminton = new Sport(1, "BADMINTON");
            Sport cricket = new Sport(2, "CRICKET");
            Sport tennis = new Sport(3, "TENNIS");
            Sport volleyBall = new Sport(4, "VOLLEYBALL");
            sportRepository.save(badminton);
            sportRepository.save(cricket);
            sportRepository.save(tennis);
            sportRepository.save(volleyBall);

            Manufacturer yonex = new Manufacturer("Yonex");
            Manufacturer kukubora = new Manufacturer("Kukubora");
            Manufacturer ss = new Manufacturer("SS");
            Manufacturer sg = new Manufacturer("SG");
            Manufacturer head = new Manufacturer("Head");
            Manufacturer vector = new Manufacturer("Vector");
            Manufacturer apacs = new Manufacturer("APACS");

            manufacturerRepository.save(yonex);
            manufacturerRepository.save(kukubora);
            manufacturerRepository.save(ss);
            manufacturerRepository.save(sg);
            manufacturerRepository.save(head);
            manufacturerRepository.save(vector);
            manufacturerRepository.save(apacs);

            Supplier supplier1 = new Supplier("Ashok Traders","Bangalore");
            Supplier supplier2 = new Supplier("Grace","Chennai");

            Product p1 = new Product("Bat","EW VK18 LEGEND", "ENGLISH WILLOW", "LEGEND","","");
            p1.setManufacturer(sg);
            p1.setSport(cricket);
            productRepository.save(p1);
/*
            supplierRespository.save(supplier1);
            supplierRespository.save(supplier2);
*/

           /* Product product1 = new Product("Racket","Ziggler",badminton,apacs,"");
            productRepository.save(new Product("Racket", "Head", tennis,head,"5"));
            Product product2 = new Product("Shuttle", "Mavis 350", badminton,yonex,"");


			productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(new Product("Bat", "English Willow", cricket, ss, "5"));
            productRepository.save(new Product("Gloves", "Batting", cricket, sg,"youth"));
            productRepository.save(new Product("Racket","Super Nano",badminton,apacs,""));
            productRepository.save(new Product("Shoe","True Cushion",badminton,yonex,"9"));
            productRepository.save(new Product("Shoe","Something",badminton,vector,"9"));*/

		    /*Product product1= new Product("RACKET","NANO");
		    Product product2 = new Product("Shuttle","Mavis 350");
		    Sport sport = new Sport(2,"BADMINTON");
		    sport.addProduct(product1);
		    sport.addProduct(product2);
			List<Product> productList = new ArrayList<Product>();
			productList.add(product1);
			productList.add(product2);
		    productRepository.saveAll(productList);
		    sportRepository.save(sport);
		    sportRepository.save(new Sport(3,"CRICKET"));

		 /*   for (Product product : productRepository.findAll()){
				System.out.println(product.toString());
			}

			System.out.println("*******");

		    for (Sport sport2 : sportRepository.findAll()){
				System.out.println(sport2.toString());
			}
*/

        });
    }
}
