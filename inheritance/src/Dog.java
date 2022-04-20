import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s){
        name = n;
        size = s;
    }

    public void bark(){
        System.out.println(name + "bark");
    }

    public int compareTo(Dog another){
        return this.size - another.size;
    }
    public static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

}
