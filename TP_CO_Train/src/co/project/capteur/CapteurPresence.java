package co.project.capteur;

import co.project.ElemRegulation;

public class CapteurPresence extends Capteur {

	public CapteurPresence(ElemRegulation elm) {
		this.addObserver(elm);
	}

	/*
	 * TODO true si le train passe pendant l'unit� de temps courante, false
	 * sinon
	 */
	public boolean trainPassant() {
		return false;
	}

}
