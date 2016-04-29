package products.db.services;

import java.util.List;
import java.util.Optional;

import products.db.model.Description;
import products.db.model.Product;

public interface DBService {	
	public void save(Product product);

	public Optional<Product> getProduct(long id);
	public Optional<Product> getProduct(String sku);

	public Optional<Description> getDescriptionbyLang(String sku, String lang);

	public List<Product> listProducts();
}
