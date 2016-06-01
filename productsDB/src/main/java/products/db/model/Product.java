package products.db.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="products",uniqueConstraints={@UniqueConstraint(columnNames={"sku"})})
@XmlRootElement( name = "product" )
@XmlAccessorType (XmlAccessType.NONE)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId=false) // otherwise first ref as POJO, others as id
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
    @XmlElement (name = "sku")
	private String sku;

    @XmlElement (name = "deprecated")
	private boolean deprecated=false;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    @XmlElement (name = "descriptions")
	List<Description> descriptions;

	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    @XmlElement (name = "prices")
	List<Price> prices;

	@ManyToMany(cascade=CascadeType.REFRESH)
	List<Product> children;
	
 	public long getId() {
		return id;
	}
    public void setId(long id) {
		this.id = id;
	}
    
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public boolean isDeprecated() {
		return deprecated;
	}
	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}
	
	public void addDescription(Description description) {
		description.setProduct(this);
		descriptions.add(description);
	}
	
	public void addPrice(Price price) {
		price.setProduct(this);
		prices.add(price);
	}
	
	public Product(String sku) {
		super();
		this.sku = sku;
	}
	public void addPrices(Collection<Price> prices) {
		for(Price price: prices) {
			addPrice(price);
		}
	}
	public List<Description> getDescriptions() {
		return descriptions;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public List<Product> getChildren() {
		return children;
	}
	
	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
    
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	
	
}
