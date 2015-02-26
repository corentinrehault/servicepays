package fr.servicepays.services;

import java.util.List;

import fr.servicepays.beans.Pays;

public interface PaysService {
	
	List<Pays> getEnsemblePays ();
	
	Pays getPaysByCode (String codepays);

}
