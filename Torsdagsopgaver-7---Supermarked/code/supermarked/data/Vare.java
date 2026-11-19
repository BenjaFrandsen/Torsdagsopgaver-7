package supermarked.robot.supermarked.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vare {

    private final String unit;
    private String id;
    private String name;
    private LocalDate priceDate;
    private BigDecimal price;
    private boolean isBudgetBrand;
    private double quantity;
    private boolean isWeighted;
    private boolean isBio;
    private boolean isAvailable;



    public Vare(String id, String name, LocalDate priceDate, BigDecimal price, boolean isBudgetBrand,  double quantity, String unit, boolean isWeighted, boolean isBio, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.priceDate = priceDate;
        this.price = price;
        this.isBudgetBrand = isBudgetBrand;
        this.quantity = quantity;
        this.unit = unit;
        this.isWeighted = isWeighted;
        this.isBio = isBio;
        this.isAvailable = isAvailable;
    }




    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }

    public boolean isBudgetBrand() {
        return isBudgetBrand;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isBio() {
        return isBio;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    @Override
    public String toString() {
        return name + " (" + id + ") " + price + " kr.";
    }

}

