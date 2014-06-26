package be.seriousbusiness.java.mongodb.repository;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@RunWith(Suite.class)
@SuiteClasses({PersonRepositoryTest.class,PersonControllerTest.class,CountryRepositoryTest.class})
public class MongoDbTestSetup {
	private static MongodExecutable mongodExecutable;
	
	@ClassRule
	public static ExternalResource externalResource=new ExternalResource(){
		
		/**
		 * Start the MongoDb using FlapDoodle.
		 */
		@Override
	    protected void before() throws Throwable {
			final Net net=new Net(27017,Network.localhostIsIPv6());
			final MongodConfigBuilder mongodConfigBuilder=new MongodConfigBuilder().version(Version.Main.PRODUCTION).net(net);
			final MongodStarter mongodStarter=MongodStarter.getDefaultInstance();
			mongodExecutable=mongodStarter.prepare(mongodConfigBuilder.build());
			mongodExecutable.start();
	    };

	    /**
	     * Stop the MongoDb.
	     */
	    @Override
	    protected void after() {
	    	mongodExecutable.stop();
	    };
	};

}
