
import java.io.*;
import java.net.*;
import java.util.*;


/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.


@author: Kruthi Meghana Anumandla
*/

class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iter;
    private Integer nextElement = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
         iter = iterator;
         nextElement = iter.hasNext()? iter.next() : null;	    
	}
    
	public Integer peek() {
        return nextElement;
        
	}
    
	@Override
	public Integer next() {
        Integer buffer = nextElement;
        nextElement = iter.hasNext()? iter.next() : null;
	    return buffer;
	}
	
	@Override
	public boolean hasNext() {
	    return nextElement == null? false: true;
	}
}