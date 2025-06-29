/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[this.underlying.length * RESIZE_FACTOR]; //removed and RESIZE_FACTOR used
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */
    public int indexOf(String string) {
        for (int i = 0; i < this.occupancy; i++) { //  loop through used elements of the array
            if (this.underlying[i] != null && this.underlying[i].equals(string)) { // check for match using .equals()
                return i; //  return index if found
            }
        }
        return -1; //  return -1 if not found
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {
        return this.indexOf(string) != -1; // reuse indexOf method to check presence
    }

    /** Method to count how many times a string appears in the underlying array*/
    public int countOf(String string) {
        int count = 0; // keeps track of how many matches found
        for (int i = 0; i < this.occupancy; i++) { // loop through all valid items
            if (this.underlying[i] != null && this.underlying[i].equals(string)) { // check for match
                count++; // increment count when match found
            }
        }
        return count; // return the final count
    }

    /** method to remove items from the underlying array */
    public String remove(int index) {
        if (index < 0 || index >= this.occupancy) { // bounds check for valid index
            return null; // invalid index returns null
        }
        String removed = this.underlying[index]; // save the item being removed
        for (int i = index; i < this.occupancy - 1; i++) { // shift items left from index onward
            this.underlying[i] = this.underlying[i + 1]; // move next item back by one
        }
        this.underlying[this.occupancy - 1] = null; //clear the now-unused last slot
        this.occupancy--; // decrease count since one item was removed
        return removed; // return removed value
    }

    /** overload remove */ 
    public String remove(String string) {
        int index = this.indexOf(string); // find the index of the string
        if (index == -1) { // ADDED: if not found
            return null; // ADDED
        }
        return this.remove(index); // ADDED: delegate to index-based remove
    }

    /** Return a string representation of the array */
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder to build output
        sb.append("["); // opening bracket
        for (int i = 0; i < this.occupancy; i++) { // loop through valid elements
            sb.append(this.underlying[i]); //
            if (i < this.occupancy - 1) {
                sb.append(", "); // add comma between elements
            }
        }
        sb.append("]"); // closing bracket
        return sb.toString(); // return built string
    }

} // class DynamicArray