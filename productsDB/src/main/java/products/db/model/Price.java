package products.db.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="prices")
@XmlAccessorType (XmlAccessType.NONE)
@XmlRootElement( name = "price" )
public class Price {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @XmlElement (name = "value")
	private BigDecimal price;
    @XmlAttribute(name="currency")
	private String currency;

    @XmlElement (name = "valid_after")
	private Timestamp validAfter;

	
	@ManyToOne
	private Product product;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getValidAfter() {
		return validAfter;
	}
	public void setValidAfter(Timestamp validAfter) {
		this.validAfter = validAfter;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Price(BigDecimal price, String currency) {
		super();
		this.price = price;
		this.currency = currency;
	}
	
	
}
