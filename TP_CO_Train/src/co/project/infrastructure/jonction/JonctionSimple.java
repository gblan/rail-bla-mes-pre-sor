package co.project.infrastructure.jonction;

import co.project.exception.ErreurConstruction;
import co.project.exception.ErreurJonction;
import co.project.infrastructure.rail.Rail;

public class JonctionSimple extends Jonction {

	public JonctionSimple(Rail rail1, Rail rail2) throws ErreurConstruction {
		super(0);
		rails.add(rail1);
		rails.add(rail2);
		initRailJonction();
	}

	@Override
	public Rail getRailSuivant(Rail rail) {
		
		if (rail.equals(getRailGauche())) {
			return getRailDroite();
		} else {
			return getRailGauche();
		} 
	}

	public Rail getRailGauche()
	{
		return rails.get(0);
	}
	
	public Rail getRailDroite()
	{
		return rails.get(1);
	}
	
	@Override
	public String toString() {
		return "[JS]";
	}

	@Override
	public void initRailJonction() throws ErreurConstruction {
		/*if (!getRailGauche().connectable() || !getRailDroite().connectable()) {
			throw new ErreurConstruction("Les 2 rails ont deja des jonctions, pose de jonction simple impossible");
		} else {*/
			if(getRailGauche().getJonctionDroite()==null){
				getRailGauche().setJonctionDroite(this);
			}
			
			if(getRailDroite().getJonctionGauche()==null){
				getRailDroite().setJonctionGauche(this);
			}
	}
	
	@Override
	public boolean verifierElement() {
		return (getRailGauche() != null && getRailDroite() != null);
	}
}
