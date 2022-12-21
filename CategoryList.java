package TheList3;

import java.util.Collections;
import java.util.ArrayList;

//Does everything TheList does, with the addition of categories 
//All categories are shuffled/sorted separately
public class CategoryList extends TheList {

	public CategoryList() {
		super();
		MegaList.get(0).add(0, "Default:"); //default name, they can change it themselves
	}
	
	public CategoryList(String fileName) {
		super(fileName);
		MegaList.get(0).add(0, "Default:");
	}
	
	public CategoryList(String fileName, String firstName) {
		super(fileName);
		MegaList.get(0).add(0, firstName);
	}
	
	public CategoryList(String fileName, String[] names) {
		super(fileName);
		MegaList.get(0).add(0, names[0]);
		for(int i = 1; i < names.length; i++) 
			addCategory(names[i]);	
	}
	
	public void renameCategory(int place, String name) {
		MegaList.get(place).set(0, name);
	}
	
	public void renameCategory(String cat, String name) {
		int place = 0;
		boolean wasFound = false;
		for(int i = 0; i < MegaList.size(); i++) {
			if(MegaList.get(i).get(0).equals(cat)) {
				place = i;
				wasFound = true;
			}
		}
		if(!wasFound) {
			System.out.println("Incorrect category name entered");
			//do nothing
		}
		else { //was found
			MegaList.get(place).set(0, name);
		}
	}
	
	public void addCategory() {
		ArrayList<String> empty = new ArrayList<String>();
		MegaList.add(empty);
		MegaList.get(MegaList.size()-1).add("New Category");
	}
	
	public void addCategory(String name) {
		ArrayList<String> empty = new ArrayList<String>();
		MegaList.add(empty);
		MegaList.get(MegaList.size()-1).add(name);
	}
	
	public void sortMega() {//must be different to avoid sorting/shuffling the name of the category
		for(int i = 0; i < MegaList.size(); i++) {
			String first = MegaList.get(i).remove(0);
			Collections.sort(MegaList.get(i)); 
			MegaList.get(i).add(0, first);
		}
		hasBeenSorted = true;
	}
	
	public void shuffleMega() {
		for(int i = 0; i < MegaList.size(); i++) { 
			String first = MegaList.get(i).remove(0);
			Collections.shuffle(MegaList.get(i)); 
			MegaList.get(i).add(0, first);
		}
	}
	
	
	
	public void addTo(String item, int category) {
		add(item, category);
	}
	
	public void addTo(String item, String category) {	
		int place = MegaList.size()-1;
		
		for(int i = 0; i < MegaList.size(); i++) {
			if(MegaList.get(i).indexOf(category) != -1)
				place = i;
		}
		
		addTo(item, place);
	}
	
	public void moveTo(String item, String category) {
		remove(item);
		addTo(item,category);
	}
	
	
	public boolean isCat(String category) {	
		for(int i = 0; i < MegaList.size(); i++) {
			String word = MegaList.get(i).get(0);
			if(word.equals(category))
				return true;
		}	
		return false;
	}
	
	public void removeCat(String category) {
		for(int i = 0; i < MegaList.size(); i++) {
			String word = MegaList.get(i).get(0);	
			if(word.equals(category)) 
				MegaList.remove(i);				
		}	
	}
	
	public void print() {//printing forwards
		for (int i = 0; i < MegaList.size(); i++) {
			printList(MegaList.get(i));
			System.out.println();
		}
	}
	
	public void ls() {
		super.ls();
		
		System.out.println("Category specific calls:");
		System.out.println("add to");
		System.out.println("move to");
		System.out.println("add category");
		System.out.println("rename category");
		System.out.println("remove category");
	}
	
}