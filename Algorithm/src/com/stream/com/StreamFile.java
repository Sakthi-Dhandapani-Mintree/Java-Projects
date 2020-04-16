package com.stream.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

	public static void main(String[] args) {
		Path path = Paths.get("D:\\logs\\test.log");
		try (Stream<String> line = Files.lines(path)) {
			List<String> lines = line.filter(s -> s.contains(" Spring Boot")).distinct().collect(Collectors.toList());
			lines.forEach(System.out::println);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
