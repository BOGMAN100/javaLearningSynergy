import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TaskOne {
    public static List<String> correctedList(List<String> stringList) {
        List<String> result = new ArrayList<>();
        for (String str : stringList) {
            boolean hasUppercase = !str.equals(str.toLowerCase());
            if (!hasUppercase) {
                result.add(str);
            }
        }
        return result;
    }
}

class Product {
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

public class сh2Dz4 {
    public static void magSort(Map<String, Product> cart) {
        Iterator<Map.Entry<String, Product>> iterator = cart.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Product> entry = iterator.next();
            Product product = entry.getValue();
            if (product.getWeight() > 300) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("world");
        stringList.add("Java");
        stringList.add("programmers");

        List<String> correctedList = TaskOne.correctedList(stringList);
        System.out.println("First task:");
        System.out.println(stringList);
        System.out.println(correctedList);
        System.out.println();

        System.out.println("Second task:");
        System.out.println();
        Map<String, Product> cart = new HashMap<>();
        cart.put("apple", new Product("apple", 200));
        cart.put("banana", new Product("banana", 150));
        cart.put("orange", new Product("orange", 350));
        cart.put("grape", new Product("grape", 100));
        cart.put("watermelon", new Product("watermelon", 600));
        for (Product product : cart.values()) {
            System.out.println(product.getName() + " - " + product.getWeight());
        }
        System.out.println();
        magSort(cart);
        for (Product product : cart.values()) {
            System.out.println(product.getName() + " - " + product.getWeight());
        }
    }
}
