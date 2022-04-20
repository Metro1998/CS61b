public class test_demo {
    public static void main(String[] args){
        ArrayDeque<Integer> d = new ArrayDeque<>();
        System.out.println(d.isEmpty());
        d.removeFirst();
        d.addFirst(0);
        d.addFirst(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(5);
        d.addFirst(6);
        d.addLast(7);
        d.addLast(8);
        d.addLast(9);
        d.printDeque();
        System.out.println(d.size());
        System.out.println(d.get(0));
        System.out.println(d.getRight());
        System.out.println(d.getLeft());
    }
}
