package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to our Student Management System");

		while (true) {
			System.out.println("\n1. Login as Admin \n2. Login as Faculty");
			System.out.println("Enter Your Choice..");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1) {
				if (AdminLoginUsecase.login() == true) {
					System.out.println("Login Sucessfull..");
					

					while (true) {
						System.out.println("===========================================");
						System.out.println("Select One Option:-");
						System.out.println("\n1. Add new course \n2. Update course fee by 10 percent\n3. " + 
											"See all Courses \n4. Create new Batch \n5. "
											+ "Update No of Students in a batch \n6. See all ongoing batches \n7.");
						int x = sc.nextInt();

						switch (x) {
							case 1: {
								AddingDetailsUsercase.addCourses();
								break;
							}
							case 2: {
								System.out.println("Enter The course id to update the fees of that course");
								int f = sc.nextInt();
								AdminDao ad = new AdminDaoImpl();
								String str = ad.updateFeeBY10Percent(f);
								System.out.println(str);
								break;
							}
							case 3: {
								AdminDao ad = new AdminDaoImpl();
								try {
									List<Course> list = ad.getAllCources();
									list.forEach(res -> System.out.println(res));
								} catch (AdminException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 4: {
								AddingDetailsUsercase.createBatch();
								break;
							}
							case 5: {
								System.out.println("Enter updated no. of students");
								int a = sc.nextInt();
								System.out.println("Enter The Batch id to update the no. of students of that batch");
								int b = sc.nextInt();
								AdminDao ad = new AdminDaoImpl();
								String str = ad.updatenoOfStudentInBatch(a, b);
								System.out.println(str);
								break;
							}
							case 6: {
								AdminDao ad = new AdminDaoImpl();
								try {
									List<Batch> list = ad.seeAllOnGoingBatches();
									list.forEach(res -> System.out.println(res));
								} catch (AdminException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
						}
					}

				}

			} else if (choice == 2) {

			}

		}

	}

}
