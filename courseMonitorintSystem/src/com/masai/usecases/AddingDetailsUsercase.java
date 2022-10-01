package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AddingDetailsUsercase {

	public static void addCourses() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Course Name");
		String name = sc.nextLine();
//		sc.nextLine();

		System.out.println("Enter Course Description");
		String desc = sc.nextLine();

		System.out.println("Enter Course Fee");
		int fee = sc.nextInt();

		Course course = new Course();
		course.setCourseName(name);
		course.setCourseDescription(desc);
		course.setFees(fee);

		AdminDao ad = new AdminDaoImpl();
		String str = ad.addNewCourse(course);
		System.out.println(str);
		
	}
	
	public static void createBatch() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Course id...");
		int cid = sc.nextInt();

		System.out.println("Enter Number of Students in the batch...");
		int noOfStu = sc.nextInt();

		System.out.println("Enter Batch Start Date");
		String date = sc.next();
		
		sc.nextLine();
		
		System.out.println("Enter batch Duration");
		String duration = sc.nextLine();

		Batch batch = new Batch();
		batch.setCourseId(cid);
		batch.setNumberOfStudents(noOfStu);
		batch.setBatchStartDate(date);
		batch.setDuration(duration);

		AdminDao ad = new AdminDaoImpl();
		String str = ad.createNewBatch(batch);
		System.out.println(str);
		
	}

}
