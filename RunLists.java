package Lists;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


//Allows for user friendly use of the Lists programs. Simply follow the onscreen prompts to use
public class RunLists {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		boolean isCreateOrEdit = false;
		boolean newList = false;

		while (!isCreateOrEdit) {
			System.out.println("Would you like to CREATE or EDIT a list?");
			String create = input.nextLine();

			isCreateOrEdit = true; // will be true still if a valid create or edit

			if (create.equals("CREATE") || create.equals("create") || create.equals("C"))
				newList = true;
			else if (create.equals("EDIT") || create.equals("edit") || create.equals("E"))
				newList = false;
			else
				isCreateOrEdit = false;
		}

		String file = "";
		while (true) {

			if (!newList) {
				System.out.println("Enter the file you want to turn into a list");
				System.out.println("[Ex formatting:] C:\\\\Users\\\\username\\\\Downloads\\\\file1.txt");

				file = input.nextLine();
				try {// first create make the file
					File myObj = new File(file);
					if (myObj.createNewFile()) {
						System.out.println("Entered an uncreated file, try again");
						continue;
					} else {
						System.out.println("Starting with this file");
						break;
					}
				} catch (IOException e) {
					System.out.println("An error occurred.");
				}
			} else {
				break;
			}
		}

		while (true) {

			System.out.println("Enter the type of list you want, N[ormal] or S[tar] or C[ategory]");

			String type = input.nextLine();
			if (!(type.equals("N") || type.equals("n") || type.equals("normal") || type.equals("Normal")
					|| type.equals("S") || type.equals("s") || type.equals("star") || type.equals("Star")
					|| type.equals("C") || type.equals("c") || type.equals("Category") || type.equals("Category")))
				continue;

			if (type.equals("N") || type.equals("n") || type.equals("normal") || type.equals("Normal")) {
				if (newList) {
					TheList list = new TheList();
					InitN(list);
				} else {
					TheList list = new TheList(file);
					InitN(list);
				}
				break;
			} else if (type.equals("S") || type.equals("s") || type.equals("star") || type.equals("Star")) {
				if (newList) {
					StarList list = new StarList();
					InitS(list);
				} else {
					StarList list = new StarList(file);
					InitS(list);
				}
				break;
			} else {
				if (newList) {
					CategorizedList list = new CategorizedList();
					InitC(list);
				} else {
					CategorizedList list = new CategorizedList(file);
					InitC(list);
				}
				break;
			}

		}

	}

	public static void InitN(TheList list) {
		System.out.println("-Normal List-");
		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use \"to file\" to actually update your file");
		while (true) {

			System.out.println("Enter what you want to do:");
			String next = input.nextLine();
			if (next.equals("EXIT"))
				break;

			if (next.equals("ls"))
				list.ls();
			else if (next.equals("print"))
				list.print();
			else if (next.equals("sort")) {
				list.sortMega();
				list.print();
			} else if (next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			} else if (next.equals("add")) {
				while (true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.add(word);
				}
			} else if (next.equals("remove")) {
				while (true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.remove(word);
				}
			} else if (next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				String newFile = input.nextLine();
				list.toFile(newFile);
			} else
				System.out.println("incorrect input");

		}
		list.print();
	}

	public static void InitS(StarList list) {
		System.out.println("-Star List-");
		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use \"to file\" to actually update your file");
		while (true) {

			System.out.println("");
			System.out.println("Enter what you want to do:");
			String next = input.nextLine();
			if (next.equals("EXIT"))
				break;

			if (next.equals("ls"))
				list.ls();
			else if (next.equals("print"))
				list.print();
			else if (next.equals("sort")) {
				list.sortMega();
				list.print();
			} else if (next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			} else if (next.equals("add")) {
				while (true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.add(word);
				}
			} else if (next.equals("remove")) {
				while (true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.remove(word);
				}
			} else if (next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				String newFile = input.nextLine();
				list.toFile(newFile);
			} else if (next.equals("star")) {
				while (true) {
					System.out.println("Enter the word you want to star(EXIT to end starring words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.star(word);
				}
			} else if (next.equals("unstar")) {
				while (true) {
					System.out.println("Enter the word you want to unstar(EXIT to end unstarring words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.unstar(word);
				}
			}

			else
				System.out.println("incorrect input");
		}
		list.print();
	}

	public static void InitC(CategorizedList list) {
		System.out.println("-Category List-");

		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use \"to file\" to actually update your file");
		while (true) {

			System.out.println("Enter what you want to do:");
			String next = input.nextLine();
			if (next.equals("EXIT"))
				break;

			if (next.equals("ls")) {
				list.ls();
				System.out.println("");
			} else if (next.equals("print"))
				list.print();
			else if (next.equals("sort")) {
				list.sortMega();
				list.print();
			} else if (next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			} else if (next.equals("add")) {
				while (true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.add(word);
				}
			} else if (next.equals("remove")) {
				while (true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.remove(word);
				}
			} else if (next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				System.out.println("[Ex formatting:] C:\\\\Users\\\\username\\\\Downloads\\\\file1.txt");
				String newFile = input.nextLine();
				list.toFile(newFile);
			} else if (next.equals("rename category")) {
				while (true) {
					System.out.println("Enter the category you want to rename(EXIT to stop):");
					String cat = input.nextLine();
					if (cat.equals("EXIT"))
						break;
					System.out.println("Enter what you want to change it to(EXIT to stop):");
					String name = input.nextLine();
					if (name.equals("EXIT"))
						break;
					list.renameCategory(cat, name);
				}
			} else if (next.equals("add category")) {
				while (true) {
					System.out.println("Enter the name of a category to add(EXIT to adding):");
					String word = input.nextLine();
					if (word.equals("EXIT"))
						break;
					list.addCategory(word);
				}
			} else if (next.equals("add to")) {
				while (true) {
					System.out.println("Enter the category you want to add to(EXIT to stop):");
					String cat = input.nextLine();// cat is first
					if (cat.equals("EXIT"))
						break;
					if (!list.isCategory(cat)) {
						System.out.println("incorrect category input");
						continue;
					}

					while (true) {
						System.out.println("Enter the word you want to add(EXIT to stop):");
						String word = input.nextLine();
						if (word.equals("EXIT"))
							break;
						list.addTo(word, cat);
					}
				}
			} else if (next.equals("move to")) {
				while (true) {
					System.out.println("Enter the category you want to move to(EXIT to stop):");
					String cat = input.nextLine();
					if (cat.equals("EXIT"))
						break;
					if (!list.isCategory(cat)) {
						System.out.println("incorrect category input");
						continue;
					}

					while (true) {
						System.out.println("Enter the word you want to move(EXIT to stop):");
						String word = input.nextLine();
						if (word.equals("EXIT"))
							break;
						list.moveTo(word, cat);
					}
				}
			} else if (next.equals("remove category")) {
				while (true) {
					System.out.println("Enter the category you want to remove(EXIT to stop):");
					String cat = input.nextLine();
					if (cat.equals("EXIT"))
						break;
					if (!list.isCategory(cat)) {
						System.out.println("incorrect category input");
						continue;
					}
					list.removeCat(cat);
				}
			}

			else
				System.out.println("incorrect input");
		}
		list.print();
	}

}
