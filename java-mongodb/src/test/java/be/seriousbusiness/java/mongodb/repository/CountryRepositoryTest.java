package be.seriousbusiness.java.mongodb.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.java.mongodb.entity.Country;

@ContextConfiguration("classpath:test-application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryRepositoryTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(CountryRepositoryTest.class);
	@Autowired
	private CountryRepository countryRepository;
	@Autowired 
	private MongoTemplate mongoTemplate;
	
	@Before
	public void before(){
		mongoTemplate.indexOps(Country.class);
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Check if a country can be found when looked up in the repository</br>
	 * by it's iso3166-1 Alpha 2 code.
	 * @param country
	 */
	private void testCountryFound(final Country country){
		final Country foundCountry=countryRepository.findByIso31661Alpha2(country.getIso31661Alpha2());
		Assert.assertNotNull(foundCountry);
	}
	
	/**
	 * Check if a country cannot be found when looked up in the repository</br>
	 * by it's iso3166-1 Alpha 2 code.
	 * @param country
	 */
	private void testCountryNotFound(final Country country){
		final Country foundCountry=countryRepository.findByIso31661Alpha2(country.getIso31661Alpha2());
		Assert.assertNull(foundCountry);
	}
	
	/**
	 * Test the CRUD operations of Spring's MongoRepository.</br>
	 * Added this test to verify if the MongoDB is up and running</br>
	 * and all Spring configuration is correct.</br>
	 * </br>
	 * This test will create a new Country containing an iso3166-1 Alpha 2, Alpha 3 and Numeric code.</br>
	 * Also the full and short names in English and French are set.</br>
	 * Afterwards the Country is deleted.
	 */
	@Ignore
	@Test
	public void testCRUD(){
		final Country brazil=new Country();
		LOGGER.debug("New Country: {}",brazil);
		brazil.setIso31661Alpha2("BR");
		brazil.setIso31661Alpha3("BRA");
		brazil.setIso31661Numeric("076");
		brazil.setFullNameEnglish("the Federative Republic of Brazil");
		brazil.setFullNameFrench("la République fédérative du Brésil");
		brazil.setShortNameEnglish("Brazil");
		brazil.setShortNameFrench("Brésil (le)");
		LOGGER.debug("Set Country iso3166-1, full-name and short-name: {}",brazil);
		Assert.assertEquals("No countries should be counted.",0,countryRepository.count());
		countryRepository.save(brazil);
		testCountryFound(brazil);
		LOGGER.debug("Saved Country: {}",brazil);
		countryRepository.delete(brazil);
		LOGGER.debug("Deleted Country: {}",brazil);
		Assert.assertEquals("No countries should be counted.",0,countryRepository.count());
		testCountryNotFound(brazil);
	}
	
	@Ignore
	@Test
	public void testUnique(){
		final Country brazil=new Country();
		brazil.setIso31661Alpha2("BR");
		brazil.setIso31661Alpha3("BRA");
		brazil.setIso31661Numeric("076");
		brazil.setFullNameEnglish("the Federative Republic of Brazil");
		brazil.setFullNameFrench("la République fédérative du Brésil");
		brazil.setShortNameEnglish("Brazil");
		brazil.setShortNameFrench("Brésil (le)");
		countryRepository.save(brazil);
		final Country switzerland=new Country();
		switzerland.setIso31661Alpha2("BR");
		switzerland.setIso31661Alpha3("CHE");
		switzerland.setIso31661Numeric("756");
		switzerland.setFullNameEnglish("the Swiss Confederation");
		switzerland.setFullNameFrench("la Confédération suisse");
		switzerland.setShortNameEnglish("Switzerland");
		switzerland.setShortNameFrench("Suisse (la)");
		thrown.expect(DuplicateKeyException.class);
		thrown.expectMessage("test");
		countryRepository.save(switzerland);
	}

}
