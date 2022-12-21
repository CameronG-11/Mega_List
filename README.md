# Mega_List
## Introduction:
Makes text files to act as lists with simple functionalities, such as sorting, starring, and categorizing. 
To use this program, simply run the jar file and follow the given prompts.

Normal Lists are just txt files that you can shuffle and sort, Star Lists allow for starring the items, which effively places them into their own category.
Categorized Lists allow for as many categories as you want and name/rename them. Each category is shuffled and sorted independently, and they always stay seperate from one another.

I plan on adding functionality to edit pre-existing lists, but all features included currently work so I figured I might as well put this version out too. 

## Explanation:

All of the different types of lists function as an array list of an arraylist, the 'MegaList'. 

For Normal lists only 1 subarray is used, but it is implemented for Star and Categorized lists to build off of. Star has two sub-arrays it uses, one for the starred, one for the unstarred. Categorized lists have as many sub-arrays as there are categories, and starts off with 1 'Default:' category. 

Each type of list has its own class, along with runLists which enters a service loop to display prompts, accepts input, and calls functions.

See the code for a more in depth understanding, it is all quite straightfowards.
