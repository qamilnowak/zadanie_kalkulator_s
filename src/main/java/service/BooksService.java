package service;

import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	Hashtable<String, NBP> books = new Hashtable<>();
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectMapper objectMapper1 = new ObjectMapper();
	Hashtable<String, Wage> wages = new Hashtable<>();
	public BooksService() throws Exception{
		NBP eur = objectMapper.readValue(new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json"), NBP.class );
		NBP gbp = objectMapper1.readValue(new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"), NBP.class );

		System.out.println(eur.getRates().get(0).getMid());
		System.out.println(gbp.getRates().get(0).getMid());

		Wage a = new Wage();
		a.setKwota(12);
		a.setWaluta("EUR");

		a.setKwota(a.getKwota() * eur.getRates().get(0).getMid());
		wages.put(a.getWaluta(), a);

	}

	public Collection<Wage> getWages() {
		return wages.values();
	}
	public Collection<Wage> updateWages(double kwotka) {
		Wage b = new Wage();
b.setKwota(1);
b.setWaluta("PLN");
		wages.put(b.getWaluta(),b);
		return wages.values();
	}
}


