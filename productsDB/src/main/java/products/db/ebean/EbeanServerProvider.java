package products.db.ebean;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.google.inject.Provider;

public class EbeanServerProvider implements Provider<EbeanServer> {

	public EbeanServer get() {
		ServerConfig cfg = new ServerConfig();
		cfg.setName("productsdb");
		cfg.loadFromProperties();
		cfg.setDefaultServer(true);
		return EbeanServerFactory.create(cfg);
	}

}
