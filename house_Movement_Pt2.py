"""
A file contains arrows pointing in the 4 basic directions indicating which way santa will
go in terms of perfect houses on a 2D plane. Now Santa has a robot to him, and they take
turns following the directions from the file. You need to figure out how many houses Santa
and the robot have actually been visited
"""

#check function sees in tuple xy is in list coord and returns false if it is
def check(xy, coord):
    b = True
    for i in range(len(coord)):
        if coord[i][0] == xy[0] and coord[i][1] == xy[1]:
            b = False
    return b

#List coord holds the position of each house Santa has visited,Tuple curr_coord holds the current coordinates S for Santa R for Robot, both start at (0,0)
coord = [(0,0)]
curr_coord_S = (0,0)
curr_coord_R = (0,0)
#Variable N holds the ASCII value representing ^, S representing v, W representing <, and E representing >
N = 94
S = 118
W = 60
E = 62
f = open("house_Movement_File.txt", "r")
# Variable b tells whether Santa or the Robot will move, True if santa False if Robot
b = True
while 1:
    # Reads and stores a single character from the file as c
    c = f.read(1)
    # Infinite loop is broken if c is None
    if not c:
        break
    if b:
        # Variabele x and y hold the x an d y values of Santa's current coordinates
        x = curr_coord_S[0]
        y = curr_coord_S[1]
        # Increases or decreases x and y based on what c is
        if ord(c) == N:
            y += 1
        elif ord(c) == S:
            y -= 1
        elif ord(c) == W:
            x -= 1
        elif ord(c) == E:
            x += 1
        # Uses the check function to see if (x,y) tuple is already in coord, and if it isn't it adds (x,y) to coord
        if check((x, y), coord):
            coord.append((x, y))
        # Sets curr_coord to (x,y)
        curr_coord_S = (x, y)
        # Sets b to false so the next iteration runs the robot
        b = False
    else:
        # Variabele x and y hold the x an d y values of Robot's current coordinates
        x = curr_coord_R[0]
        y = curr_coord_R[1]
        # Increases or decreases x and y based on what c is
        if ord(c) == N:
            y += 1
        elif ord(c) == S:
            y -= 1
        elif ord(c) == W:
            x -= 1
        elif ord(c) == E:
            x += 1
        if check((x, y), coord):
            coord.append((x, y))
        curr_coord_R = (x, y)
        b = True
# Prints it all out nicely
print("Santa and the Robot have visited", len(coord), "houses")