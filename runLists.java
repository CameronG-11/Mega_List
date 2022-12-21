package TheList3;

import java.util.Scanner;

//Allows for user friendly use of the Lists programs. Simply follow the onscreen prompts to use
public class runLists {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		String file = "C:\\Users\\camgr\\OneDrive\\Desktop\\ToDoList\\list.txt";
		
		while(true) {
			System.out.println("Enter the type of list you want, N[ormal] or S[tar] or C[ategory]");
	
			String type = input.nextLine();  
			if(! (type.equals("N") || type.equals("n") || 
					type.equals("normal") || type.equals("Normal") || 
					type.equals("S") || type.equals("s") ||
					type.equals("star") || type.equals("Star")||
					type.equals("C") || type.equals("c") || 
					type.equals("Category") || type.equals("Category")) )
				continue;
			

				 if(type.equals("N") || type.equals("n") || type.equals("normal") || type.equals("Normal")) {
					 TheList list = new TheList();
					 Init1(list);
					 break;
				 }
				 else if(type.equals("S") || type.equals("s") || type.equals("star") || type.equals("Star")) {
					 StarList list = new StarList();
					 Init2(list);
					 break;
				 }
				 else {
					 CategoryList list = new CategoryList();
					 Init3(list);
					 break;
				 }
			 
		}
		 
	}
	
	
	public static void Init1(TheList list) {
		System.out.println("-Normal List-");
		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use to file to actually update your file");
		while(true) {
			
			System.out.println("Enter what you want to do:");
			String next = input.nextLine(); 
			if(next.equals("EXIT"))
				break;
			
			if(next.equals("ls"))
				list.ls();
			else if(next.equals("print"))
				list.print();
			else if(next.equals("reset"))
				list.resetMega();
			else if(next.equals("sort")) {
				list.sortMega();
				list.print();
			}
			else if(next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			}
			else if(next.equals("add")) {
				while(true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.add(word);
				}
			}
			else if(next.equals("remove")) {
				while(true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.remove(word);
				}
			}
			else if(next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				String newFile = input.nextLine();
				list.toFile(newFile);
			}
			else
				System.out.println("incorrect input");
			
		}	
		list.print();
	}
	
	public static void Init2(StarList list) {
		System.out.println("-Star List-");
		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use to file to actually update your file");
		while(true) {
			
			System.out.println("");
			System.out.println("Enter what you want to do:");
			String next = input.nextLine(); 
			if(next.equals("EXIT"))
				break;
			
			if(next.equals("ls"))
				list.ls();
			else if(next.equals("print"))
				list.print();
			else if(next.equals("reset"))
				list.resetMega();
			else if(next.equals("sort")) {
				list.sortMega();
				list.print();
			}
			else if(next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			}	
			else if(next.equals("add")) {
				while(true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.add(word);
				}
			}
			else if(next.equals("remove")) {
				while(true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.remove(word);
				}
			}
			else if(next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				String newFile = input.nextLine();
				list.toFile(newFile);
			}
			else if(next.equals("star")) {
				while(true) {
					System.out.println("Enter the word you want to star(EXIT to end starring words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.star(word);
				}
			}
			else
				System.out.println("incorrect input");	
		}
		list.print();
	}
	
	public static void Init3(CategoryList list) {
		System.out.println("-Category List-");
		
		System.out.println("Use ls to see the possible functions and type EXIT to end the program");
		System.out.println("Make sure to use to file to actually update your file");
		while(true) {
			
			System.out.println("Enter what you want to do:");
			String next = input.nextLine(); 
			if(next.equals("EXIT"))
				break;
			
			if(next.equals("ls")) {
				list.ls();
				System.out.println("");
			}
			else if(next.equals("print"))
				list.print();
			else if(next.equals("reset"))
				list.resetMega();
			else if(next.equals("sort")) {
				list.sortMega();
				list.print();
			}
			else if(next.equals("shuffle")) {
				list.shuffleMega();
				list.print();
			}	
			else if(next.equals("add")) {
				while(true) {
					System.out.println("Enter the word you want to add(EXIT to end adding words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.add(word);
				}
			}
			else if(next.equals("remove")) {
				while(true) {
					System.out.println("Enter the word you want to remove(EXIT to end removing words):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.remove(word);
				}
			}
			else if(next.equals("to file")) {
				System.out.println("Enter the filepath to the file you want to write to or create");
				System.out.println("[Ex formatting:] C:\\\\Users\\\\username\\\\Downloads\\\\file1.txt");
				String newFile = input.nextLine();
				list.toFile(newFile);
			}
			else if(next.equals("rename category")) {
				while(true) {
					System.out.println("Enter the category you want to rename(EXIT to stop):");
					String cat = input.nextLine();
					if(cat.equals("EXIT"))
						break;
					System.out.println("Enter what you want to change it to(EXIT to stop):");
					String name = input.nextLine();
					if(name.equals("EXIT"))
						break;
					list.renameCategory(cat, name);
				}
			}
			else if(next.equals("add category")) {
				while(true) {
					System.out.println("Enter the name of a category to add(EXIT to adding):");
					String word = input.nextLine();
					if(word.equals("EXIT"))
						break;
					list.addCategory(word);
				}
			}
			else if(next.equals("add to")) {
				while(true) {
					System.out.println("Enter the category you want to add to(EXIT to stop):");
					String cat = input.nextLine();//cat is first
					if(cat.equals("EXIT"))
						break;
					if(!list.isCat(cat)){
						System.out.println("incorrect category input");
						continue;
					}		
					
					while(true) {
						System.out.println("Enter the word you want to add(EXIT to stop):");
						String word = input.nextLine();
						if(word.equals("EXIT"))
							break;
						list.addTo(word, cat);
					}
				}
			}
			else if(next.equals("move to")) {
				while(true) {
					System.out.println("Enter the category you want to move to(EXIT to stop):");
					String cat = input.nextLine();
					if(cat.equals("EXIT"))
						break;
					if(!list.isCat(cat)){
						System.out.println("incorrect category input");
						continue;
					}		
					
					while(true) {
						System.out.println("Enter the word you want to move(EXIT to stop):");
						String word = input.nextLine();
						if(word.equals("EXIT"))
							break;
						list.moveTo(word, cat);
					}
				}
			}
			else if(next.equals("remove category")) {
				while(true) {
					System.out.println("Enter the category you want to remove(EXIT to stop):");
					String cat = input.nextLine();
					if(cat.equals("EXIT"))
						break;
					if(!list.isCat(cat)){
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