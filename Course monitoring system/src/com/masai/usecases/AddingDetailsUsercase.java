package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
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
		
		
		sc.close();
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
		
		sc.close();
	}
	
	public static void createFaculty() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name of faculty");
		String name = sc.nextLine();

		System.out.println("Enter address of faculty");
		String address = sc.nextLine();

		System.out.println("Enter mobile of faculty");
		String mobile = sc.nextLine();

		System.out.println("Enter email of faculty");
		String email = sc.nextLine();

		System.out.println("Enter Username of faculty");
		String username = sc.nextLine();

		System.out.println("Enter Password of faculty");
		String password = sc.nextLine();
		
		
		Faculty fac = new Faculty(name,address,mobile,email,username,password);

		AdminDao ad = new AdminDaoImpl();
		String str = ad.createNewFaculty(fac);
		System.out.println(str);
		
		sc.close();
	}
	
	public static void createCoursePlan() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Batch id...");
		int bid = sc.nextInt();
		
		System.out.println("Enter Day no...");
		int dayNo = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Topic...");
		String topic = sc.nextLine();
		
		System.out.println("Enter Status --- completed/pending");
		String status = sc.nextLine();
		
		CoursePlan cp = new CoursePlan(bid,dayNo,topic,status);
		
		AdminDao ad = new AdminDaoImpl();
		String str = ad.createCoursePlan(cp);
		System.out.println(str);
		
		sc.close();
	}

}
