package service;

import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import org.springframework.stereotype.Service;

@Service
public class WageService {
	Hashtable<String, NBP> books = new Hashtable<>();
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectMapper objectMapper1 = new ObjectMapper();
	Hashtable<Integer, Wage> wages = new Hashtable<>();
	double euro = 0;
	double funt = 0;
	double poObliczeniach =0;
	public WageService() throws Exception{
		NBP eur = objectMapper.readValue(new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json"), NBP.class );
		NBP gbp = objectMapper1.readValue(new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"), NBP.class );
		euro = eur.getRates().get(0).getMid();
		funt = gbp.getRates().get(0).getMid();
		System.out.println(eur.getRates().get(0).getMid());
		System.out.println(gbp.getRates().get(0).getMid());
	}

	public Collection<Wage> getWages() {
		System.out.println("G6");
		return wages.values();
	}
	public Collection<Wage> updateWages(double kwota, String waluta) {
		Wage a = new Wage();
		if (waluta.equals("EUR")){
			poObliczeniach = 0.8*(22*kwota - 800) * euro;
		}else if(waluta.equals("GBP")) {
			poObliczeniach = 0.75*(22*kwota - 600) * funt;
		}else if(waluta.equals("PLN")) {
				poObliczeniach = 0.81*(22*kwota-1200);
		}
		a.setKwota(poObliczeniach);
		a.setWaluta(waluta);
		wages.put(1,a);
		getWages();
		return wages.values();
	}
}


