package model;

import jakarta.validation.constraints.*;

public class Product {
    private Long id;

//    @NotEmpty(message = "Product name is required")
//    @NotNull(message = "Product name is required")
    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Min(10)
    @Max(1000000)
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
