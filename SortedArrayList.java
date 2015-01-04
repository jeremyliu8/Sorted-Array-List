/**
* SortedArrayList.java
* Liu, Jeremy
* March 31, 2014
* Create a sorted array list that holds and sorts a list of words (entered by the user) lexicographically.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortedArrayList
{	
	public static void main(String[] args) 
	{
		ArrayList<String> wordList = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		//Command prompt for the user
		System.out.println("\nPlease type your command:" +
			"\n    >showlist - will display all the items in the list." +
			"\n    >insert ... - will insert all of the words that you specify into the list." +
			"\n    >delete ... - will delete all of the words that you specify from the list." +
			"\n    >deleteall - will delete everything from the list." +
			"\n    >end - exit the program.\n");
		
		String input = scan.nextLine(); //scans all of the user input
		String command = input.toLowerCase(); //converts the input string to all lowercase
		
		while (!command.equals("end")) //Allows user to continue adding commands until "end" is entered
		{
			/**
			* creates an object array and displays every element to show all
			* of the contents in the wordList
			*/
			if (command.equals("showlist"))
			{
				Object[] displayWords = wordList.toArray();
				
				if(wordList.size() == 0)
				{
					System.out.println("List is Empty.");
				}				
				else
				{
					for (int i = 0; i < displayWords.length; i++) 
					{
						System.out.print(displayWords[i] + " ");
					}
					System.out.println();
				}
			}
			
			/**
			* creates a substring of all of the words after the word "insert"
			* and separates each value by using a space. It then implements a while loop
			* to add all of the values after the word insert 
			*/
			if (command.startsWith("insert")) //space is considered to reduce confusion
			{
				Scanner seperator1 = new Scanner(command.substring(7));
				seperator1.useDelimiter( " |, " );//reads until a space
		
				String value;

				while (seperator1.hasNext()) 
				{
					value = seperator1.next();
					wordList.add(0, value); //adds to the beginning of the wordList
				}
				Collections.sort(wordList); //sorts the wordList
			}
			
			/**
			* creates a substring of all the words after the word "delete"
			* and separates each value by using a space. 
			* Also implements a while loop to search the wordList to find a match
			* to the input values. If the value was matched, it is deleted from the wordList.
			*/
			if (command.startsWith("delete"))
			{
				Scanner seperator2 = new Scanner(command.substring(7));
				seperator2.useDelimiter( " |, " );//reads until a space
				
				String value;
				
				while (seperator2.hasNext()) 
				{
					Object[] words = wordList.toArray();
					
					value = seperator2.next(); //make the string equal to the next token
					
					for (int i = 0; i < words.length; i++) 
					{
						if (value.equals(words[i])) 
						{ //compare the token with all the words in the wordList
							wordList.remove(i); //if it matches, delete that word.
						}
					}
				}				
			}
			
			/**
			* Calls on the clear() function to delete everything in the wordList
			*/
			if (command.equals("deleteall")) 
			{
				wordList.clear();
			}
			
			//Treats every other input as an unsupported command
			if (!command.equals("showlist") && !command.startsWith("insert") && 
					!command.equals("deleteall") && !command.startsWith("delete"))
			{
				System.out.println("This command is not supported.");
			}
			
			input = scan.nextLine(); //repeat the process until end is entered
			command = input.toLowerCase();
		}
	}
}