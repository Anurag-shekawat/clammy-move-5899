package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;

public class AdminLoginUsecase {
	
	public static boolean login() {
		boolean res = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username..");
		String username = sc.next();
		System.out.println("Enter password..");
		String password = sc.next();
		
		try {
			AdminDao ad = new AdminDaoImpl();
			ad.loginAdmin(username, password);
			res = true;
//			System.out.println("Welcome "+str);
		} catch (AdminException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
//		sc.close();
		
		return res;
		
	}

	
	
	
	
}
