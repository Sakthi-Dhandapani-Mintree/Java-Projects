package com.stream.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileUseStream {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\M1048135\\Downloads\\ExampleWebACL1.txt");
		try {
			List<String> readAllLines = Files.readAllLines(path);
			readAllLines.stream().map(s -> s.split("\\s+")).flatMap(s -> Arrays.stream(s))
					.distinct().collect(Collectors.toList()).forEach(s -> System.out.println(s));;
			
		} catch (NoSuchFileException fnf) {
			System.out.println(fnf);
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
