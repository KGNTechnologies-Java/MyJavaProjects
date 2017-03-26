package kgn.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgn.spring.rest.bean.Country;

@RestController
public class CountryController {
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Country> getAllCountries(){
		List<Country> countries = new ArrayList<Country>();
		
		countries = createCountryList();		
		
		return countries;
	}
	
	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET,headers="Accept=application/json")
	public Country getCountryById(@PathVariable int countryId){
		List<Country> countries = new ArrayList<Country>();
		countries = createCountryList();
		for(Country country:countries){
			if(country.getCountryId() == countryId){
				return country;
			}
		}
		return null;
	}
	
	public List<Country> createCountryList(){
		List<Country> countries = new ArrayList<Country>();
		
		Country c1 = new Country(1,"India");
		Country c2 = new Country(2,"Denmark");
		Country c3 = new Country(3,"Germany");
		Country c4 = new Country(4,"France");
		Country c5 = new Country(5,"Luxumburg");
		Country c6 = new Country(6,"USA");
		
		countries.add(c1);
		countries.add(c2);
		countries.add(c3);
		countries.add(c4);
		countries.add(c5);
		countries.add(c6);
		
		return countries;
	}
	
	

}
