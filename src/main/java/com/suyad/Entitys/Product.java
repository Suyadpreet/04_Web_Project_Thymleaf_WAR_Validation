package com.suyad.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product 
{
	@Id
	@GeneratedValue
	private Integer pid;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,max = 20, message = "Name should be between 3 to 20 charcaters")
	private String name;
	@NotNull(message = "price is mandatory")
	@Positive(message = "price should be positive number")
	private Double price;
	@NotNull(message = "Quantity is Mandatory")
	private Integer qty;
}
