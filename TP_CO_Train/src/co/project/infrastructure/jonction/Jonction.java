package co.project.infrastructure.jonction;

import java.util.ArrayList;

import co.project.exception.ErreurConstruction;
import co.project.exception.ErreurJonction;
import co.project.infrastructure.Infrastructure;
import co.project.infrastructure.rail.Rail;

public abstract class Jonction extends Infrastructure {

	protected ArrayList<Rail> rails;
	
	public Jonction(int longueur) {
		super(longueur);
		rails = new ArrayList<Rail>();
	}

	/**
	 * @param rail
	 * @return le rail suivant connecte a la joncton du rail en parametre
	 * @throws ErreurJonction
	 */
	abstract public Rail getRailSuivant(Rail rail);
	
	/**
	 * Cette methode, apellee dans le constructeur de la jonction, 
	 * permet de lier l'extremite du rail a la jonction actuelle
	 * @throws ErreurConstruction
	 */
	abstract public void initRailJonction() throws ErreurConstruction;
	
	@Override
	public String toString() {
		return "[Jonction]";
	}
}
