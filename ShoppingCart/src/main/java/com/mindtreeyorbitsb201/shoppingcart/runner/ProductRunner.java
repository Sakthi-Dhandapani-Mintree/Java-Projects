package com.mindtreeyorbitsb201.shoppingcart.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mindtreeyorbitsb201.shoppingcart.entity.Apparal;
import com.mindtreeyorbitsb201.shoppingcart.entity.Book;
import com.mindtreeyorbitsb201.shoppingcart.entity.Product;
import com.mindtreeyorbitsb201.shoppingcart.entity.User;
import com.mindtreeyorbitsb201.shoppingcart.repository.ProductRepository;
import com.mindtreeyorbitsb201.shoppingcart.repository.UserRepository;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * Load initial products details into database
	 */

	@Override
	public void run(String... args) throws Exception {
		loadData();
	}

	public void loadData() {
		List<Product> listOfProducts = new ArrayList<Product>();
		listOfProducts.add(new Book(1, "c++", "book", 200f, "programming", "bala", "Mindtree"));
		listOfProducts.add(new Book(2, "java", "book", 200f, "programming", "bala", "Born"));
		listOfProducts.add(new Book(3, "java", "book", 200f, "programming", "dexy", "fidility"));
		listOfProducts.add(new Apparal(4, "otto", "apparal", 200f, "shirt", "phothis", "CTS"));
		listOfProducts.add(new Apparal(5, "crocodile", "apparal", 200f, "chudi", "Saravana", "TCS"));
		listOfProducts.add(new Apparal(6, "johnpeter", "apparal", 200f, "frog", "Chennai", "VTS"));
		for (Product product : listOfProducts) {
			productRepository.save(product);
		}
		List<User> listOfUser = new ArrayList<User>();
		listOfUser.add(new User("Sakthi", "9994381335", "sakthi.dhandapani@gmail.com"));
		listOfUser.add(new User("Vishwa", "9788854343", "vishwa.dhandapani@gmail.com"));
		listOfUser.add(new User("Thuva", "8899776655", "thuva.dhandapani@gmail.com"));
		for (User user : listOfUser) {
			userRepository.save(user);
		}

	}

}
