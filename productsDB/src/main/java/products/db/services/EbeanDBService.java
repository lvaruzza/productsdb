package products.db.services;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Expr;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import products.db.model.Description;
import products.db.model.Product;

public class EbeanDBService implements DBService {

	@Inject
	private EbeanServer ebs;
	
	private ObjectMapper mapper = new ObjectMapper();

	public void save(Product product) {
		ebs.save(product);
	}

	private <T> Optional<T> optify(T x) {
		if (x==null)
			return Optional.empty();
		else
			return Optional.of(x);		
	}
	
	public Optional<Product> getProduct(long id) {
		return optify(ebs.find(Product.class,id));
	}
	
	public Optional<Product> getProduct(String sku) {
		return optify(ebs.find(Product.class).where().eq("sku", sku).findUnique());
		
	}

	@Override
	public Optional<Description> getDescriptionbyLang(String sku, String lang) {
		Description d=ebs.find(Description.class).fetch("product")
				.where().and(
						Expr.eq("product.sku", sku),
						Expr.eq("lang", lang)).findUnique();
		return optify(d);
	}

	@Override
	public List<Product> listProducts() {
		return ebs.find(Product.class).fetch("descriptions").fetch("prices").findList();
	}

	@Override
	public String json(Optional<Object> opc) throws JsonProcessingException {
		if (opc.isPresent()) 
			return json(opc.get());
		else
			return json("not found");
	}

	@Override
	public String json(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}	
}
 