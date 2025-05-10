public class StackArray[] items;
   private int count;

 
   public StackArray(int size) {
      if (size > 50 || size < 5) {
         size = 10;
      }
      items = new Object[size];
      count = 0;
   }


   public boolean isFull() {
      return count == items.length;
   }

 
   public boolean isEmpty() {
      return count == 0;
   }

  
   public boolean push(Object value) {
      if (!isFull()) {
         items[count] = value;
         count++;
         return true;
      }
      return false;
   }

  
   public Object peek() {
      if (!isEmpty()) {
         return items[count - 1]; 
      }
      return null;
   }

  
   public boolean pop() {
      if (!isEmpty()) {
         items[count - 1] = null; 
         count--; 
         return true;
      }
      return false;
   }


   public String toString() {
      String result = "";
      for (int i = count - 1; i >= 0; i--) {
         result = result + "[" + items[i] + "]\n";
      }
      return result;
   }
}
