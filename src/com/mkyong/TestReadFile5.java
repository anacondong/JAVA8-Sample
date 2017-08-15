package com.mkyong;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestReadFile5 {
	public static void main(String args[]) {

		String fileName = "c://logs.txt";

		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
