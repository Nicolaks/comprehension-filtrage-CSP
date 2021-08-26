package src;
/**
 * @author 21203742 1603763
 *
 */

/**
 * La Classe Main. Classe principale pour le lancement de notre module.
 */
public class Main {
	
	/**
	 * methode main.
	 *
	 * @param arg les arguments
	 */
	public static void main(String[] arg) {
		
		//Creation d'exemple de problemes de CSP
		Factory2 pb = new Factory2(); // Factory exemple de la conférence
		Factory1 test1 = new Factory1(); // exemple
		Factory1bis test2 = new Factory1bis(); // exemple
		Factory3 test3 = new Factory3(); // exemple
		Factory4 test4 = new Factory4(); // exemple de restrictions de domaines avec solution
		Factory5 test5 = new Factory5(); // exemple de domaine vide
		
		
		
		//ajout des données de l'exemple dans l'outil CSP
		CSP csp = new CSP(pb.getEnsembleVariables(), pb.getEnsembleContraintesBinaires(),
				pb.getEnsembleContraintesUnaires());
		
		CSP csp1 = new CSP(test1.getEnsembleVariables(), test1.getEnsembleContraintesBinaires(),
				test1.getEnsembleContraintesUnaires());
		
		CSP csp2 = new CSP(test2.getEnsembleVariables(), test2.getEnsembleContraintesBinaires(),
				test2.getEnsembleContraintesUnaires());
		
		CSP csp3 = new CSP(test3.getEnsembleVariables(), test3.getEnsembleContraintesBinaires(),
				test3.getEnsembleContraintesUnaires());
		CSP csp4 = new CSP(test4.getEnsembleVariables(), test4.getEnsembleContraintesBinaires(),
				test4.getEnsembleContraintesUnaires());
		
		CSP csp5 = new CSP(test5.getEnsembleVariables(), test5.getEnsembleContraintesBinaires(),
				test5.getEnsembleContraintesUnaires());
		
		
		/*Decommentez un des tests suivants pour tester, le dernier est fonctionnel:*/
		
		/*Lancement du test et de l'explication des valeurs retirees des domaines et/ou des domaines vides.*/
		
		/*probleme de la conference*************************/
		//csp.getResultat(); // pour tester le probleme de la conference // la solution pose souci car il y a des contrainte different, c'est la conference, il y a bien des explications sinon
		
		/*souci contraintes de difference*/
		//csp1.getResultat(); //exemple qui pose souci car il inclus uniquement des contraintes de type ContrainteDifferent binaire, ici memes domaines  au depart
		//csp2.getResultat(); //exemple qui pose souci car il inclus uniquement des contraintes de type ContrainteDifferent binaire, ici 2 domaines differents au depart
		
		/*exemple de restriction de domaine et solution****************/
		//csp3.getResultat(); //exemple qui fonctionne, contient plusieurs types de contraintes binaire et unaire  -> solution
		//csp4.getResultat(); //exemple qui fonctionne, contient plusieurs types de contraintes binaire et unaire mais pas de binaire de difference -> solution
		
		/*exemple d'explication avec domaine vide*****************/
		csp5.getResultat(); //exemple qui fonctionne (sans contrainte binaire de difference et sans contrainte unaire) -> domaine vide
		
	}
}
