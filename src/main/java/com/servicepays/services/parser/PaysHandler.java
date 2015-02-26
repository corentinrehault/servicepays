/**
 * 
 */
package com.servicepays.services.parser;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.servicepays.beans.Pays;

/**
 * @author dao303
 *
 */
public class PaysHandler extends DefaultHandler {

	//résultats de notre parsing
	private List<Pays> ensemblePays;
	private Pays pays;
	//flags nous indiquant la position du parser
	@SuppressWarnings("unused")
	private boolean inPays, inCodepays, inListepays, inNom;
	//buffer nous permettant de récupérer les données
	private StringBuffer buffer;

	/**
	 * Simple constructeur hérité de la superclasse 
	 */
	public PaysHandler() {
		super();
	}

	//Détection d'ouverture de balise
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("listepays")) {

			ensemblePays = new ArrayList<Pays>();
			inListepays = true;

		} else if(qName.equals("pays")) {

			pays = new Pays();
			inPays = true;

		} else {

			buffer = new StringBuffer();
			if (qName.equals("nom")) {
				inNom = true;
			} else if(qName.equals("codepays")) {
				inCodepays = true;
			} else {
				throw new SAXException("Balise "+qName+" inconnue.");
			}

		}

	}

	//Détection de fin de balise
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("listepays")) {

			inListepays = false;

		} else if(qName.equals("pays")) {

			ensemblePays.add(pays);
			pays = null;
			inPays = false;

		} else if(qName.equals("nom")) {

			pays.setNom(buffer.toString());
			buffer = null;
			inNom = false;			

		} else if(qName.equals("codepays")) {

			pays.setCodepays(buffer.toString());
			buffer = null;
			inCodepays = false;

		} else {

			throw new SAXException("Balise "+qName+" inconnue.");

		}

	}

	//Détection de cartactères
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	public void characters(char [] ch, int start, int length) throws SAXException {
		String lecture = new String(ch, start, length);
		if(buffer != null) {
			buffer.append(lecture);
		}
	}

	//Début du parsing
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	public void startDocument() throws SAXException {
		System.out.println("Début du parsing");
	}

	//Fin du parsing
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	public void endDocument() throws SAXException {
		System.out.println("Fin du parsing");
		System.out.println("Résultats du parsing");
		for(Pays p : ensemblePays) {
		System.out.println(p);
		}
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
