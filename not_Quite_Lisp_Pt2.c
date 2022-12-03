/*

*/

#include <stdio.h>

int main()
{
    //floor variable holds the floor santa is on, and it starts on the ground floor 0
    int floor = 0;
    //calls file
    FILE *fp = fopen("not_Quite_Lisp_File.txt", "r");
    //basement variable will hold the position of the character that sends santa into the basement
    int basement = 0;
    //while loop runs through file
    while (!feof(fp))
    {
        basement++;
        //int m holds the value of the movement needed to be done, and gets a single character from the file
        int m = (int)(fgetc(fp));
        //changes floor depending on value of m
        if (m == 40) //m = (
            floor++;
        else if (m == 41) //m = )
            floor--;
        //if floor is less than or equal to -1 then santa is in the basement and the loop should end
        if (floor <= -1)
            break;
    }
    //prints it out nicely
    printf("The position of the character that causes Santa to enter the basement is %d", basement);
    //closes file
    fclose(fp);
}
