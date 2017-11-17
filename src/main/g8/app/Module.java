import com.google.inject.AbstractModule;
import ontoplay.controllers.MainTemplate;
import ontoplay.controllers.OntoPlayMainTemplate;
import play.Configuration;
import play.Environment;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {
		private final Environment environment;
		private final Configuration configuration;

		public Module(Environment environment, Configuration configuration) {
	    this.environment = environment;
	    this.configuration = configuration;
		}

    @Override
    public void configure() {
  		install(new ontoplay.Module(new play.Environment(environment.underlying()), new play.Configuration(configuration.underlying())));
			bind(MainTemplate.class).to(OntoPlayMainTemplate.class);
    }
}
