package de.aittr.auto_spring;

public class Auto {
    private Long id;
    private String plate;

    private String brand;

    public Auto(Long id, String plate, String brand) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
    }

    public Auto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
