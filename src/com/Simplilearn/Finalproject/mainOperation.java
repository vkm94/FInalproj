package com.Simplilearn.Finalproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

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
			
			int newoption=0;
			
			newoption = menu1(sc1, newoption);
			switch (newoption) {

			case 1:
				createfile();
				
				break;
			case 2:
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter File Name To Create \n");
			     String value = sc.next();
				System.out.println("  Press 2 to Delete a user specified file from the existing directory list");
				Delete(value);
				
				
				break;
			case 3:
				System.out.println("  Press 3 to Option to navigate back to the main context");
				break;
			case 4:
				System.out.println("  Press 4 toGo back to main menu");
				break;

				
			default:
				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}
			//sc1.close();
			
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


	public void createfile() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter File Name To Create \n");
		     String value = sc.next();
			
			String data ="hello";
			String rootDir ="H:\\file operations";
				Path path =Paths.get(rootDir, value);
			Files.write(path, data.getBytes(), StandardOpenOption.CREATE_NEW);
			
			}
			catch(InputMismatchException e){
			System.out.println("type mismatch ");
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				System.out.println("File exists ");
			}
			catch(Exception e1) {
			System.out.println("type mismatch ");
			}
			finally {
			sc.close();
			}

		System.out.println("The file is created");
	}
	
	private static void Delete(String name) {
		String filepath ="H:\\file operations";
		Path path = Paths.get(filepath,name);
        try {
        	
    		//Path path1 = Paths.get(filepath, name);
    		System.out.println(path);
    		 Files.deleteIfExists(path);
    		
    	}
       
        catch(NoSuchFileException ee) {
        	System.out.println("No Such File Exists");
		}catch(NoSuchElementException ne) {
			System.out.println("No Such File Exists");
		}
        catch(DirectoryNotEmptyException de){
        	System.out.println("Directory Is Not Empty");
        }
        catch (IOException e) {
			// TODO Auto-generated catch block
        	System.out.println("No Such File Exists");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Such File Exists");
		}
       
		
	}

	public int menu1(Scanner sc1, int newoption) {
		System.out.println("Select File Operation");

		System.out.println("Add a file to the existing directory list");
		System.out.println("Delete a user specified file from the existing directory list");
		System.out.println("Option to navigate back to the main context");
		System.out.println("Go back to main menu");
		
		try {
			 newoption = sc1.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input");
			}finally {
				//sc1.close();
			}
		return newoption;
	}

	public static void extracted() {
		System.out.println("Welcome To Lockers Pvt. Ltd. ");
		System.out.println("Visit our Website :https://LockedMe.com ");
		System.out.println("Application Name: LockedMe.com");
		System.out.println("Developer Name : Varun kumar");
		System.out.println("Developer Details:\n Email: varunmanila@gmail.com");
	}

	private static void readFIles() {
		String rootDir ="H:\\file operations";
		File file =	new File(rootDir);
	//File file = new File("H:\\file operations");
	File[] files = file.listFiles();
	   TreeSet<String> ts = new TreeSet<String>();

	for(File eachfile : files ) {
		if(eachfile.isDirectory()) {
			File [] folderfile = eachfile.listFiles();
			for(File f1 : folderfile) {
				//System.out.println(f1.getName());
				ts.add(f1.getName());
			}
		}
		System.out.println(eachfile.getName());
		//ts.add(eachfile.getName());
		///System.out.println(ts);
		for(String nfiles : ts ) {
			 System.out.println(nfiles);
		}
	}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		extracted(); 

		System.out.println(" Press 1 to Display Existing files ");
		System.out.println(" Press 2 to File operations");
		System.out.println(" Press 0 to Close The application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter yor choice");

		int option = sc.nextInt();

		mainOperation op = new mainOperation();
		op.operations(option);
		sc.close();
	}

}
