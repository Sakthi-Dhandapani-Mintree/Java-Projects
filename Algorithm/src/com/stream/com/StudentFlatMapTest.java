package com.stream.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
	private String name;
	private Set<String> book;

	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<String>();
		}
		this.book.add(book);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", book=" + book + "]";
	}

}

public class StudentFlatMapTest {
	public static void main(String[] arg) {

		Student student = new Student();
		student.setName("Sakthi");
		student.addBook("Java");
		student.addBook("C++");
		Student student2 = new Student();
		student2.setName("Sakthi1");
		student2.addBook("Java1");
		student2.addBook("C++1");
		List<Student> listOfStudent = new ArrayList<Student>();
		listOfStudent.add(student2);
		listOfStudent.add(student);

		List<String> st = listOfStudent.stream().map(x -> x.getBook()).flatMap(y -> y.stream()).distinct()
				.collect(Collectors.toList());
		st.forEach(x -> System.out.print(" "+x));
	}

}
