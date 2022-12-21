package TheList3;

import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.Collections;  
import java.io.FileWriter;  
import java.io.IOException;  

//A text file creator which can add, remove, shuffle, and sort items in a text file.
public class TheList {

protected ArrayList<String> file = new ArrayList<String>(); 
protected ArrayList<ArrayList<String>> MegaList = new ArrayList<ArrayList<String>>(); 
//MegaList is how separate categories are made, and TheList only really has 1 category, so it goes
//unused here. It is implemented here for use in Star and Category.
protected boolean hasBeenMade = false;
protected boolean hasBeenSorted = false;
	

	public TheList() {//default
		ArrayList<String> empty = new ArrayList<String>(); 
		file = empty;
		MegaList.add(file);
	}//default
	
	public TheList(String fileName) {//custom
		
		try {
			File myObj = new File(fileName);
			Scanner scan = new Scanner(myObj);
			while (scan.hasNextLine()) {
				String data = scan.nextLine();
				file.add(data); //adding to list instead of just printing
			}
	      scan.close();
	    } 
		catch (FileNotFoundException e) {
	    	System.out.println("The file is incorrect.");
	    }
		makeMega();
	}//custom

	public void add(String item, int i) {
		MegaList.get(i).add(item);
		if(hasBeenSorted)
			sortMega();
	}
	
	public void add(String item) {
		add(item, 0);
	}
	
	//public void remove(int place) {
	//	for(int i = 0; i < MegaList.size(); i++)
	//		MegaList.get(i).remove(place);
	//}
	
	public void remove(String item) {
		for(int i = 0; i < MegaList.size(); i++)
			if(!MegaList.get(i).remove(item))
				System.out.println("Failed to remove, " + item + " is not in the list.");
	}
	
	public void remove(String[] items) {//will remove all (first)instances!
		for(int i = 0; i < MegaList.size(); i++)
			for(int j = 0; j < items.length; j++)
				MegaList.get(i).remove(items[j]);
	}
	
	public void makeMega() {//Mega
		if (hasBeenMade)
			return;
		ArrayList<String> temp = new ArrayList<String>(); 
		for(int i = 0; i < file.size(); i++) 
				temp.add(file.get(i));
		MegaList.add(temp);
		hasBeenMade = true;
	}//Mega
	
	public void resetMega() {//Overide Mega 
		ArrayList<String> temp = new ArrayList<String>(); 
		for(int i = 0; i < file.size(); i++) 
				temp.add(file.get(i));
		MegaList.clear();
		MegaList.add(temp);
	}//Overide Mega
	
	public void sortMega() {
		for(int i = 0; i < MegaList.size(); i++) 
			Collections.sort(MegaList.get(i)); 
		hasBeenSorted = true;
	}
	
	public void shuffleMega() {
		for(int i = 0; i < MegaList.size(); i++) 
			Collections.shuffle(MegaList.get(i)); 
	}
		
	protected void printList(ArrayList<String> fle) {//Protected
		for (int i = 0; i < fle.size(); i++)
			System.out.println(fle.get(i));
	}
	
	public void print() {
		printList(MegaList.get(0));
	}
	
	protected void createFile(String file) {
		try {//first create make the file
			File myObj = new File(file);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		}
	}
	
	public void toFile(String file) {
		this.createFile(file);//making sure said file is created already
		try { 
			FileWriter myWriter = new FileWriter(file);
			for(int i = 0; i < MegaList.size(); i++)
				for(int j = 0; j < MegaList.get(i).size(); j++)
				myWriter.write(MegaList.get(i).get(j) + "\n");
			myWriter.close();
			//System.out.println("Successfully wrote to the file.");
	    	}
			catch (IOException e) {
	    		System.out.println("An error occurred.");
	    	}
	}
	
	public void ls() {
		System.out.println("Basic calls:");
		System.out.println("add");
		System.out.println("remove");
		System.out.println("sort");
		System.out.println("shuflle");
		System.out.println("reset");
		System.out.println("print");
		System.out.println("to file");
	}
	

}