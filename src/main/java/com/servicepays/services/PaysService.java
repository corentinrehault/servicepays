package com.servicepays.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.servicepays.beans.Pays;
import com.servicepays.services.exceptions.PaysNotFoundException;

@WebService (name="PaysService", serviceName="PaysService")
public interface PaysService {

	List<Pays> listEnsemblePays ();

	Pays getPaysByCode (@WebParam(name="codepays") String codepays) throws PaysNotFoundException;

	Pays getPaysByName (@WebParam(name="nom") String nom) throws PaysNotFoundException;

}
