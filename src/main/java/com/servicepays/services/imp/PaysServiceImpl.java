package com.servicepays.services.imp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.servicepays.beans.Pays;
import com.servicepays.services.PaysService;
import com.servicepays.services.exceptions.PaysNotFoundException;
import com.servicepays.services.parser.ParsingService;

public class PaysServiceImpl implements PaysService {

	private ParsingService parsingPays = new ParsingService();
	private List<Pays> ensemblePays;

	@Override
	public List<Pays> listEnsemblePays() {
		
		try {

			ensemblePays = parsingPays.listPays();

		} catch (MalformedURLException e) {
			System.err.println("Erreur d'URL");
			System.err.println("Dans la méthode recupererListePays()");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Erreur d'entrée/sortie");
			System.err.println("Dans la méthode recupererListePays()");
			e.printStackTrace();
		}
		
		return ensemblePays;

	}

	@Override
	public Pays getPaysByCode(String codepays) throws PaysNotFoundException {
		return null;
	}

	@Override
	public Pays getPaysByName(String nom) throws PaysNotFoundException {
		return null;
	}

	/**
	 * @return the ensemblePays
	 */
	public List<Pays> getEnsemblePays() {
		return ensemblePays;
	}

	/**
	 * @param ensemblePays the ensemblePays to set
	 */
	public void setEnsemblePays(List<Pays> ensemblePays) {
		this.ensemblePays = ensemblePays;
	}

}
