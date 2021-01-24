package com.Simplilearn.Finalproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class mainOperation {
	public String operations(int option) {
		String list = null;

		Scanner sc1 = new Scanner(System.in);
		switch (option) {
		case 1:
			System.out.println("File names");
			readFIles();
			break;

		case 2:
			int newoption = menuin(sc1);

			switch (newoption) {

			case 1:
				createfile();
				break;
			case 2:
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter File Name To Delete \n");
				String value = sc.next();

				Delete(value);
				int op = sc.nextInt();
				if (op == 1) {
					System.out.println("return\n");

				}
				break;
			case 3:
				System.out.println("Enter File name to Search");
				Scanner sc11 = new Scanner(System.in);
				searcFile(sc11);

				break;
			case 4:
				menumain();
				System.out.println("  Press 4 toGo back to main menu");
				break;

			default:
				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}
			// sc1.close();

			break;

		case 3:
			System.out.println("Closing The Application.....");
			System.exit(0);
			break;

		default:
			System.out.println("This is not a valid Menu Option! Please Select Another");
			break;
		}
		return list;

	}

	public static int menuin(Scanner sc1) {
		System.out.println("Select File Operation");
		int newoption = 0;
		System.out.println("Press 1 To Add a file to the existing directory list");
		System.out.println("Press 2 To Delete a user specified file from the existing directory list");
		System.out.println("Press 3 To Option to navigate back to the main context");
		System.out.println("Press 4 To Go back to main menu");

		try {
			newoption = sc1.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		} finally {
			// sc1.close();
		}
		return newoption;
	}

	public static void searcFile(Scanner sc) {
		String rootDir = "H:\\file operations";
		File file = new File(rootDir);

		File[] files = file.listFiles();

		ArrayList<String> listfile = new ArrayList<String>();

		for (File eachfile : files) {
			if (eachfile.isDirectory()) {
				File[] folderfile = eachfile.listFiles();
				for (File f1 : folderfile) {

					listfile.add(f1.getName());
				}
			}
			listfile.add(eachfile.getName());

		}

		// Arrays.sort(array);

		String array[] = new String[listfile.size()];
		for (int j = 0; j < listfile.size(); j++) {
			array[j] = listfile.get(j);

		}
		// for(String k: array)
		// {
		// System.out.println(k);
		// }
		bsort(array);
		String search = sc.next();
		int searchIndex = binarySearch(array, search);

		System.out.println(searchIndex != -1 ? array[searchIndex] + " - Index is " + searchIndex : "Not found");
		try {
			System.out.println("Press 1 togo back to  menu");
			int opt = sc.nextInt();
			// mainOperation op = new mainOperation();
			// op.operations(option);
			if (opt != 0) {
				menuin(sc);
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
		} finally {
			sc.close();
		}
	}

	public static void bsort(String str[]) {
		String temp;
		for (int j = 0; j < str.length; j++) {
			for (int i = j + 1; i < str.length; i++) {
				// comparing adjacent strings
				if (str[i].compareTo(str[j]) < 0) {
					temp = str[j];
					str[j] = str[i];
					str[i] = temp;
				}

			}
			// System.out.println(str[j]);
		}
	}

	public static int binarySearch(String[] a, String x) {
		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (a[mid].compareTo(x) < 0) {
				low = mid + 1;
			} else if (a[mid].compareTo(x) > 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public void createfile() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter File Name To Create \n");
			String value = sc.next();

			String data = "hello";
			String rootDir = "H:\\file operations";
			Path path = Paths.get(rootDir, value);
			Files.write(path, data.getBytes(), StandardOpenOption.CREATE_NEW);

		} catch (InputMismatchException e) {
			System.out.println("type mismatch ");
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			System.out.println("File exists ");
		} catch (Exception e1) {
			System.out.println("type mismatch ");
		}

		System.out.println("The file is created");
		System.out.println("Press 1 to go back to main menu ");
		try {
			int meb = sc.nextInt();
			if (meb != 0) {
				// menumain();
				menuin(sc);
			} else {
				System.out.println("Invalid Input ");
			}
		} catch (Exception e1) {
			System.out.println("Invalid Input ");
		} finally {
			sc.close();
		}
	}

	private static void Delete(String name) {
		Scanner sc4 = new Scanner(System.in);
		String filepath = "H:\\file operations";
		Path path = Paths.get(filepath, name);
		try {
			// System.out.println(path);
			boolean f = Files.deleteIfExists(path);
			if (f) {
				System.out.println("Deleted");
			}
		} catch (NoSuchFileException ee) {
			System.out.println("No Such File Exists");
		} catch (NoSuchElementException ne) {
			System.out.println("No Such File Exists");
		} catch (DirectoryNotEmptyException de) {
			System.out.println("Directory Is Not Empty");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No Such File Exists");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Such File Exists");
		}
		try {
			System.out.println("Press1 to coninue");
			int res1 = sc4.nextInt();
			if (res1 != 0) {
				menuin(sc4);
			}
		} catch (Exception e) {
			System.out.println("invalid Selection");
		} finally {
			sc4.close();
		}

	}
 
	public static void extracted() {

		System.out.println("\n**************************************\n");
		System.out.println("Welcome To Lockers Pvt. Ltd.\n ");
		System.out.println("Visit our Website :https://LockedMe.com \n");

		System.out.println("Application Name: LockedMe.com\n");

		System.out.println("Developer Name : Varun kumar\n");

		System.out.println("Developer Details:\nEmail: varunmanila@gmail.com\n");
		System.out.println("**************************************");
	}

	private static void readFIles() {
		Scanner sc = new Scanner(System.in);
		String rootDir = "H:\\file operations";
		File file = new File(rootDir);
		// File file = new File("H:\\file operations");
		File[] files = file.listFiles();
		//TreeSet<String> ts = new TreeSet<String>();
		 ArrayList<String> listfile = new ArrayList<String>();
		 
		 for(File eachfile : files ) {
				if(eachfile.isDirectory()) {
					File [] folderfile = eachfile.listFiles();
					for(File f1 : folderfile) {
						System.out.println(f1.getName());
						listfile.add(f1.getName());
					}
				}else {
				System.out.println(eachfile.getName());
				//listfile.add(eachfile.getName());
				//System.out.println(ts);
				//
				}
			}
		Collections.sort(listfile);  
		for (String nfiles :listfile) {
			System.out.println(nfiles);
		}
		try {
			System.out.println("press 1 to main menu ");
			int meb = sc.nextInt();
			if (meb == 1) {
				menumain();
			} else {
				System.out.println("Invalid Input ");
			}
		} catch (Exception e1) {
			System.out.println("Invalid Input ");
		} finally {
			sc.close();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		extracted();

		menumain();
	}

	public static void menumain() {
		System.out.println(" Press 1 to Display Existing files ");
		System.out.println(" Press 2 to File operations");
		System.out.println(" Press 0 to Close The application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter yor choice");

		try {
			int option = sc.nextInt();
			mainOperation op = new mainOperation();
			op.operations(option);
		} catch (Exception e) {
			System.out.println("Invalid Input");
		} finally {
			sc.close();
		}
	}

}
