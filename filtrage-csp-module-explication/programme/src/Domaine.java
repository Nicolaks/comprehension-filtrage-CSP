package src;

import java.util.ArrayList;

/**
 * @author 21203742 1603763
 */
/**
 * La classe Domaine. Domaine d'une variable.
 *
 */
public class Domaine {

	/** la liste des valeurs possibles d'une variable au depart. */
	private ArrayList<Integer> listeValeurs;

	/**
	 * Instancie un nouveau domaine.
	 *
	 * @param listeValeurs la liste des valeurs
	 */
	public Domaine(ArrayList<Integer> listeValeurs) {
		this.setListeValeurs(listeValeurs);
	}

	/**
	 * Accesseur la liste valeurs.
	 *
	 * @return la listeValeurs
	 */
	public ArrayList<Integer> getListeValeurs() {
		return listeValeurs;
	}

	/**
	 * Mutateur la liste valeurs.
	 *
	 * @param listeValeurs la listeValeurs
	 */
	public void setListeValeurs(ArrayList<Integer> listeValeurs) {
		this.listeValeurs = listeValeurs;
	}

	/**
	 * To string.
	 *
	 * @return la chaine de caracteres
	 */
	@Override
	public String toString() {
		return (listeValeurs.toString());
	}

}
