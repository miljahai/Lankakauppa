package harjoitustyo.lankakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Yarn {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long yarnid;
	@Size(min = 1, max = 50)
	private String brand;
	@Size(min = 1, max = 50)
	private String name;
	
	private String description;
	private double price;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "yarn")
	private List<Pattern> patterns;

	public Yarn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Yarn(Long yarnid, String brand, String name, String description, double price,
			List<Pattern> patterns) {
		super();
		this.yarnid = yarnid;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.price = price;
		this.patterns = patterns;
	}
	
	

	public Yarn(String brand, String name, String description, double price, List<Pattern> patterns) {
		super();
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.price = price;
		this.patterns = patterns;
	}
	
	

	public Yarn(String brand, String name, String description, double price) {
		super();
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getYarnid() {
		return yarnid;
	}

	public void setYarnid(Long yarnid) {
		this.yarnid = yarnid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Pattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(List<Pattern> patterns) {
		this.patterns = patterns;
	}

	@Override
	public String toString() {
		return "Yarn [yarnid=" + yarnid + ", brand=" + brand + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}
	
	
}
