package co.project.infrastructure.rail;

import java.util.ArrayList;
import java.util.HashMap;

import co.project.capteur.Capteur;
import co.project.exception.ErreurConstruction;
import co.project.feu.semaphore.Semaphore;
import co.project.infrastructure.Infrastructure;
import co.project.infrastructure.jonction.Jonction;
import co.project.train.Train;

public class Rail extends Infrastructure {
	/* 2 jonctions aux extremitees du rail */
	private Jonction gauche;
	private Jonction droite;
	private Semaphore semaDroite,semaGauche;
	
	

	public Semaphore getSemGauche() {
		return semaGauche;
	}

	public Semaphore getSemDroite() {
		return semaDroite;
	}

	/* nb de troncons/capteur */
	private HashMap<Capteur, Integer> capteurTroncon;
	
	private ArrayList<Train> trains;
	
	public ArrayList<Train> getTrains() {
		return trains;
	}
	
	public void retirerTrain(Train train)
	{
		trains.remove(train);
	}
	
	public void ajouterTrain(Train train)
	{
		if(!trains.contains(train))
			trains.add(train);
	}

	public Rail(int longueur) {
		super(longueur);
		trains = new ArrayList<Train>();
		capteurTroncon = new HashMap<Capteur, Integer>();
	}

	public Jonction getJonctionGauche() {
		return gauche;
	}

	public void setJonctionGauche(Jonction j1) {
		this.gauche = j1;
	}

	public Jonction getJonctionDroite() {
		return droite;
	}

	public void setJonctionDroite(Jonction j2) {
		this.droite = j2;
	}

	public HashMap<Capteur, Integer> getCapteurTroncon() {
		return capteurTroncon;
	}

	public void setCapteurTroncon(HashMap<Capteur, Integer> capteurNumeroTroncon) {
		this.capteurTroncon = capteurNumeroTroncon;
	}
	

	public Semaphore getSemaDroite() {
		return semaDroite;
	}

	public void setSemaDroite(Semaphore sema) {
		this.semaDroite = sema;
	}
	
	public Semaphore getSemaGauche() {
		return semaGauche;
	}

	public void setSemaGauche(Semaphore sema) {
		this.semaGauche = sema;
	}
	
	public void addCapteurTroncon(Capteur capt)throws ErreurConstruction{
		getCapteurTroncon().put(capt, capt.getNumTronconRail());
		//System.err.println("------>"+getCapteurTroncon().get(capt));
	}
	/**
	 * @return true/false si le rail est connectable ou pas
	 */
	public boolean connectable() {
		return (getJonctionDroite() == null || getJonctionGauche() == null);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		try {
			Rail r = (Rail) obj;
			if (r.idInfrastructure == this.idInfrastructure) {
				return true;
			} else {
				return false;
			}
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[ Rail id = " + idInfrastructure + "]";
	}

	@Override
	public boolean verifierElement() {
		return (getJonctionDroite() != null && getJonctionGauche() != null);
	}
	
}
