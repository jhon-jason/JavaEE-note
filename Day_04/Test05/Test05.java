package Day_04.Test05;
/*
* 五、请使用Map集合存储自定义数据类型Car做键，对应的价格做值。并使用keySet和entrySet两种方式遍历Map集合。
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test05 {
    public static void main(String[] args) {
        HashMap<Car, Integer> map = new HashMap<>();
        Car b=new Car("BMW",1000000);
        Car a=new Car("auti",400000);
        Car f=new Car("farrli",8000000);
        Car l=new Car("lanbo",9000000);
        Car g=new Car("binli",9800000);
        map.put(b, b.getPrice());
        map.put(a, a.getPrice());
        map.put(f, f.getPrice());
        map.put(l, l.getPrice());
        map.put(g, g.getPrice());
        Set<Car> cars = map.keySet();
        for (Car car : cars) {
            System.out.println(car);
        }

        Set<Map.Entry<Car, Integer>> entries = map.entrySet();
        for (Map.Entry<Car, Integer> entry : entries) {
            System.out.println(entry.getValue());
            System.out.println(entry);
        }
    }
}
class Car{
    private String name;
    private int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}