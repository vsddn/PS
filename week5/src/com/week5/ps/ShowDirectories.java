package com.week5.ps;

import java.io.File;
import java.util.Scanner;

public class ShowDirectories {

	public static void main(String[] args) {
		System.out.println("Enter the path of the directory: ");
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		try {
		File directory =  new File(path);
		String[] files = directory.list();
		for (String file : files) {
			System.out.println(file);
		}
		}catch(Exception e) {
			e.getMessage();
		}  finally {
			sc.close();
		}
		
	}

}
