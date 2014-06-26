package be.seriousbusiness.java.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import be.seriousbusiness.java.mongodb.entity.Country;

public interface CountryRepository extends MongoRepository<Country,String> {
	public Country findByIso31661Alpha2(final String iso31661Alpha2); // iso3166_1Alpha2
}
