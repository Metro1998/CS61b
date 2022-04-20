import java.util.Arrays;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("wolfie", 21);
        Dog d2 = new Dog("metro", 43);
        Dog d3 = new Dog("robin", 12);
        Dog[] dogs = new Dog[]{d1, d2, d3};
        Dog maxdog = (Dog) Maximizer.max(dogs);
        maxdog.bark();

        Dog.NameComparator nc = new Dog.NameComparator();
        if (nc.compare(d1, d3) > 0){
            d1.bark();
        }
        else {
            d3.bark();
        }
    }
}
