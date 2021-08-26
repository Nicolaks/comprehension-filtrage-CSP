package src;

import java.util.ArrayList;

/**
 * @author 21203742 1603763
 */
/**
 * La classe ContrainteInferieur.
 */
public class ContrainteInferieur implements Contrainte {

	/** l' ensemble des variables. */
	ArrayList<Variable> ensembleVariables;

	/** variable x1. */
	Variable x1;

	/** variable x2. */
	Variable x2;

	/** valeur au lieu de variable pour la contrainte unaire. */
	Integer val;

	/** le symbole. */
	String symbole;

	/**
	 * Instancie une nouvelle contrainte inferieur binaire
	 *
	 * @param x1 la variable x1
	 * @param x2 la variable x2
	 */
	public ContrainteInferieur(Variable x1, Variable x2) {
		this.ensembleVariables = new ArrayList<Variable>();
		this.x1 = x1;
		this.x2 = x2;
		this.ensembleVariables.add(x1);
		this.ensembleVariables.add(x2);
		this.symbole = "<";
		this.setSymbole(symbole);
	}

	/**
	 * Instancie une nouvelle contrainte inferieur unaire.
	 *
	 * @param x1  la variable x1
	 * @param val la constante val
	 */
	public ContrainteInferieur(Variable x1, Integer val) {
		this.ensembleVariables = new ArrayList<Variable>();
		this.x1 = x1;
		this.setVal(val);
		this.ensembleVariables.add(x1);
		this.symbole = "< var";
		this.setSymbole(symbole);
	}

	/**
	 * Accesseur the ensemble variables.
	 *
	 * @return l ensemble des variables
	 */
	@Override
	public ArrayList<Variable> getEnsembleVariables() {
		return this.ensembleVariables;
	}

	/**
	 * Satisfait contrainte.
	 *
	 * @param a1 une valeur a1
	 * @param a2 une valeur a2
	 * @return true, si la contrainte est satisfaite
	 */
	@Override
	public boolean satisfaitContrainte(int a1, int a2) {
		boolean estSatisfait = false;
		if (a1 < a2) {
			estSatisfait = true;
		} else {
			explication(a1, a2);
			estSatisfait = false;

		}

		return estSatisfait;
	}

	/**
	 * To string.
	 *
	 * @return la chaine de caractere
	 */
	@Override
	public String toString() {

		if (this.val != null) {
			return this.x1.getNom() + "<" + this.val;
		} else {
			return this.x1.getNom() + "<" + this.x2.getNom();
		}
	}

	/**
	 * Accesseur de x.
	 *
	 * @return le x
	 */
	@Override
	public Variable getX() {
		return this.x1;
	}

	/**
	 * Accesseur de y.
	 *
	 * @return le y
	 */
	@Override
	public Variable getY() {
		return this.x2;
	}

	/**
	 * Explication d'une contrainte non satisfaite
	 *
	 * @param a1 le a1
	 * @param a2 le a2
	 */
	@Override
	public void explication(int a1, int a2) {
		System.out.println(a1 + " doit etre inferieur a " + a2 + " ,selon la contrainte " + this.toString());

	}

	/**
	 * Accesseur le symbole de la contrainte.
	 *
	 * @return le symbole
	 */
	@Override
	public String getSymbole() {
		return this.symbole;
	}

	/**
	 * Mutateur le symbole.
	 *
	 * @param symbole le symbole
	 */
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	/**
	 * Accesseur la valeur pour la contrainte unaire.
	 *
	 * @return la valeur
	 */
	@Override
	public Integer getValeur() {
		return val;
	}

	/**
	 * Mutateur la valeur.
	 *
	 * @param val la nouvelle valeur
	 */
	public void setVal(Integer val) {
		this.val = val;
	}

	/**
	 * Restreindre un domaine pour la contrainte unaire.
	 *
	 * @param x the x
	 * @param i the i
	 * @return true, si le domaine est modifie
	 */
	public boolean restreindre(Variable x, Integer i) {
		int tailleoriginale = x.getDomaine().getListeValeurs().size();
		ArrayList<Integer> liste = new ArrayList<>();
		liste.addAll(x.getDomaine().getListeValeurs());
		liste.removeIf(o -> o >= i);
		Domaine d = new Domaine(liste);
		x.setDomaine(d);
		if (tailleoriginale != liste.size()) {
			return true;
		}
		return false;

	}
}
