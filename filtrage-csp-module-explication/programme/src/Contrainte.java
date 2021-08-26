package src;

import java.util.*;

/**
 * @author 21203742 1603763 Interface Contrainte. Pour representer une
 *         contrainte, binaire ou unaire
 *
 */

public interface Contrainte {

	/**
	 * Accesseur de ensemble des variables.
	 *
	 * @return l ensemble variables
	 */
	public abstract ArrayList<Variable> getEnsembleVariables();

	/**
	 * Accesseur de x.
	 *
	 * @return le x
	 */
	public Variable getX();

	/**
	 * Accesseur de y.
	 *
	 * @return le y
	 */
	public Variable getY();

	/**
	 * Accesseur de symbole.
	 *
	 * @return le symbole
	 */
	public String getSymbole();

	/**
	 * Restreindre. pour une contrainte unaire
	 *
	 * @param x la variable x
	 * @param i la valeur i
	 * @return true, si le domaine de la variable x a ete change
	 */
	public boolean restreindre(Variable x, Integer i);

	/**
	 * Methode de type boolean, qui regarde si une variable satisfait une regle.
	 *
	 * @param a1 la valeur vi d'une Variable X
	 * @param a2 la valeur vj d'une variable Y
	 * @return boolean , Un boolean qui renvoie si ca satisfait ou non la
	 *         contrainte.
	 */
	public boolean satisfaitContrainte(int a1, int a2);

	/**
	 * Explication.
	 *
	 * @param a1 une valeur a1
	 * @param a2 une valeur a2
	 */
	public void explication(int a1, int a2);

	/**
	 * Accesseur la valeur imposee sur la contrainte de type unaire .
	 *
	 * @return la valeur
	 */
	public Integer getValeur();

}
