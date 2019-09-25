/** File header: This file contains the Song class. In this file, we create a list that consists of Song nodes that consist of type E objects. 
 *Name: Samruddhi Hande, cs12sp19hy Email: shande@ucsd.edu
 */

package com.cse.ds;

/** The purpose of this class is to create nodes of type  Song. The class consists of methods that interact with these nodes, such as to initialize the Songs (nodes) with data, to remove the song, to set the previous and next songs, to set the Song's data, to return the previous and next song, and to get the Song's data (setter and getter methods). */
public class Song<E> {

/** These variables represent the data of the node, the next Song, and the previous Song.
 */
    E data;
    Song next;
    Song prev;

    /** Constructor to create singleton Song - we set previous and next Songs as null to initialize first node. */
    public Song(E element)
    {
        //To be implemented
        this.data = element;
	this.next = null;
	this.prev = null;
    }
    /** Constructor to create singleton link it between previous and next
     *   @param element Element to add, can be null
     *   @param prevSong predecessor Song, can be null
     *   @param nextSong successor Song, can be null
     */
    public Song(E element, Song prevSong, Song nextSong)
    {
        //To be implemented
        this.data = element;
	prevSong = this.prev;
	nextSong = this.next;
	//test these
	prevSong.next = this;
	nextSong.next = this;
    }
    /** Remove this Song from the list. Update previous and next Songs */
    public void remove()
    {
        //To be implemented
        (this.prev).next = this.next;
	(this.next).prev = this.prev;
	this.next = null;
	this.prev = null;
    }
    /** Set the previous Song in the list
     *  @param p new previous Song
     */
    public void setPrev(Song p)
    {
        //To be implemented
        this.prev = p;
	if(p!= null){
		p.next = this;
	}
    }

    /** Set the next Song in the list
     *  @param n new next Song
     */
    public void setNext(Song n)
    {
        //To be implemented
	this.next = n;
	if(n != null){
		n.prev = this;
	}
    }

    /** Set the element - data of Song
     *  @param e new element
     */
    public void setElement(E e)
    {
        //To be implemented
        this.data = e;
    }
    /** Accessor to get the next Song in the list */
    public Song getNext()
    {
        return this.next; // XXX-CHANGE-XXX
    }
    /** Accessor to get the prev Song in the list */
    public Song getPrev()
    {
        return this.prev; // XXX-CHANGE-XXX

    }
    /** Accessor to get the Songs Element */
    public E getElement()
    {
       return this.data;// XXX-CHANGE-XXX
    }
}


