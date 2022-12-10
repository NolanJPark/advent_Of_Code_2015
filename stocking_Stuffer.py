# Import hashlib file for making MD5 hash
import hashlib

# Takes an int and string input for the secret key and number of zeros in the front
s = input("Enter secret key: ")
x = int(input("Enter how many zeros to have in front: "))
# Sets i (which will be the number added to the secret key) and r (which will be the hashed string) to empty values
i = 0
r = ""
while 1:
    # Adds i to the end of secret key and saves it as temp
    temp = s + str(i)
    # Converts temp to a MD5 hash value
    r = hashlib.md5(temp.encode())
    r = r.hexdigest()
    # b will represent whether r meets the desired parameter
    b = True
    # Runs x times and checks whether the first x values of the hash are 0, if they are b is set to false
    for j in range(x):
        if r[j:j+1] != "0":
            b = False
            break
    # If b is true s is set to temp and the while loop is broken
    if b:
        s = temp
        break
    i += 1
# Prints everything out nicely
print("The final string is "+s+" and is a hash of "+r+"\nThe final answer is", i)