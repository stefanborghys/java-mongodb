package be.seriousbusiness.java.mongodb.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Country {
	@Id
	private String id;
	/**
	 * Two-letter ISO3166-1 Alpha 2 country code.
	 */
	@Indexed(unique=true,dropDups=true)
	private String iso31661Alpha2;
	/**
	 * Three-letter ISO3166-1 Alpha 3 country code.
	 */
	@Indexed(unique=true,dropDups=true)
	private String iso31661Alpha3;
	/**
	 * Three-digit ISO3166-1 Numeric country codes.
	 */
	@Indexed(unique=true,dropDups=true)
	private String iso31661Numeric;
	@Indexed(unique=true,dropDups=true)
	private String fullNameFrench;
	@Indexed(unique=true,dropDups=true)
	private String fullNameEnglish;
	@Indexed(unique=true,dropDups=true)
	private String shortNameFrench;
	@Indexed(unique=true,dropDups=true)
	private String shortNameEnglish;
	
	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getIso31661Alpha2() {
		return iso31661Alpha2;
	}

	public void setIso31661Alpha2(final String iso31661Alpha2) {
		this.iso31661Alpha2 = iso31661Alpha2;
	}

	public String getIso31661Alpha3() {
		return iso31661Alpha3;
	}

	public void setIso31661Alpha3(final String iso31661Alpha3) {
		this.iso31661Alpha3 = iso31661Alpha3;
	}

	public String getIso31661Numeric() {
		return iso31661Numeric;
	}

	public void setIso31661Numeric(final String iso31661Numeric) {
		this.iso31661Numeric = iso31661Numeric;
	}

	public String getFullNameFrench() {
		return fullNameFrench;
	}

	public void setFullNameFrench(final String fullNameFrench) {
		this.fullNameFrench = fullNameFrench;
	}

	public String getFullNameEnglish() {
		return fullNameEnglish;
	}

	public void setFullNameEnglish(final String fullNameEnglish) {
		this.fullNameEnglish = fullNameEnglish;
	}

	public String getShortNameFrench() {
		return shortNameFrench;
	}

	public void setShortNameFrench(final String shortNameFrench) {
		this.shortNameFrench = shortNameFrench;
	}

	public String getShortNameEnglish() {
		return shortNameEnglish;
	}

	public void setShortNameEnglish(final String shortNameEnglish) {
		this.shortNameEnglish = shortNameEnglish;
	}

	@Override
	public String toString(){
		final Map<String,Object> attributes=new HashMap<String,Object>();
		attributes.put("id",id);
		attributes.put("iso3166-1_Alpha2",iso31661Alpha2);
		attributes.put("iso3166-1_Alpha3",iso31661Alpha3);
		attributes.put("iso3166-1_Numeric",iso31661Numeric);
		attributes.put("fullNameFrench",fullNameFrench);
		attributes.put("fullNameEnglish",fullNameEnglish);
		attributes.put("shortNameFrench",shortNameFrench);
		attributes.put("shortNameEnglish",shortNameEnglish);
		return EntityStringBuilder.toString("Country",attributes);
	}
}
