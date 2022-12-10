/*
You're given a file containing lines of strings, and you need to figure out if
each line represents a naughty or nice person. A string represents a nice if
it contains 3 vowels, one letter that appears twice, and doesn't contain ab, 
cd, pq, or xy. You need to figure out how many strings are nice.
*/

import java.io.*;
import java.util.*;

public class santas_List_Pt1
{
    public static void main(String[] arg)
    {
        //try catch in case of file acquisition error
        try
        {
            File f = new File("santas_List_File.txt");
            Scanner r = new Scanner(f);
            //tot variable holds number of nice strings
            int tot = 0;
            while (r.hasNextLine())
            {
                String s = r.nextLine();
                //Initializes three booleans, if any are false at the end nothing is added to tot
                boolean b1 = true;
                boolean b2 = false;
                boolean b3 = false;
                //for loop goes through string excluding last character in string
                for (int i = 0; i < s.length()-1; i++)
                {
                    //Variable c represents two characters in string
                    String c = s.substring(i,i+2);
                    //If c is equal to any of the undesireable phrases then b1 is set to false and the for loop is broken
                    if (c.equals("ab") || c.equals("cd") || c.equals("pq") || c.equals("xy"))
                    {    
                        b1 = false;
                        break;
                    }
                }
                //for loop goes through string excluding last character in string
                for (int i = 0; i < s.length()-1; i++)
                {
                    //If character at index i is equal to the character after it thenb2 is set to true and the loop is broken
                    if (s.substring(i,i+1).equals(s.substring(i+1,i+2)))
                    {
                        b2 = true;
                        break;
                    }
                }
                //Variable j will represent how many vowels are in s
                int j = 0;
                //Runs through every character in s
                for (int i = 0; i < s.length(); i++)
                {
                    //c is set to character at index i
                    String c = s.substring(i,i+1);
                    //If c is equal to a vowel j is increased my 1
                    if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u"))
                        j++;
                    //If at any point j is greater than or equal to 3 b3 is set to true and the loop is broken
                    if (j >= 3)
                    {
                        b3 = true;
                        break;
                    }
                }
                //If all the booleans are true tot is increased by 1
                if (b1 && b2 && b3)
                    tot++;
            }
            //prints it all out nicely and then closes the file
            System.out.print(tot+" strings are nice");
            r.close();
        }
        //Catches a file problem and prints out the fact it's a file problem
        catch (FileNotFoundException e)
        {
            System.out.println("wtf something went wrong getting the file");
            e.printStackTrace();
        }
    }
}
