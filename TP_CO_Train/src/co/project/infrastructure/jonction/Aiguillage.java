package co.project.infrastructure.jonction;
import java.util.ArrayList;
import java.util.List;

import co.project.ElemRegulation;
import co.project.exception.ErreurJonction;
import co.project.infrastructure.rail.Rail;


public class Aiguillage extends Jonction {

	/* au moins 3 rails*/
	private ArrayList<Rail> lRail;
	
	/* element de régulation*/
	private ElemRegulation elemRegul;
	
	public Aiguillage(ArrayList<Rail> lRail) {
		this.lRail = lRail;
	}

	@Override
	public Rail getRailSuivant(Rail rail) throws ErreurJonction {
		// TODO Auto-generated method stub
		return null;
	}
}
