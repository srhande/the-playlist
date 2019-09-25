/** File header: This file contains the MyPlayListIterator class. The purpose of this file is to create a way to traverse the list by moving in a ceratin direction.
 * Name: Samruddhi Hande Email: shande@ucsd.edu */ 
package com.cse.ds;


/** ListIterator implementation */
/** Class header: This class creates a doubly linked list of songs. The iterator creates a way to traverse the doubly linked list. */
public class MyPlayListIterator<E> implements MyListIterator<E> {
    
    Song left; //left song node
    Song right; //right song node
    Song start; //starting node
    boolean forward_dir; //moving forward
    boolean next_prev; //moving backward
    int index; //index of node 
    
    /** initialize iterator
    *@param dummy Song node */
    public MyPlayListIterator(Song dummy){
    	start = dummy;
	left = dummy;
	right = dummy.getNext();
	index = 0;
	forward_dir = true;
	next_prev = false;
    }
   
    /** check to see if there is a next node in the forward direction
    *@return boolean - true if there are more elements in the forward direction other than dummy; false if not */	
    @Override
    public boolean hasNext() {
        if(left.getNext() != null){
    		return true;
	}
	return false; // XXX-CHANGE-XXX
    }

    /** return next element in list in forward direction; move iterator forward for one node
    * should throw NoSuchElementException if no such element
    * @return next element in list in forward direction */ 
    @Override
    public E next() {
	if(left.getNext()!= null){
		forward_dir = true;
		index++;
		E temp_val = ((E)right.getElement());
		left = right;
		right = right.getNext();
		next_prev = true;
		return temp_val;
		
	}

	//throw new NoSuchElementException();
        return null; // XXX-CHANGE-XXX
    }
 
    /** check to see if there is a next node in the reverse direction
    * @return boolean - true if there are more elements in the reverse direction other than dummy; false if not */ 
    @Override
    public boolean hasPrevious() {
	if(left.getPrev()!= null){
		return true;
	}
        return false; // XXX-CHANGE-XXX
    }

    /** return next element in list in reverse direction; move iterator backward for one node
    * should throw NoSuchElementException if no such element
    * @return next element in list in reverse direction */ 
    @Override
    public E previous() {
	if(left.getPrev() != null && left != start){
		forward_dir = false;
		index--;
		E temp_val = ((E)left.getElement());
		right = left;
		left = left.getPrev();
		next_prev = true;
		return temp_val;
	}
	//throw new NoSuchElementException();
        return null; // XXX-CHANGE-XXX
    }

    /** return index of element that would be returned by a call to next(); return last index if at end of the list
    * @return int index of next node */ 
    @Override
    public int nextIndex() {
        return index; // XXX-CHANGE-XXX
    }

    /** return index of element that would be returned by a call to previous(); return -1 if at start of list
    * @return int index of previous node */ 
    @Override
    public int previousIndex() {
        return (index-1); // XXX-CHANGE-XXX
    }

    /** change value in node returned by most recent next/previous call with new value
    * throws NullPointerException if value is null
    * throws IllegalStateException if neither next nor previous are called. */ 
    @Override
    public void set(E o) {
        // To be implemented
        if(o == null){
		throw new NullPointerException();
	}
	if(next_prev == false){
		throw new IllegalStateException();
	}
	else{
		if(forward_dir){
		//change left
			left.setElement(o);
		}
		else{
			right.setElement(o);
		}
	}
	
    }

}
