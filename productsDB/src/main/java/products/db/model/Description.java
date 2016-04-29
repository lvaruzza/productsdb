package products.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
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

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
@Table(name="descriptions")
@XmlRootElement( name = "description" )
@XmlAccessorType (XmlAccessType.NONE)
public class Description {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@CreatedTimestamp
    @XmlElement (name = "created_at")
	Timestamp createdAt;
	
	@Column(columnDefinition="text")
    @XmlElement (name = "name")
	private String name;
	
	@Column(columnDefinition="text")
    @XmlElement (name = "description")
	private String description;
	
	@Column(length=5)
    @XmlAttribute (name = "lang")
	private String lang;
	
	@ManyToOne
	private Product product;
	
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	public String getLang() {
		return lang;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Description() {
	}
	public Description(String name, String description, String lang) {
		super();
		this.name = name;
		this.description = description;
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "Description [name=" + name + ", description=" + description + ", lang=" + lang + "]";
	}
	
	
}
