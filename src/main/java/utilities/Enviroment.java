package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:enviromentConfig/${env}.properties" })
public interface Enviroment extends Config {
	@Key("App.Url")
	String appUrl();

	@Key("App.User")
	String appUsername();

	@Key("App.Pass")
	String appPassword();

	@Key("DB.Host")
	String databaseHostName();

	@Key("DB.User")
	String databaseUser();

	@Key("DB.Pass")
	String databasePassword();

}
