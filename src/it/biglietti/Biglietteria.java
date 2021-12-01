package it.biglietti;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("BIGLIETTO TRENO OOP");
		System.out.println("********************");
		
		
		System.out.print("Inserire i Km da percorrere: ");
		int km = scanner.nextInt();
		
		System.out.print("Inserire l'età: ");
		int eta = scanner.nextInt();
		
		
		Biglietto b = new Biglietto(km, eta);
		
		
		try {
			System.out.println("Il prezzo del biglietto è: " + b.calcoloPrezzo() + "€");
		} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
		
		scanner.close();
	}

}
