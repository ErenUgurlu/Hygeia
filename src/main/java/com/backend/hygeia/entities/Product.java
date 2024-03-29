package com.backend.hygeia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	@Size(max = 1000)
	private String description;

	//Name alanı bu entiti içerisinde category objesinin veri tabanında hangi isimle görüneceğini belirtir
	@NotBlank
    @ManyToOne
    @JoinColumn(name ="categoryId", nullable = false)
	private Category category;

	@NotBlank
	@Size(max = 1000)
	private double price;

	@Size(max = 1000)
	private String imgPath;
	
	@Size(max = 1000)
	private int status;

}
