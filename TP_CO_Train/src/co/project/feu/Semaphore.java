package co.project.feu;

import co.project.exception.ErreurSignalisation;

public abstract class Semaphore {

	protected EtatFeuEnum[] etatsPossibles;
	protected EtatFeuEnum etatActuel;

	/**
	 * @return etat actuel du feu
	 * @throws ErreurSignalisation
	 */
	public EtatFeuEnum getEtatActuel() throws ErreurSignalisation {
		return etatActuel;
	}

	/**
	 * modifie l'�tat du feu en passant par l'�tat du feu
	 * 
	 * @param EtatFeuEnum
	 * @throws ErreurSignalisation
	 */
	public abstract void setEtatActuel(EtatFeuEnum etatFeu) throws ErreurSignalisation;

}
