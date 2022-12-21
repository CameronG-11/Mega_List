package TheList3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Does everything TheList does, with the additional ability to star items
//Starred and Non-Starred items are shuffled/sorted separately
public class StarList extends TheList {

	public StarList() {
		super();//other super doesn't call make makeMega
		ArrayList<String> e = new ArrayList<String>();
		MegaList.add(e); //StarList is basically just a 
	}
		
	public StarList(String fileName) {
		super(fileName);
	}
	
	public void makeMega() {//Mega
		super.makeMega();
		ArrayList<String> empty = new ArrayList<String>();
		MegaList.add(empty);//setting up to be able to add to the starred list
	}//Mega
	
	public void print() {
		printList(MegaList.get(1));
		printList(MegaList.get(0));
	}
	
	public void star(int place) {
		if(place >= MegaList.get(0).size() || place < 0)//is an invalid index
			System.out.println("Failed to star, the given item is not in the list");
		else { //is a valid index
			String temp = MegaList.get(0).get(place);
			temp = temp + "[*]";
			MegaList.get(0).remove(place);
			MegaList.get(1).add(temp);
		}
	}
	
	public void star(int[] places) {
		for(int i = 0; i < places.length; i++) 
			star(places[i]);
	}
	
	public void star(String word) {
		int place = MegaList.get(0).indexOf(word); 
		star(place);
	}
	
	public void star(String[] words) {
		for(int i = 0; i < words.length; i++) 
			star(words[i]);
	}
	
	public void starAll(String word) {
		int place = MegaList.get(0).indexOf(word);
		while(place < MegaList.get(0).size() && place >= 0) {
			star(place);
			place = MegaList.get(0).indexOf(word);
		}
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
		      e.printStackTrace();
		    }
	}
	
	public void toFile(String file) {
		this.createFile(file);//making sure said file is created already
		try { 
			FileWriter myWriter = new FileWriter(file);
			
			for(int j = 0; j < MegaList.get(1).size(); j++)
				myWriter.write(MegaList.get(1).get(j) + "\n");
			for(int i = 0; i < MegaList.get(0).size(); i++)
				myWriter.write(MegaList.get(0).get(i) + "\n");
			
			myWriter.close();
			//System.out.println("Successfully wrote to the file.");
	    	}
			catch (IOException e) {
	    		System.out.println("An error occurred.");
	    		e.printStackTrace();
	    	}
	}
	
	public void ls() {
		super.ls();
		
		System.out.println("Star specific calls:");
		System.out.println("star");
	}
	
}
