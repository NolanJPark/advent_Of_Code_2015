/*

*/

#include <stdio.h>

int main()
{
    //floor variable holds the floor santa is on, and it starts on the ground floor 0
    int floor = 0;
    //calls file
    FILE *fp = fopen("not_Quite_Lisp_File.txt", "r");
    //while loop runs through file
    while (!feof(fp))
    {
        //int m holds the value of the movement needed to be done, and gets a single character from the file
        int m = (int)(fgetc(fp));
        //changes floor depending on value of m
        if (m == 40) //m = (
            floor++;
        else if (m == 41) //m = )
            floor--;
    }
    //prints it out nicely
    printf("Santa ends on floor %d", floor);
    //closes file
    fclose(fp);
}
