package products.db.config;

import com.avaje.ebean.EbeanServer;
import com.google.inject.Binder;
import com.google.inject.Module;

import products.db.ebean.EbeanServerProvider;
import products.db.services.DBService;
import products.db.services.EbeanDBService;

public class DBModule implements Module{

	public void configure(Binder binder) {
		binder.bind(EbeanServer.class).toProvider(EbeanServerProvider.class).asEagerSingleton();
		binder.bind(DBService.class).to(EbeanDBService.class);
	}

}
