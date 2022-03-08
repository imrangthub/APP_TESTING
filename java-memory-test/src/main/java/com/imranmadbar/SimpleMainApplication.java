package com.imranmadbar;

import java.util.ArrayList;
import java.util.List;

import com.imranmadbar.student.StudentDto;

public class SimpleMainApplication {

	  public static List<StudentDto> stList = new ArrayList();

	
	
	public static void main(String[] arge) {
		System.out.println("#SimpleMainApplication runing start ...");
		


		for (int i = 1; i <= 50000000; i++) {
			System.out.println("Step: " + i);
			
			stList.add(new StudentDto("Korim", "male"));
			

		}

		System.out.println("#SimpleMainApplication runing Done");
	}

}
