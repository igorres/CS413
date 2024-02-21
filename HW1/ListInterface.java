package HW1;

public interface ListInterface<E extends Comparable<? super E>>
{
   /** Adds a new entry to the end of this list.
       Entries currently in the list are unaffected.
       The list's size is increased by 1.
       @param newEntry  The object to be added as a new entry. */
   public void add(E newEntry);
   
   /** Adds a new entry at a specified position within this list.
       Entries originally at and above the specified position
       are at the next higher position within the list.
       The list's size is increased by 1.
       @param newPosition  An integer that specifies the desired
                           position of the new entry.
       @param newEntry     The object to be added as a new entry.
       @throws  IndexOutOfBoundsException if either
                newPosition < 1 or newPosition > getLength() + 1. */
   public boolean add(int newPosition, E newEntry);

   public Comparable remove(int givenPosition);
   
   /** Removes all entries from this list. */
   public void clear();
   
   /** Replaces the entry at a given position in this list.
       @param givenPosition  An integer that indicates the position of
                             the entry to be replaced.
       @param newEntry  The object that will replace the entry at the
                        position givenPosition.
       @return  The original entry that was replaced.
       @throws  IndexOutOfBoundsException if either
                givenPosition < 1 or givenPosition > getLength(). */
   public E replace(int givenPosition, E newEntry);

   /** Retrieves the entry at a given position in this list.
        @param givenPosition An integer that indicates the position of
            the desired entry. 
        @return A reference to the indicated entry. @throws IndexOutOfBoundsException if either
            givenPosition < 1 or givenPosition > getLength(). */
    public Comparable getEntry(int givenPosition);
   
   /** Retrieves all entries that are in this list in the order in which
       they occur in the list.
       @return  A newly allocated array of all the entries in the list.
                If the list is empty, the returned array is empty. */
   public Comparable[] toArray();
   
   /** Sees whether this list contains a given entry.
       @param anEntry  The object that is the desired entry.
       @return  True if the list contains anEntry, or false if not. */
   public boolean contains(E anEntry);
   
   /** Gets the length of this list.
       @return  The integer number of entries currently in the list. */
   public int getLength();
       
   /** Sees whether this list is empty.
       @return  True if the list is empty, or false if not. */
   public boolean isEmpty();
} 
