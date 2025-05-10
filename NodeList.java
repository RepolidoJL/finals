public class MyArrayList {
    private Object[] items;
    private int count;
    
    // Default constructor with initial size of 10
    MyArrayList() {
        this(10); 
    }
    
    // Constructor with a custom size (between 5 and 50)
    MyArrayList(int size) {
        if(size < 5 || size > 50) {
            items = new Object[10];
        } else {
            items = new Object[size];
        }
        count = 0;
    }

    private boolean isFull() {
        return count == items.length;
    }
    
    private boolean isEmpty() {
        return count == 0;
    }
    
    // Add an element to the array
    public boolean add(Object i) {
        if(!isFull()) {
            items[count] = i;
            count++;
            return true;
        } else {
            return false;
        }
    }

    // Search for an element in the array (returns true if found)
    public boolean search(Object o) {
        if(!isEmpty()) {
            for(int i = 0; i < count; i++) {
                if(items[i].toString().equals(o.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Search for an element and return its index
    public int searchPart2(Object o) {
        if(!isEmpty()) {
            for(int i = 0; i < count; i++) {
                if(items[i].toString().equals(o.toString())) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Check if the location is valid
    private boolean isLocationValid(int location) {
        return location >= 0 && location <= count - 1; 
    }

    // Get an element at a specific location
    public Object get(int location) {
        if(!isEmpty() && isLocationValid(location)) {
            return items[location];
        } else {
            return null;
        }
    }
    
    // Remove an element by object
    public boolean remove(Object o) {
        if(!isEmpty()) {
            int location = searchPart2(o);
            if(location != -1) {
                items[location] = items[count - 1];
                items[count - 1] = null;
                count--;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Remove an element by location index
    public boolean remove(int location) {
        if(!isEmpty() && isLocationValid(location)) {
            items[location] = items[count - 1];
            items[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }
   
    // Edit an element in the array
    public boolean edit(Object item, Object newItem) {
        if(!isEmpty()) {
            int location = searchPart2(item);
            if(location != -1) {
                items[location] = newItem;
                return true;
            }
        }
        return false;
    }
    
    // Convert the array list to a string representation
    public String toString() {
        String result = "";
        if(!isEmpty()){
            result += "[";
            for(int i = 0; i < count; i++) {
                result += items[i].toString();
                if(i < count - 1) result += ", ";
            }
            result += "]";
        }
        return result;
    }
}
