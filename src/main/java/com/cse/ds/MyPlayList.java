/**File header: This file includes the MyPlayList class which contains a list called MyPlayList which holds data of type E. In this file, we create methods to manipulate the list, or add features that we can use to manipulate the list. Each method in this file is essentially a feature.
 * Name: Samruddhi Hande Email: shande@ucsd.edu
 */
package com.cse.ds;

import java.util.*;

/**Class Header: This class name is MyPlayList which is a linked list that holds objects of data type E. It contains methods that help us to manipulate the Song nodes.
 */

public class MyPlayList<E> extends AbstractList<E> {

    /** The variable nsongs represents the number of Songs in the playlist. The dummy node initializes the playlist. */
    private int nsongs;
    Song dummy;

    //  Implementation of the MyPlayList Class

    /** Only 0-argument constructor is define. We initialize the dummy node and the previous and next node as null. The dummy node is not a Song; therefore the number of songs is 0. */
    public MyPlayList()
    {
        // To be implemented
        dummy = new Song("dummy");
        dummy.setNext(null);
	dummy.setPrev(null);
    	nsongs = 0;
    }

    /** This method is to display the size (number of songs) of the playlist
    * @return number of songs being stored  */
    @Override
    public int size()
    {
        return nsongs; // XXX-CHANGE-XXX

    }

    /** @param index represents the node at at that index.
    * @return element of the node at that index. - if index does not exist, IndexOutOfBoundsException is thrown.
    * access the element of the node at that index. */
    @Override
    public E get(int index) throws IndexOutOfBoundsException
    {
	int counter = -1;
	Song temp = dummy;
	if(temp.getNext() == null){
		throw new IndexOutOfBoundsException();
	}
	else{
		while(counter < index && temp.getNext() != null){
			temp = temp.getNext();
			counter++;
		}
		if(counter != index){
			throw new IndexOutOfBoundsException();		
		}
		else{
			return ((E)temp.getElement());
		}
	}
	
        // XXX-CHANGE-XXX
    }

    /** add node into list by indext with element of node
    * @param index index of node between interval of first song and last song in playlist - if this index is greater than the number of songs, IndexOutOfBoundsException is thrown.
    * @param element of node */ 
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException
    {
	if (index > nsongs) {
		throw new IndexOutOfBoundsException();
	}
	else { 
		Song to_add = new Song(element);
		Song temp = dummy;
		int counter = -1;
		while(counter < index && temp.getNext() != null ){
			temp = temp.getNext();
			counter++;		
		}
		Song previous = temp.getPrev();
		Song next_song = temp;
		to_add.setNext(next_song);
		to_add.setPrev(previous);
		previous.setNext(to_add);
		next_song.setPrev(to_add);
		nsongs++;
	}
    }

    /** add new node at end of list; exception checks to make sure user is not adding song with null data.
    * @param element data of Song - if this data is null, NullPointerException is thrown.
    * @return boolean, typically always true to add new node at end of list. */
    @Override
    public boolean add(E element) throws NullPointerException
    {
	if (element == null) {
		throw new NullPointerException();
	}
	else{
        	Song to_add = new Song(element);
		Song temp = dummy;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}

		temp.setNext(to_add);
		to_add.setPrev(temp);
		nsongs++;
		return true;// XXX-CHANGE-XXX
    	}
    }

    /** set element of node at index
    * @param index where node is - if this index is greater than or equal to number of songs, IndexOutOfBoundsException is thrown.
    * @param element to set for node - if this data is null, NullPointerException is thrown.
    * @return data of node at this index */ 
    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
    {
	if (index >= nsongs) {
		throw new IndexOutOfBoundsException();
	}
	else if (element == null) {
		throw new NullPointerException();
	}
	int counter = -1;
	Song temp = dummy;
	while(counter < index && temp.getNext() != null ){
		temp = temp.getNext();
		counter++;
	}
	E return_val = ((E)temp.getElement());
	
	temp.setElement(element);

	return (return_val); // XXX-CHANGE-XXX
    }

    /** remove node from position indicated by index
    * @param index which node to remove - if this index is greater than or equal to the number of songs, IndexOutOfBoundsException is thrown.
    * @return data of removed song */ 	
    @Override
    public E remove(int index) throws IndexOutOfBoundsException
    {
	if (index >= nsongs) {
		throw new IndexOutOfBoundsException();
	}
	int counter = -1;
	Song temp = dummy;
	while(counter < index && temp.getNext() != null ){
                temp = temp.getNext();
                counter++;
        }
	temp.remove();
	nsongs--;
        return ((E)temp.getElement()); // XXX-CHANGE-XXX
    }

    /** remove all songs from playlist */
    @Override
    public void clear()
    {
        // To be implemented
	dummy.setPrev(null);
	dummy.setNext(null);
	nsongs = 0;
    }

    /** determines if playlist is empty by checking to see if number of songs is 0 or not.
    *@return true if number of songs is zero (list is empty) or false if list is not empty  */
    @Override
    public boolean isEmpty()
    {
	if(nsongs == 0){
        	return true;
	}
	return false;
    }

    //Shuffle playlist.
    /** shuffles playlist - uses Random with seed=1234. Uses randombObj.nextInt() to get index of two songs in list that need to be shuffled. After getting these two indexes, the two nodes are interchanged by changing the previous and next nodes. */
    public void shuffle()
    {
	if(nsongs > 1){
        	Random rand = new Random(1234);
		int first = rand.nextInt(nsongs);
		int second = rand.nextInt(nsongs);
		int counter = -1;
		Song temp_one = dummy;
		while(counter < first){
			temp_one = temp_one.getNext();
			counter++;
		}
		counter = -1;
		Song temp_two = dummy;
		while(counter < second){
			temp_two = temp_two.getNext();
			counter++;
		}
		Song temp_one_next = temp_one.getNext();
		Song temp_one_prev = temp_one.getPrev();
		Song temp_two_next = temp_two.getNext();
		Song temp_two_prev = temp_two.getPrev();
	
		temp_one.setNext(temp_two_next);
		temp_one.setPrev(temp_two_prev);
	
		temp_two.setNext(temp_one_next);
		temp_two.setPrev(temp_one.prev);
	
		temp_one_next.setPrev(temp_two);
		temp_one_prev.setNext(temp_two);
	
		temp_two_next.setPrev(temp_one);
		temp_two_prev.setNext(temp_one);

    	}
    }

    //Reverse playlist.
    /** reverses playlist - songs are played from last node to first node - last node becomes first node and so on */
    public void reverse()
    {
        // To be implemented
        if(nsongs > 1){
		Song temp = dummy;
		Song reverse_temp = null;
		while(temp != null){
			reverse_temp = temp.getPrev();
			temp.setPrev(temp.getNext());
			temp.setNext(reverse_temp);
			temp = temp.getPrev();
		}
		if(reverse_temp != null){
			reverse_temp.setPrev(dummy);
			dummy.setNext(reverse_temp);
		}
	}
    }

    public MyListIterator myListIterator() {
        return new MyPlayListIterator(dummy);  // XXX-CHANGE-XXX
    }
}
