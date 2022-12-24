package Lists;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Does everything TheList does, with the additional ability to star items
//Starred and Non-Starred items are shuffled/sorted separately
public class StarList extends TheList {

	public StarList() {
		super();// other super doesn't call make makeMega
		ArrayList<String> e = new ArrayList<String>();
		MegaList.add(e); // StarList is basically just a
	}

	public StarList(String fileName) {
		super(fileName);
		initializeStarred();
	}

	public void makeMega() {// Mega
		super.makeMega();
		ArrayList<String> empty = new ArrayList<String>();
		MegaList.add(empty);// setting up to be able to add to the starred list
	}// Mega

	public void add(String word) {
		if (isStarred(word)) {
			System.out.println("Failure, cannot add a word that is marked as a star ([*])");
		} else {
			super.add(word);
		}
	}

	// would be more efficient to do this while reading the file,
	// but this isn't a computationally intensive program so I am choosing to
	// instead
	// be able to reuse super's constructor and MakeMega
	public void initializeStarred() {
		for (int i = 0; i < MegaList.get(0).size(); i++) {
			String item = MegaList.get(0).get(i);
			if (isStarred(item)) {
				remove(item); // remove from normal category
				super.add(item, 1); // add to star category, skipping the prevention by this.add
				i--;// effectively removing an item, stay in the same place
			}
		}
	}

	public void print() {
		printList(MegaList.get(1));
		printList(MegaList.get(0));
	}

	public void star(int place) {
		if (place >= MegaList.get(0).size() || place < 0)// is an invalid index
			System.out.println("Failed to star, the given item is not in the list");
		else { // is a valid index
			String temp = MegaList.get(0).get(place);
			temp = temp + "[*]";
			MegaList.get(0).remove(place);
			MegaList.get(1).add(temp);
		}
	}

	public void star(String word) {
		int place = MegaList.get(0).indexOf(word);
		star(place);
	}

	public void unstar(String word) {
		if (isStarred(word)) {
			this.remove(word);
			String shortenedWord = word.substring(0, word.length() - 3);
			this.add(shortenedWord);
		} else {
			System.out.println("failed to unstar, the given item is not starred");
		}
	}

	public boolean isStarred(String word) {
		return word.contains("[*]");
	}

	public void createFile(String file) {
		try {// first create make the file
			File myObj = new File(file);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void toFile(String file) {
		this.createFile(file);// making sure said file is created already
		try {
			FileWriter myWriter = new FileWriter(file);

			for (int j = 0; j < MegaList.get(1).size(); j++)
				myWriter.write(MegaList.get(1).get(j) + "\n");
			for (int i = 0; i < MegaList.get(0).size(); i++)
				myWriter.write(MegaList.get(0).get(i) + "\n");

			myWriter.close();
			// System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void ls() {
		super.ls();

		System.out.println("Star specific calls:");
		System.out.println("star");
		System.out.println("unstar");
	}

}
