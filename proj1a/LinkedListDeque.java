public class LinkedListDeque<T> {
    private class TNode{
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T i, TNode n, TNode p){
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    /** Empty list. */
    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item){
        sentinel = new TNode(item, null, null);
        sentinel.next = new TNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next
        size = 1;
    }

    /** Adds x to the font of the list.*/
    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next
        size += 1;
    }

    /** Adds x to the last of the list.*/
    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /** Judge whether a list is empty. */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** Return the size of a list. */
    public int size(){
        return size;
    }

    /** Print the items in the deque from first to last. */
    public void printDeque(){
        TNode ptr = sentinel;
        if (ptr.next != sentinel){
            ptr = ptr.next;
            System.out.print(ptr.item);
            System.out.print("");
        }
        System.out.println()
    }

    /** Remove and return the first element of the list. */
    public T removeFirst(){
        if (size == 0){
            return null;
        }
        return sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
    }

    /** Remove and return the last element of the list. */
    public T removeLast(){
        if (size == 0){
            return null;
        }
        return sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
    }

    /** Gets the item at the given index. */
    public T get(int index){
        TNode ptr = sentinel.next;
        if (index == 0){
            return ptr.item;
        }
        ptr = ptr.next;
        index -= 1;
    }

    public T getRecursiveHelper(int index, TNode ptr){
        if (index == 0){
            return ptr.item;
        }
        getRecursiveHelper(index-1, ptr.next)
    }

    public T getRecursive(int index){
        TNode ptr = sentinel.next;
        getRecursiveHelper(index, ptr)
    }








}