package co.project.infrastructure.jonction;

import co.project.exception.ErreurJonction;
import co.project.infrastructure.Infrastructure;
import co.project.infrastructure.rail.Rail;

public abstract class Jonction extends Infrastructure {

	public Jonction(int longueur) {
		super(longueur);
	}

	/**
	 * @param rail
	 * @return le rail suivant connecte a la joncton du rail en parametre
	 * @throws ErreurJonction
	 */
	abstract public Rail getRailSuivant(Rail rail) throws ErreurJonction;
	
	@Override
	public String toString() {
		return "[Jonction]";
	}
}