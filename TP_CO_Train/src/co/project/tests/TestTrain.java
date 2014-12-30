package co.project.tests;

import java.util.ArrayList;

import co.project.exception.ErreurConstruction;
import co.project.exception.ErreurJonction;
import co.project.exception.ErreurTrain;
import co.project.infrastructure.FabriqueInfrastructure;
import co.project.infrastructure.Infrastructure;
import co.project.infrastructure.Reseau;
import co.project.infrastructure.jonction.Aiguillage;
import co.project.infrastructure.jonction.Butee;
import co.project.infrastructure.jonction.JonctionSimple;
import co.project.infrastructure.rail.Rail;
import co.project.train.FabriqueTrain;
import co.project.train.Train;

public class TestTrain {
	
//	public static void main(String[] args) {
//		Rail r1 = FabriqueInfrastructure.creerRail(15);
//		Rail r2 = FabriqueInfrastructure.creerRail(15);
//		JonctionSimple js = FabriqueInfrastructure.connecterDeuxRails(r1, r2);
//		
//		ArrayList<Infrastructure> alInfra = new ArrayList<Infrastructure>();
//		alInfra.add(r1);
//		alInfra.add(js);
//		alInfra.add(r2);
//		Train train = FabriqueTrain.creerTrain(5, 300);
//
//		Reseau.getInstance().addPartieReseau(alInfra);
//		Reseau.getInstance().addTrain(train);
//		
//		System.out.println(r1);
//		System.out.println(r2);
//		System.out.println(js);
//		System.out.println(train);
//	}
	
	/* creation d'aiguillage*/
	public static void main(String[] args) {
		//Aiguillage aiguillage = FabriqueInfrastructure.creeAiguillageX();
		
		ArrayList<Infrastructure> infrastructure = new ArrayList<Infrastructure>();
		//infrastructure.add(aiguillage);
		Rail r1 = new Rail(10);
		Butee butee1 = new Butee(r1);
		infrastructure.add(butee1);
		infrastructure.add(r1);
		
		Rail r2 = new Rail(5);
		JonctionSimple js1 = new JonctionSimple(r1, r2);
		infrastructure.add(js1);
		infrastructure.add(r2);
		
		//MAJ de la jonction droite et gauche de r1
		r1.setJonctionGauche(butee1);
		r1.setJonctionDroite(js1);
		
		Rail r3 = new Rail(8);
		JonctionSimple js2 = new JonctionSimple(r2, r3);
		infrastructure.add(js2);
		infrastructure.add(r3);
		
		//MAJ de la jonction droite et gauche de r2
		r2.setJonctionGauche(js1);
		r2.setJonctionDroite(js2);
		
		Rail r4 = new Rail(10);
		JonctionSimple js3 = new JonctionSimple(r3, r4);
		infrastructure.add(js3);
		infrastructure.add(r4);
		
		//MAJ de la jonction droite et gauche de r3
		r3.setJonctionGauche(js2);
		r3.setJonctionDroite(js3);
		
		
		/*
		 * Rail de l'aiguillage r4,r5,r6 ...
		 */
		Rail r5 = new Rail(10);
		Rail r6 = new Rail(6);
		
		ArrayList<Rail> arrayRails = new ArrayList<Rail>();
		arrayRails.add(r4);
		arrayRails.add(r5);
		arrayRails.add(r6);
		Aiguillage a1 = FabriqueInfrastructure.connecterPlusieursRails(arrayRails);
		
		infrastructure.add(a1);
		infrastructure.add(r5);
		infrastructure.add(r6);
		
		//MAJ de la jonction droite et gauche de r4
		r4.setJonctionGauche(js3);
		r4.setJonctionDroite(a1);
		
		Reseau.getInstance().addPartieReseau(infrastructure);
		
		Rail pCourante = null;
		//Pour le moment je prend la premier rail que je trouve
		for(Infrastructure infra : Reseau.getInstance().getReseauInfra())
		{
			try {
				pCourante = (Rail)infra;
				break;
			} catch (ClassCastException e) {
				// TODO: handle exception
			}
		}
		
		for(Infrastructure infra : Reseau.getInstance().getReseauInfra())
		{
			System.out.print(infra+" ");
		}
		System.out.println("\n");
		
		Train train = FabriqueTrain.creerTrain(5, 300, pCourante);
		Reseau.getInstance().addTrain(train);
		
		
		try {
			Reseau.getInstance().verifieReseau();
			
			try {
				Reseau.getInstance().deplacementTrain(train);
			} catch (ErreurJonction | ErreurTrain e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Nouveau etat du réseau : \n"+Reseau.getInstance());
			
		} catch (ErreurConstruction e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	/* Arret du train a un aiguillage pour permettre le passage d'un autre train */
//	public static void main(String[] args) {
//		FabriqueInfrastructure.creerRail(15);
//	}
}