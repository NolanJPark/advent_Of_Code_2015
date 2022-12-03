/*
Now the elves need you to find the amount of ribbon they'll need in feet. They'll
wrap it around the smaller perimeter and the width is already set so they just need
the length. They also need ribbon for the bow they'll tie which is equal to the volume
of the present... it's quite a big bow
*/

#include <Stdio.h>

int main()
{
    //tot holds the square feet of wrapping paper you'll need to order
    int tot = 0;
    //opens file
    FILE *fp = fopen("wrapping_Paper_File.txt", "r");
    //loop that runs till the end of the file
    while (!feof(fp))
    {
        //declare l, w, and h representing the dimensions
        int l, w, h;
        //scans the dimensions from the file in the proper format and sets their respective values
        fscanf(fp, "%dx%dx%d\n", &l, &w, &h);
        //sets side 1 and side 2 to l and w
        int s1 = l, s2 = w;
        //if s1 if greater than w or h then it runs the statments
        if (s1 > w)
        {
            //sets s1 to w and s2 to l
            s1 = w;
            s2 = l;
            //if s2 is greater than h it's set to h
            if (s2 > h)
                s2 = h;
        }
        else if (s1 > h)
        {
            //sets s1 to h and s2 to l
            s1 = h;
            s2 = l;
            //if s2 is greater than w it's set to w
            if (s2 > w)
                s2 = w;
        }
        //if it's not then this statement runs
        else
        {
            if (s2 > h)
                s2 = h;
        }
        //adds perimeter of smallest side and volume of present to tot
        tot += (s1+s1+s2+s2) + (l*w*h);
    }
    //prints it all out nicely
    printf("The total amount of ribbon needed is %d feet", tot);
    //closes file
    fclose(fp);
}
