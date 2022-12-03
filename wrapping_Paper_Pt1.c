/*
The elves give you a file containing the dimensions of all the presents they need to wrap,
and they want you to find the total square feet they'll need to order to wrap all the presents
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
        //adds the total surface area of the present
        tot += (2*l*w) + (2*w*h) + (2*h*l);
        //finds which surface has the smallest area and adds it to the total
        if (l*w <= w*h && l*w <= h*l)
            tot += l*w;
        else if (w*h <= l*w && w*h <= h*l)
            tot += w*h;
        else if (h*l <= w*h && h*l <= l*w)
            tot += h*l;
    }
    //prints it all nicely
    printf("The elves should order %d square feet of wrapping paper\n", tot);
    //closes file
    fclose(fp);
}
