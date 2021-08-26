/**
 * 
 */
package src;

/**
 * La classe Arc, un arc XY, deux variables liees a une contrainte.
 *
 * @author 21203742 1603763
 */
public class Arc {

	/** la variable x. */
	Variable x;

	/** la variable y. */
	Variable y;

	/** le symbole de la contrainte. */
	String symbole;

	/** la valeur de la contrainte unaire. */
	Integer valeur;

	/** booleen si la contrainte est unaire. */
	boolean estUnaire;

	/** la contrainte c. */
	Contrainte c;

	/**
	 * Instancie un nouvel arc.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Arc(Variable x, Variable y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Instancie un nouvel arc.
	 *
	 * @param x         the x
	 * @param symbole   the symbole
	 * @param y         the y
	 * @param val       the val
	 * @param c         the c
	 * @param estUnaire the est unaire
	 */
	public Arc(Variable x, String symbole, Variable y, Integer val, Contrainte c, boolean estUnaire) {
		this.setX(x);
		this.setSymbole(symbole);
		this.setY(y);
		this.setValeur(val);
		this.setC(c);
		this.setUnaire(estUnaire);
	}

	/**
	 * Instancie un nouvel arc
	 *
	 * @param x       the x
	 * @param symbole the symbole
	 * @param y       the y
	 */
	public Arc(Variable x, String symbole, Integer y) {
		this.setX(x);
		this.setSymbole(symbole);
		this.setValeur(y);
	}

	/**
	 * Accesseur de la contrainte c.
	 *
	 * @return le c
	 */
	public Contrainte getC() {
		return c;
	}

	/**
	 * Mutateur de la contrainte c.
	 *
	 * @param c le c
	 */
	public void setC(Contrainte c) {
		this.c = c;
	}

	/**
	 * Accesseur de x.
	 *
	 * @return le x
	 */
	public Variable getX() {
		return x;
	}

	/**
	 * Mutateur de x.
	 *
	 * @param x le x
	 */
	public void setX(Variable x) {
		this.x = x;
	}

	/**
	 * Accesseur de y.
	 *
	 * @return le y
	 */
	public Variable getY() {
		return y;
	}

	/**
	 * Mutateur de y.
	 *
	 * @param y le y
	 */
	public void setY(Variable y) {
		this.y = y;
	}

	/**
	 * Accesseur du symbole.
	 *
	 * @return le symbole
	 */
	public String getSymbole() {
		return symbole;
	}

	/**
	 * Mutateur du symbole.
	 *
	 * @param symbole le symbole
	 */
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	/**
	 * Accesseur de valeur.
	 *
	 * @return la valeur
	 */
	public Integer getValeur() {
		return valeur;
	}

	/**
	 * Mutateur de valeur.
	 *
	 * @param valeur la valeur
	 */
	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	/**
	 * Verification du type de contrainte.
	 *
	 * @return le estUnaire
	 */
	public boolean isUnaire() {
		return estUnaire;
	}

	/**
	 * Mutateur de estunaire.
	 *
	 * @param val le estUnaire
	 */
	public void setUnaire(boolean val) {
		this.estUnaire = val;
	}

	/**
	 * To string.
	 *
	 * @return la chaine de caractere
	 */
	@Override
	public String toString() {
		if (valeur != null) {
			return "Arc [" + x + ", contrainte: " + symbole + ", " + valeur + "]";

		} else {
			return "Arc [" + x + ", contrainte: " + symbole + ", " + y + "]";
		}
	}

}
