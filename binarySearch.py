# Author:	Brittany Posntikoff
# Document:	Binary Search
# Date:		2015-07-04

def binarySearch(seq, key) :
  low = 0
  high = len(seq) - 1

  while low <= high :
    mid = low + ((high - low) /2 )
    midVal = seq[mid]
    if midVal < key :
      low = mid + 1
    elif midVal > key :
      high = mid - 1
    else :
      while mid > 0 and seq[mid-1] == seq[mid] :
        mid -= 1
      return mid;

  return -(low + 1)


# TESTING THE BINARY SEARCH
print "Binary Search Python Program:"
print "-----------------------------", "\n"


seq = [2,2,2,2]
print "Sequence:",seq
searchValue = 2
print "Search Value:",searchValue
position = binarySearch(seq, searchValue);
print "Postition: ", position, "\n"

seq = []
print "Sequence:",seq
searchValue = 5
print "Search Value:",searchValue
position = binarySearch(seq, searchValue);
print "Postition: ", position, "\n"

seq = [1,2,3]
print "Sequence:",seq
searchValue = 3
print "Search Value:",searchValue
position = binarySearch(seq, searchValue);
print "Postition: ", position, "\n"

seq = [5,5,5,5,5,5,9]
print "Sequence:",seq
searchValue = 12
print "Search Value:",searchValue
position = binarySearch(seq, searchValue);
print "Postition: ", position, "\n"

seq = []
print "Sequence:",seq
searchValue = 1
print "Search Value:",searchValue
position = binarySearch(seq, searchValue)
print "Postition: ", position, "\n"
