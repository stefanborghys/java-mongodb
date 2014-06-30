package be.seriousbusiness.java.mongodb.repository;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

/**
 * Starts a test Mongod (Mongo DB) instance before launching all test contained by this suite.</br>
 * Afterwards the Mongod is stopped.
 * @author seriousbusiness
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PersonRepositoryTest.class,PersonControllerTest.class,CountryRepositoryTest.class})
public class MongoDbTestSuiteSetup {
	private static final Logger LOGGER=LoggerFactory.getLogger(MongoDbTestSuiteSetup.class);
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
			LOGGER.info("Mongod STARTED");
	    };

	    /**
	     * Stop the MongoDb using FlapDoodle.
	     */
	    @Override
	    protected void after() {
	    	mongodExecutable.stop();
	    	LOGGER.info("Mongod STOPPED");
	    };
	};

}
