/*
You're given a file containing lines of strings, and you need to figure out if
each line represents a naughty or nice person. A string represents a nice if
a pair of characters repeats (excluding overlaps) and if a letter
repreats with a single character between the repeats in the string.
*/

import java.io.*;
import java.util.*;

public class santas_List_Pt2
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
                boolean b1 = false;
                boolean b2 = false;
                //for loop goes through string excluding last 2 characters in string
                for (int i = 0; i < s.length()-2; i++)
                {
                    //Variable s1 is set to the two characters at index i
                    String s1 = s.substring(i, i+2);
                    //Runs through each pair of characters after s1
                    for (int j = i+2; j < s.length()-1; j++)
                    {
                        //Variable s2 is set to the two characters at index j
                        String s2 = s.substring(j, j+2);
                        //If s1 equals s2 b1 is set to true and the loop is broken
                        if (s1.equals(s2))
                        {
                            b1 = true;
                            break;
                        }
                    }
                }
                //for loop goes through string excluding last 2 characters in string
                for (int i = 0; i < s.length()-2; i++)
                {
                    //Variable c is set to the character at index i
                    String c = s.substring(i,i+1);
                    //If c equals the character two spaces beyond it b2 is set to true and the loop is broken
                    if (c.equals(s.substring(i+2,i+3)))
                    {
                        b2 = true;
                        break;
                    }
                }
                //If all the booleans are true tot is increased by 1
                if (b1 && b2)
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
