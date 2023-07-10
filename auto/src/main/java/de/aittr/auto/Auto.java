package de.aittr.auto;

public class Auto {

    private Long id;

    private String brand;
    private int number;

    private static Long counter = 0L;

    public Auto(String brand, int number) {
        this.id = ++counter;
        this.brand = brand;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static Long getCounter() {
        return counter;
    }

    public static void setCounter(Long counter) {
        Auto.counter = counter;
    }
}
