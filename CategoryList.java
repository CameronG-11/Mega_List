package Lists;

import java.util.Collections;
import java.util.ArrayList;

//Does everything TheList does, with the addition of customizable categories 
//All categories are shuffled/sorted separately
public class CategorizedList extends TheList {

	public CategorizedList() {
		super();
		MegaList.get(0).add(0, "Default:"); // default name, they can change it themselves
	}

	public CategorizedList(String fileName) {
		super(fileName);
		initializeCategorized();
		MegaList.get(0).add(0, "Default:");
	}

	public void renameCategory(String cat, String name) {
		int place = 0;
		boolean wasFound = false;
		for (int i = 0; i < MegaList.size(); i++) {
			if (MegaList.get(i).get(0).equals(cat)) {
				place = i;
				wasFound = true;
			}
		}
		if (!wasFound) {
			System.out.println("Incorrect category name entered");
			// do nothing
		} else { // was found
			MegaList.get(place).set(0, name + ":");
		}
	}

	public void addCategory(String name) {
		ArrayList<String> empty = new ArrayList<String>();
		MegaList.add(empty);
		MegaList.get(MegaList.size() - 1).add(name + ":");
	}

	public void sortMega() {// must be different to avoid sorting/shuffling the name of the category
		for (int i = 0; i < MegaList.size(); i++) {
			String first = MegaList.get(i).remove(0);
			Collections.sort(MegaList.get(i));
			MegaList.get(i).add(0, first);
		}
		hasBeenSorted = true;
	}

	public void shuffleMega() {
		for (int i = 0; i < MegaList.size(); i++) {
			String first = MegaList.get(i).remove(0);
			Collections.shuffle(MegaList.get(i));
			MegaList.get(i).add(0, first);
		}
	}

	public void add(String item, int i) {
		if (isCategory(item))
			System.out.println("Failure, cannot add a word that is marked as a category, that contains a :");
		else
			super.add(item, i);
	}

	public void addTo(String item, int category) {
		add(item, category);
	}

	public void addTo(String item, String category) {
		int place = MegaList.size() - 1;

		for (int i = 0; i < MegaList.size(); i++) {
			if (MegaList.get(i).indexOf(category) != -1)
				place = i;
		}

		addTo(item, place);
	}

	public void moveTo(String item, String category) {
		remove(item);
		addTo(item, category);
	}

	public void removeCat(String category) {
		for (int i = 0; i < MegaList.size(); i++) {
			String word = MegaList.get(i).get(0);
			if (word.equals(category))
				MegaList.remove(i);
		}
	}

	public boolean isCategory(String word) {
		return word.contains(":");
	}

	private void initializeCategorized() {

		int j = 0;
		for (int i = 0; i < MegaList.get(0).size(); i++) {
			String item = MegaList.get(0).get(i);
			if (isCategory(item)) {
				remove(item); // remove from normal category
				item = item.substring(0, item.length() - 1); // cut out the :
				addCategory(item);
				i--; // removed an item, so don't move forwards
				j++; // start adding items to this category
			} else { // is an item
				if (j != 0) { // if in first category, keep it there
					remove(item);
					add(item, j);
					i--; // removed an item, so don't move forwards
				}
			}
		}

	}

	public void print() {// printing forwards
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
