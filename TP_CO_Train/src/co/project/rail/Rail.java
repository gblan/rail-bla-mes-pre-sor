package co.project.rail;

import co.project.feu.Semaphore;
import co.project.jonction.Jonction;


public class Rail {
	/* nb de troncons*/
	private int longueur;
	
	/* 2 jonctions aux extr�mit�s du rail */
	private Jonction j1;
	private Jonction j2;
	
	/* 2 feux a chaque extr�mit� de rail*/
	private Semaphore feu1;
	private Semaphore feu2;
}
