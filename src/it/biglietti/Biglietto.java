package it.biglietti;

import java.math.BigDecimal;

public class Biglietto {
	
	
	//costanti
	private final BigDecimal PRICE_KM = new BigDecimal("0.21");
	private final BigDecimal DISCOUNT_OVER_65 = new BigDecimal("0.4");
	private final BigDecimal DISCOUNT_UNDER_18 = new BigDecimal("0.2");
	
	
	//attributi
	private int km;
	private int eta;
	
	
	//costruttore
	public Biglietto(int km, int eta){
		this.km = km;
		this.eta = eta;
	}

	
	//getter&setter
	public int getKm() {
		return km;
	}


	public void setKm(int km) {
		this.km = km;
	}


	public int getEta() {
		return eta;
	}


	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
	
	//metodi
	
	
	
	//validazione Km
	private boolean isValidKm() {
		
		if(km > 0) {
			return true;
			
		} else {
			return false;
		}
	}
		
		
	//validazione età
	private boolean isValidEta() {
		
		if(eta > 0 && eta <= 100) {
			return true;
			
		}else {
			return false;
		}
	}
	
	
	//calcolo sconto over/under
	private BigDecimal calcoloSconto() throws Exception{
		
		if(isValidEta()) {	
			
			if (eta > 65) {
				return DISCOUNT_OVER_65;
			} else if (eta < 18) {
				return DISCOUNT_UNDER_18;
			} else {
				return new BigDecimal("0");
			}
			
		}else {
			throw new Exception("Età deve essere compresa tra 0 e 100");
		}	
	}
	
	
	//calcolo prezzo biglietto
	public BigDecimal calcoloPrezzo() throws Exception{
		
		if (isValidKm()) {
			
			BigDecimal kmBd = BigDecimal.valueOf(km);
			BigDecimal discount = PRICE_KM.multiply(calcoloSconto().multiply(kmBd));
			
			return PRICE_KM.multiply(kmBd).subtract(discount);
			
		} else {
			throw new Exception("Km percorsi devono essere maggiori di 0");
		}
		
	}
	
	
}
