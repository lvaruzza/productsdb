package products.db.config;

import org.testng.IModuleFactory;
import org.testng.ITestContext;

import com.google.inject.Module;

public class DBModuleFactory implements IModuleFactory {

	@Override
	public Module createModule(ITestContext context, Class<?> testClass) {
		return new DBModule();
	}

}
