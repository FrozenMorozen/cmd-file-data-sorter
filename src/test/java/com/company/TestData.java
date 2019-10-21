package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestData {

		public static String FILE_NAME_FOR_CREATING = "/home/denis/test_file.txt";
		public static String FILE_NAME_FOR_WRITING = "/home/denis/out.txt";

		static File createTestFile(String fileName) {
				try {
						return new File(String.valueOf(Files.createFile(Paths.get(fileName))));
				} catch (IOException e) {
						return null;
				}
		}

		public static void deleteTestFile(File file) {
				try {
						if (file != null) {
								Files.delete(Paths.get(file.getAbsolutePath()));
						}

				} catch (IOException e) {
						e.printStackTrace();
				}
		}

		public static List<Object> createStringList() {
				List<Object> rightList = new ArrayList<>();
				rightList.add("ss");
				rightList.add("aa");
				rightList.add("bb");
				rightList.add("cc");
				rightList.add("ff");
				rightList.add("cc");
				rightList.add("uuu");
				return rightList;
		}

}