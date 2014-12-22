package co.project.infrastructure.rail;

import java.math.BigInteger;
import java.util.HashMap;

import co.project.capteur.Capteur;
import co.project.infrastructure.Infrastructure;
import co.project.infrastructure.jonction.Jonction;

public class Rail extends Infrastructure {
	/* nb de troncons TODO*/

	/* 2 jonctions aux extrémités du rail */
	private Jonction j1;
	private Jonction j2;

	private HashMap<Capteur, Integer> capteurNumeroTroncon;

	public Rail(int longueur, int idRail) {
		super(longueur, idRail);
	}

	public void setJ1(Jonction j1) {
		this.j1 = j1;
	}

	public void setJ2(Jonction j2) {
		this.j2 = j2;
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
}
