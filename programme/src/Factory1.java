package src;

import java.util.ArrayList;

/**
 * @author 21203742 1603763
 */
/**
 * la classe Factory1, un exemple qui ne fonctionne pas. x!y; y!=z; z!=w;
 * domaines similaires
 */
public class Factory1 {

	/** La liste des domaines D. */
	ArrayList<Domaine> D;

	/** La liste des variables X. */
	ArrayList<Variable> X;

	/** La liste des contraintes binaires C. */
	ArrayList<Contrainte> C;

	/** La liste des contraintes unaires C2. */
	ArrayList<Contrainte> C2;

	/**
	 * Instancie un nouvel exemple factory1bis.
	 */
	public Factory1() {
		//////////// Domaines pour les variables x1,x2,x_3
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
		Variable x1 = new Variable("X", d1);
		Variable x2 = new Variable("Y", d2);
		Variable x3 = new Variable("Z", d3);
		Variable x4 = new Variable("W", d4);
		// ensemble des variables
		this.X = new ArrayList<Variable>();
		this.X.add(x1);
		this.X.add(x2);
		this.X.add(x3);
		this.X.add(x4);

		///////////// Contraintes du probleme
		this.C = new ArrayList<Contrainte>();
		this.C2 = new ArrayList<Contrainte>();

		Contrainte contrainteC1 = new ContrainteDifferent(x1, x2);
		Contrainte contrainteC2 = new ContrainteDifferent(x2, x3);
		Contrainte contrainteC3 = new ContrainteDifferent(x3, x4);
		Contrainte contrainteC4 = new ContrainteDifferent(x4, x1);

		/////////// ajout des contraintes binaire

		this.C.add(contrainteC1);
		this.C.add(contrainteC2);
		this.C.add(contrainteC3);
		this.C2.add(contrainteC4);

		//////// ajout des contraintes unaires

		///////////

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