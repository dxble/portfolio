package assignment;

/**
 *
 * @author D.Tea 15909644
 * BufferItem.java sets the item as an int when instantiated.
 */
class BufferItem {
    
    public int item;
    
    public BufferItem(int item){ // Constructor
        this.item = item;
    }
    
    @Override
    public String toString(){ // Override the toString method to return item value when called
        return ""+item;
    }
}
