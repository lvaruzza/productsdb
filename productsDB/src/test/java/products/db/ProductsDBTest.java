package products.db;

import org.testng.annotations.Guice;

import products.db.config.DBModuleFactory;

@Guice(moduleFactory=DBModuleFactory.class)
public class ProductsDBTest {

}
