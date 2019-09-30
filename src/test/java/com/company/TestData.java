package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestData {
		public static String[] RIGHT_FULL_ARGS = {"/home/denis/source.txt", "/home/denis/out.txt", "-s", "-a"};
		public static String[] WRONG_FULL_ARGS = {"", ""};
		public static String[] RIGHT_HELP_ARGS = {"-h"};
		public static String[] WRONG_HELP_ARGS = {"-hehe"};

		public static String RIGHT_FILE_NAME_FOR_READING = "/home/denis/source.txt";
		public static String WRONG_FILE_NAME = "yuyuddh/home/denis/source.txt";

		public static String FILE_NAME_FOR_WRITING = "/home/denis/out.txt";
		public static List<Object> DATA_FOR_WRITING = new ArrayList<>(); // Сделать нормальную иниф=циализацию

		public static int WRONG_FULL_ARGS_LENGTH = 48;
		public static int WRONG_HELP_ARGS_LENGTH = 132;

		public static String TEST_FILE_NAME = "/home/denis/test_file.txt";

		public static List<Object> RIGHT_STRING_LIST_FOR_VALIDATE = createStringList(); // Сделать нормальную иниф=циализацию
		public static List<Object> RIGHT_INTEGER_LIST_FOR_VALIDATE = new ArrayList<>(); // Сделать нормальную иниф=циализацию
		public static List<Object> WRONG_LIST_FOR_VALIDATE = null;

		public static String RIGHT_STRING_DATA_TYPE_ARG = "-s";
		public static String RIGHT_INTEGER_DATA_TYPE_ARG = "-i";
		public static String WRONG_DATA_TYPE_ARG = "-psjsjs";

		public static File createTestFile(String fileName) {
				try {
						return new File(String.valueOf(Files.createFile(Paths.get(fileName))));
				} catch (IOException e) {
						return null;
				}
		}

		public static boolean deleteTestFile(String fileName) {
				try {
						Files.delete(Paths.get(fileName));
						return true;

				} catch (IOException e) {
						return false;
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

		public static List<Object> createIntegerList() {
				List<Object> rightList = new ArrayList<>();
				rightList.add(1);
				rightList.add(9);
				rightList.add(5);
				rightList.add(5);
				rightList.add(78);
				rightList.add(0);
				rightList.add(8);
				return rightList;
		}
}