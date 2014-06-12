package be.seriousbusiness.java.mongodb.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Country {
	@Id
	private String id;
	/**
	 * Two-letter country code.
	 */
	private String iso3166_1Alpha2;
	/**
	 * Three-letter country code.
	 */
	private String iso3166_1Alpha3;
	/**
	 * Three-digit country codes.
	 */
	private String iso3166_1Numeric;
	private String fullNameFrench;
	private String fullNameEnglish;
	private String shortNameFrench;
	private String shortNameEnglish;
	
	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getIso3166_1Alpha2() {
		return iso3166_1Alpha2;
	}

	public void setIso3166_1Alpha2(final String iso3166_1Alpha2) {
		this.iso3166_1Alpha2 = iso3166_1Alpha2;
	}

	public String getIso3166_1Alpha3() {
		return iso3166_1Alpha3;
	}

	public void setIso3166_1Alpha3(final String iso3166_1Alpha3) {
		this.iso3166_1Alpha3 = iso3166_1Alpha3;
	}

	public String getIso3166_1Numeric() {
		return iso3166_1Numeric;
	}

	public void setIso3166_1Numeric(final String iso3166_1Numeric) {
		this.iso3166_1Numeric = iso3166_1Numeric;
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
		attributes.put("iso3166-1_Alpha2",iso3166_1Alpha2);
		attributes.put("iso3166-1_Alpha3",iso3166_1Alpha3);
		attributes.put("iso3166-1_Numeric",iso3166_1Numeric);
		attributes.put("fullNameFrench",fullNameFrench);
		attributes.put("fullNameEnglish",fullNameEnglish);
		attributes.put("shortNameFrench",shortNameFrench);
		attributes.put("shortNameEnglish",shortNameEnglish);
		return EntityStringBuilder.toString("Country",attributes);
	}
}
