package products.db.services;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.testng.annotations.Test;

import products.db.ProductsDBTest;
import products.db.model.Description;
import products.db.model.Languages;
import products.db.model.Product;

public class EbeanDBServiceTest extends ProductsDBTest {

	@Inject
	private DBService dbs;

	@Test
	public void testEbeanServer() {
		assertNotNull(dbs);
	}
	
	@Test
	public void testCreate() {
		Product prod = new Product("test000");
		dbs.save(prod);
		System.out.println(prod.getId());
		Optional<Product> prod2 = dbs.getProduct(prod.getId());
		assertTrue(prod2.isPresent());
	}
	
	@Test
	public void testCreateDescription() {
		Product prod = new Product("test001");
		Description desc = new Description("test","test product",Languages.pt_BR);
		prod.addDescription(desc);
		dbs.save(prod);
		Optional<Description> desc2 = dbs.getDescriptionbyLang("test001",Languages.pt_BR);
		assertTrue(desc2.isPresent());
		assertEquals(desc,desc2.get());
		assertEquals(desc2.get().getProduct().getSku(),"test001");
	}

	private void populate() {
		Product p0 = new Product("test002");
		Description d0=new Description("0","0","pt_BR");
		p0.addDescription(d0);
		dbs.save(p0);
		Product p1 = new Product("test003");
		Description d1=new Description("1","1","pt_BR");
		p1.addDescription(d1);
		dbs.save(p1);
	}
	
	@Test
	public void testList() {
		populate();
		List<Product> lst=dbs.listProducts();
		assertEquals(lst.size(),4);
		//lst.forEach(p -> System.out.println(p));
	}
}
