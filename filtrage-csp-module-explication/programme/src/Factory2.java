package src;

import java.util.ArrayList;

/**
 * @author 21203742 1603763
 */
/**
 * la classe Factory2, Exemple de la conférence.
 */
public class Factory2 {

	/** La liste des domaines D. */
	ArrayList<Domaine> D;

	/** La liste des variables X. */
	ArrayList<Variable> X;

	/** La liste des contraintes binaires C. */
	ArrayList<Contrainte> C;

	/** La liste des contraintes unaires C2. */
	ArrayList<Contrainte> C2;

	/**
	 * Instancie un nouvel exemple factory2.
	 */
	public Factory2() {
		//////////// Domaines pour les variables x1,x2,x3, x4
		ArrayList<Integer> listeValeursDomaine = new ArrayList<Integer>();
		listeValeursDomaine.add(1);
		listeValeursDomaine.add(2);
		listeValeursDomaine.add(3);
		listeValeursDomaine.add(4);

		Domaine d1 = new Domaine(listeValeursDomaine);
		Domaine d2 = new Domaine(listeValeursDomaine);
		Domaine d3 = new Domaine(listeValeursDomaine);
		Domaine d4 = new Domaine(listeValeursDomaine);

		// ensemble de domaines
		this.D = new ArrayList<Domaine>();
		this.D.add(d1);
		this.D.add(d2);
		this.D.add(d3);
		this.D.add(d4);
		///////////// Variables du probleme avec leur domaines respectifs
		Variable michel_alain = new Variable("Ma", d1);
		Variable michel_pierre = new Variable("Mp", d2);
		Variable alain_michel = new Variable("Am", d3);
		Variable pierre_michel = new Variable("Pm", d4);

		// ensemble des variables
		this.X = new ArrayList<Variable>();
		this.X.add(michel_alain);
		this.X.add(michel_pierre);
		this.X.add(alain_michel);
		this.X.add(pierre_michel);

		///////////// Contraintes du probleme
		this.C = new ArrayList<Contrainte>();
		this.C2 = new ArrayList<Contrainte>();

		Contrainte contrainteIntegriteC1 = new ContrainteDifferent(alain_michel, pierre_michel);

		Contrainte contrainteAnterioriteC2 = new ContrainteSuperieur(michel_alain, alain_michel);
		Contrainte contrainteAnterioriteC3 = new ContrainteSuperieur(michel_alain, pierre_michel);
		Contrainte contrainteAnterioriteC4 = new ContrainteSuperieur(michel_pierre, alain_michel);
		Contrainte contrainteAnterioriteC5 = new ContrainteSuperieur(michel_pierre, pierre_michel);

		Contrainte contrainteDemiJournee4C6 = new ContrainteDifferent(michel_alain, 4);
		Contrainte contrainteDemiJournee4C7 = new ContrainteDifferent(michel_pierre, 4);
		Contrainte contrainteDemiJournee4C8 = new ContrainteDifferent(pierre_michel, 4);
		Contrainte contrainteDemiJournee4C9 = new ContrainteDifferent(alain_michel, 4);

		Contrainte contrainteNonSimultaneiteC10 = new ContrainteDifferent(michel_alain, michel_pierre); 
		this.C.add(contrainteAnterioriteC5);// Mp>Pm
		this.C.add(contrainteAnterioriteC4); // Mp > Am
		this.C.add(contrainteIntegriteC1); //Am != Pm
		this.C.add(contrainteAnterioriteC3); //Ma > Pm
		this.C.add(contrainteAnterioriteC2); //Ma > Am
		this.C.add(contrainteNonSimultaneiteC10); //Ma != Mp


		this.C2.add(contrainteDemiJournee4C6); //Ma != 4
		this.C2.add(contrainteDemiJournee4C7); // Mp != 4
		this.C2.add(contrainteDemiJournee4C8); // Pm != 4
		this.C2.add(contrainteDemiJournee4C9); //Am != 4

	}

	/**
	 * Accesseur l' ensemble des domaines.
	 *
	 * @return l ensemble des domaines
	 */
	public ArrayList<Domaine> getEnsembleDomaines() {
		return this.D;
	}

	/**
	 * Accesseur l' ensemble des variables.
	 *
	 * @return l ensemble des variables
	 */
	public ArrayList<Variable> getEnsembleVariables() {
		return this.X;
	}

	/**
	 * Accesseur l' ensemble des contraintes binaires.
	 *
	 * @return l ensemble des contraintes binaires
	 */
	public ArrayList<Contrainte> getEnsembleContraintesBinaires() {
		return this.C;
	}

	/**
	 * Accesseur l' ensemble des contraintes unaires.
	 *
	 * @return l' ensemble des contraintes unaires
	 */
	public ArrayList<Contrainte> getEnsembleContraintesUnaires() {
		return this.C2;
	}
}