package co.project.feu;

import co.project.exception.ErreurSignalisation;

public abstract class EtatFeu {

	/**
	 * @return etat actuel du feu
	 * @throws ErreurSignalisation
	 */
	public abstract EtatFeuEnum getEtatActuel() throws ErreurSignalisation;

	/**
	 * modifie l'�tat du feu
	 * @param EtatFeuEnum
	 * @throws ErreurSignalisation
	 */
	public abstract void setEtatActuel(EtatFeuEnum etat) throws ErreurSignalisation;

}
