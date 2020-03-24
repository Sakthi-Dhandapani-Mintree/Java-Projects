package com.stream.com;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {

	public static void main(String[] args) {
		String fileName = "D:\\temp\\application.log";
		try(Stream<String> lines=Files.lines(Paths.get(fileName))){
//			lines.forEach(System.out::println);
			lines.filter(s ->s.contains("Caused by:")).forEach(System.out::println);
		}catch(Exception fn) {
			System.out.println(fn.getMessage());
		}
		System.out.println("Exception Hadled very well");
	}

}
