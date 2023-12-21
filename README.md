# Mega_List
## Introduction:
Makes or edits text files that act as lists with simple functionalities, such as sorting, starring, and categorizing. 
To use this program, simply run the jar file and follow the given prompts.

Normal Lists are just txt files that you can shuffle and sort, Star Lists allow for starring the items, which effectively places them into their own category.
Categorized Lists allow for as many categories as you want and name/rename them. Each category is shuffled and sorted independently, and they always stay seperate from one another.


## Explanation:

All of the different types of lists function as an array list of an ArrayList, the 'MegaList'. 

For Normal lists, only 1 subarray is used, but it is implemented for Star and Categorized lists to build off of. Star has two sub-arrays it uses, one for the starred, one for the unstarred. Categorized lists have as many sub-arrays as there are categories, and start off with 1 'Default:' category. 

Each type of list has its own class, along with runLists which enters a service loop to display prompts, accepts input, and calls functions.

See the code for a more in-depth understanding, it is pretty straightforward.

## Editing:

You can also edit existing txt files as well as creating them. In order to help implement this in a useful way, the program recognizes everything with a
" [*] " as a star and everything that contains a " : " as a category. 

This then requires not allowing any normal items to contain a " [*] " in star lists or a " : " in categorized lists. This is a worthwhile drawback to allow for actually being able to edit the previous star or categorized lists as the program can now recognize their stars and categories and initialize them as such.
