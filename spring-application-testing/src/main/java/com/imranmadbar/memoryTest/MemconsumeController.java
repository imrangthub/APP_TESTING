package com.imranmadbar.memoryTest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imranmadbar.HomeController;
import com.imranmadbar.dto.Person;

@RestController
public class MemconsumeController {

	@GetMapping("/memtest1") // Consume memory but GC clean the Heap
	public String memtest1(@RequestParam(name="countVal",required=false) Integer countVal) {
        if(countVal ==null)countVal = 500000;
		List<Person> personList = new ArrayList();
		for (int i = 1; i <= countVal; i++) {
			System.out.println("Step " + i);
			personList.add(new Person("MD IMRAN HOSSAIN", "Male"));
		}
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Total memory is megabytes: " + bytesToMegabytes(runtime.totalMemory()));
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

		return "Used memory is megabytes: " + bytesToMegabytes(memory);
	}

	public static List<Person> personList = new ArrayList();

	@GetMapping("/memtest0") // Consume memory but GC can't able to clean the Heap because static rererence
	public String memtest0(@RequestParam(name="countVal",required=false) Integer countVal) {
	       if(countVal ==null)countVal = 500000;
		for (int i = 1; i <= countVal; i++) {
			System.out.println("Step " + i);
			personList.add(new Person("MD IMRAN HOSSAIN", "Male"));
		}
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Total memory is megabytes: " + bytesToMegabytes(runtime.totalMemory()));
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

		return "Used memory is megabytes: " + bytesToMegabytes(memory);
	}

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

}
