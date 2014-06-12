package be.seriousbusiness.java.mongodb.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.java.mongodb.entity.Country;

@ContextConfiguration("classpath:test-application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCountryRepository {
	private static final Logger LOGGER=LoggerFactory.getLogger(TestCountryRepository.class);
	@Autowired
	private CountryRepository countryRepository;
	
	/**
	 * Check if a country can be found when looked up in the repository</br>
	 * by it's iso3166-1 Alpha 2 code.
	 * @param country
	 */
	private void testCountryFound(final Country country){
		final Country foundCountry=countryRepository.findByIso3166_1Alpha2(country.getIso3166_1Alpha2());
		Assert.assertNotNull(foundCountry);
	}
	
	/**
	 * Check if a country cannot be found when looked up in the repository</br>
	 * by it's iso3166-1 Alpha 2 code.
	 * @param country
	 */
	private void testCountryNotFound(final Country country){
		final Country foundCountry=countryRepository.findByIso3166_1Alpha2(country.getIso3166_1Alpha2());
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
	@Test
	public void testCRUD(){
		final Country country=new Country();
		LOGGER.debug("New Country: {}",country);
		country.setIso3166_1Alpha2("BR");
		country.setIso3166_1Alpha3("BRA");
		country.setIso3166_1Numeric("076");
		country.setFullNameEnglish("the Federative Republic of Brazil");
		country.setFullNameFrench("la République fédérative du Brésil");
		country.setShortNameEnglish("Brazil");
		country.setShortNameFrench("Brésil (le)");
		LOGGER.debug("Set Country iso3166-1, full-name and short-name: {}",country);
		Assert.assertEquals("No countries should be counted.",0,countryRepository.count());
		countryRepository.save(country);
		testCountryFound(country);
		LOGGER.debug("Saved Country: {}",country);
		countryRepository.delete(country);
		LOGGER.debug("Deleted Country: {}",country);
		Assert.assertEquals("No countries should be counted.",0,countryRepository.count());
		testCountryNotFound(country);
	}

}
