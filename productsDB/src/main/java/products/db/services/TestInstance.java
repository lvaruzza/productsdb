package products.db.services;

import com.google.inject.Guice;
import com.google.inject.Injector;

import products.db.config.DBModule;

public class TestInstance {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new DBModule());
		DBService dbs = injector.getInstance(DBService.class);
	}

}
