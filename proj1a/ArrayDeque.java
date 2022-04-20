/**
 * Deque implemented by array.
 */
public class ArrayDeque<T>{
    private T[] items;
    private int left;
    private int right;
    private int capacity = 8;

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        left = right = 0;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T x){
        if (isFull()){
            resie(capacity * 2);
        }
        items[right] = x;
        right = (right + 1 + capacity) % capacity;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T x){
        if (isFull()){
            resie(capacity * 2);
        }
        left = (left - 1 + capacity) % capacity;
        items[left] = x;
    }

    /**
     * Remove the last element of the deque and return it
     * if not exists, return null.
     */
    public T removeLast(){
        if (isEmpty()) {
            return null;
        }
        right = (right - 1 + capacity) % capacity;
        T res = items[right];
        items[right] = null;
        if (isLowUsageRate()){
            resie((int) (capacity * 0.5));
        }

        return res;
    }

    /**
     * Remove the first element of the deque and return it
     * if not exists, return null.
     */
    public T removeFirst(){
        if (isEmpty()) {
            return null;
        }
        T res = items[left];
        items[left] = null;
        left = (left + 1 + capacity) % capacity;
        if (isLowUsageRate()){
            resie((int) (capacity * 0.5));
        }

        return res;
    }


    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index){
        if (index<0 || index>size() || isEmpty()){
            return null;
        }
        if (left < right){
            return items[left + index];
        }
        else {
            return items[(left + index) % capacity];
        }
    }

    /**Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        if (left < right){
            for (int i=left; i<right; i++){
                System.out.print(items[i] + "");
            }
        }
        else {
            for (int i=left; i<capacity; i++){
                System.out.print(items[i] + "");
            }
            for (int i=0; i<right; i++){
                System.out.print(items[i] + "");
            }
        }
        System.out.println();
    }

    /** Whether is an empty deque. */
    public boolean isEmpty(){
        return left == right;
    }

    /** Return the num of items in the deque. */
    public int size(){
        return (right + capacity - left) % capacity;
    }

    /** Whether is a full deque. */
    private boolean isFull(){
        return size() == capacity -1;
    }

    /** Resize the ArrayDeque to a new capacity.*/
    private void resie(int new_capacity){
        T[] NewArrayDeque = (T[]) new Object[new_capacity];

        int size = size();
        if (left < right){
            System.arraycopy(items, left, NewArrayDeque, 0, size());
        }
        else if (left > right){
            int j = 0;
            for (int i=left; j<capacity-left; i++, j++){
                NewArrayDeque[j] = items[i];
            }
            for (int i=0; j<size; i++, j++){
                NewArrayDeque[j] = items[i];
            }
        }

        items = NewArrayDeque;
        capacity = new_capacity;
        left = 0;
        right = size();
    }

    private boolean isLowUsageRate() {
        return capacity >= 16 && size() / (double) capacity < 0.25;
    }


}
