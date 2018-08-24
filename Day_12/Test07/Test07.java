package Day_12.Test07;

public class Test07 {
    public static void main(String[] args) {
        Car Q7 = getCar(()-> {
            return new Car();
        });
        Q7.setBrand("奥迪");
    }
    public static Car getCar(BeanFactory<Car> factory){
        return factory.getBean();
    }

}

@FunctionalInterface
 interface BeanFactory<T> {
    T getBean();
}
class Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car() {

    }
}
