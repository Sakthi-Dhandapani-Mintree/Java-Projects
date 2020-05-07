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
		listOfProducts.add(new Book(1, "c++", "book", 210, "programming", "balakumar", "mindtree"));
		listOfProducts.add(new Book(2, "java", "book", 190, "programming", "catherine", "cts"));
		listOfProducts.add(new Book(3, "java", "book", 1547, "programming", "samuel", "o'reily"));
		listOfProducts
				.add(new Book(4, "the argumentative indian", "book", 360, "history", "Amartya Sen", "allen lane"));
		listOfProducts.add(new Book(5, "the circle reason", "book", 429, "novel", "Amitav Ghosh", "viking press "));

		listOfProducts.add(new Apparal(6, "shirt-1", "apparal", 1200, "shirt", "aramani", "line"));
		listOfProducts.add(new Apparal(7, "formal-shirt", "apparal", 1300, "shirt", "crocodile", "dotted"));
		listOfProducts.add(new Apparal(8, "casual-shirt", "apparal", 800, "shirt", "johnpeter", "checked"));

		listOfProducts.add(new Apparal(9, "Line-kurta", "apparal", 2200, "kurta", "forever", "printed-line"));
		listOfProducts.add(new Apparal(10, "ethnic-dress", "apparal", 600, "sari", "roadster", "check-with-dotted"));

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
