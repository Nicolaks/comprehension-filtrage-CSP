package src;

/**
 * @author 21203742 1603763
 *
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe CSP, reprenant les elements d'un CSP (Variables, Domaines,
 * Contraintes), et appliquant l'arc coherence avec l'algorithme AC3 et la
 * methode revise.
 */
public class CSP {

	/** X. Les variables */
	ArrayList<Variable> X;

	/** L'instanciation(=assignation de variable avec valeur). */
	HashMap<Variable, Integer> instanciation = new HashMap<Variable, Integer>();

	/** Les arcs. */
	ArrayList<Arc> lesArcs;

	/** C. Les contraintes binaires */
	ArrayList<Contrainte> C;

	/** C2. Les contraintes unaires */
	ArrayList<Contrainte> C2;

	/**
	 * Instancie un nouveau CSP.
	 *
	 * @param X  l'ensemble des variables du CSP X
	 * @param C  l'ensemble des contraintes binaires du CSP C
	 * @param C2 l'ensemble des contraintes unaires du CSP C2
	 */
	public CSP(ArrayList<Variable> X, ArrayList<Contrainte> C, ArrayList<Contrainte> C2) {
		this.lesArcs = new ArrayList<>();
		this.C = C;
		this.C2 = C2;
		this.X = X;
		
		
		

		

	}

	/**
	 * Methode pour la creation des arcs.
	 */
	public void creationArcs() {
		
		System.out.println("Ensemble des contraintes imposees au depart: \n");
		if(this.C != null && !this.C.isEmpty() ) {
			System.out.println(this.C);
			
			if (this.C2 != null && !this.C2.isEmpty()) {
				System.out.println(this.C2);
				for (Contrainte constr : this.C2) {
					Arc a = new Arc(constr.getEnsembleVariables().get(0), constr.getSymbole(), null, constr.getValeur(),
							constr, true);
					lesArcs.add(a);

				}
			}else {
				System.out.println("Il n'a pas de contraintes binaires");
			}
			
			for (Contrainte constr : this.C) {
				if (constr.getSymbole().equals("<")) {
					Arc a = new Arc(constr.getEnsembleVariables().get(0), constr.getSymbole(),
							constr.getEnsembleVariables().get(1), null, constr, false);
					Contrainte contrainteinverse = new ContrainteSuperieur(constr.getEnsembleVariables().get(1),
							constr.getEnsembleVariables().get(0));
					Arc b = new Arc(contrainteinverse.getEnsembleVariables().get(0), contrainteinverse.getSymbole(),
							contrainteinverse.getEnsembleVariables().get(1), null, contrainteinverse, false);
					lesArcs.add(a);
					lesArcs.add(b);
				} else if (constr.getSymbole().equals(">")) {
					Arc a = new Arc(constr.getEnsembleVariables().get(0), constr.getSymbole(),
							constr.getEnsembleVariables().get(1), null, constr, false);
					Contrainte contrainteinverse = new ContrainteInferieur(constr.getEnsembleVariables().get(1),
							constr.getEnsembleVariables().get(0));
					Arc b = new Arc(contrainteinverse.getEnsembleVariables().get(0), contrainteinverse.getSymbole(),
							contrainteinverse.getEnsembleVariables().get(1), null, contrainteinverse, false);
					lesArcs.add(a);
					lesArcs.add(b);
				} else if (constr.getSymbole().equals("==")) {
					Arc a = new Arc(constr.getEnsembleVariables().get(0), constr.getSymbole(),
							constr.getEnsembleVariables().get(1), null, constr, false);
					Contrainte contrainteinverse = new ContrainteEgale(constr.getEnsembleVariables().get(1),
							constr.getEnsembleVariables().get(0));
					Arc b = new Arc(contrainteinverse.getEnsembleVariables().get(0), contrainteinverse.getSymbole(),
							contrainteinverse.getEnsembleVariables().get(1), null, contrainteinverse, false);
					lesArcs.add(a);
					lesArcs.add(b);
				} else if (constr.getSymbole().equals("!=")) {
					Arc a = new Arc(constr.getEnsembleVariables().get(0), constr.getSymbole(),
							constr.getEnsembleVariables().get(1), null, constr, false);
					Contrainte contrainteinverse = new ContrainteDifferent(constr.getEnsembleVariables().get(1),
							constr.getEnsembleVariables().get(0));
					Arc b = new Arc(contrainteinverse.getEnsembleVariables().get(0), contrainteinverse.getSymbole(),
							contrainteinverse.getEnsembleVariables().get(1), null, contrainteinverse, false);
					lesArcs.add(a);
					lesArcs.add(b);
				}
			}
			
		}else {
			System.out.println("Il n'a pas de contraintes binaires");
		}
		
		
		

		

	}

	/**
	 * Initialise l'instanciation.
	 */
	public void initInstanciation() {
		for (Variable x : this.X) {
			this.instanciation.put(x, null); // on met toutes les variables a null au depart
		}
	}

	/**
	 * Obtenir l'ensemble des Variables X.
	 *
	 * @return X
	 */
	public ArrayList<Variable> getX() {
		return X;
	}

	/**
	 * Obtenir l'ensemble des contraintes C.
	 *
	 * @return C
	 */
	public ArrayList<Contrainte> getC() {
		return C;
	}

	/**
	 * Est arc coherent. Un CSP arc-coherent ssi aucun domaine n'est vide et si
	 * toutes les valeurs des domaines sont viables
	 *
	 * @param instanciation l'instanciation
	 * @return true, si c'est arc coherent
	 */
	public boolean estArcCoherent(HashMap<Variable, Integer> instanciation) {
		boolean estArcCoherent = true;
		List<Boolean> listebool = new ArrayList<Boolean>();

		for (Map.Entry<Variable, Integer> set : instanciation.entrySet()) {
			// aucun domaine vide
			if (set.getKey().getDomaine().getListeValeurs() != null) {
				if (set.getKey().getDomaine().getListeValeurs().size() != 0) {
					if (set.getValue() != null) {
						listebool.add(true);
					} else {
						listebool.add(false);
					}
				} else {
					listebool.add(false);
				}
			} else {
				listebool.add(false);
			}
		}

		if (listebool.contains(false)) {
			estArcCoherent = false;
		}
		return estArcCoherent;
	}

	/**
	 * Algorithme AC3. algorithme de filtrage pour rendre un CSP arc coherent si
	 * possible
	 *
	 * @return true, s'il a reussi
	 */
	public boolean AC3() {
		this.initInstanciation();
		// creation de la pile d'arcs
		Deque<Arc> Q = new ArrayDeque<>();
		Q.addAll(this.lesArcs);

		// parcours de la pile d'arcs
		while (Q.size() != 0) {
			Arc p = Q.pop();
			System.out.println("*-----------------------------------------------------*");
			System.out.println("Etude de l'arc: " + p);

			if (revise(p)) { // si le domaine de la variable xi de l'arc p a change

				if (!p.estUnaire) { // si la contrainte de l'arc est de type binaire
					for (Arc a : this.lesArcs) {
						if (!a.estUnaire) {
							// prendre arc xk, xi, voisin de l'arc xi,xj
							if (a.getX() != p.getX() && a.getY() == p.getX()) {
								// l'ajouter à la pile d'arc pour une nouvelle etude
								Q.push(a);
							}
						}

					}
				} else { // si la contrainte de l'arc est de type unaire
					for (Arc a : this.lesArcs) {
						if (!a.estUnaire) {
							// prendre arc contenant xi
							if (a.getX() == p.getX()) {
								if (!Q.contains(a)) {
									Q.push(a);
								}
							}
						}
					}
				}

				// s'il s'avere que le domaine de la variable xi est devenu vide, le resultat
				// n'est plus arc coherent
				if (p.getX().getDomaine().getListeValeurs().size() == 0) {
					System.out.println(
							" ***** Le domaine de  " + p.getX().getNom() + " est vide avec la contrainte " + p.getC() + " *****");
					return false;
				}
			} else {
				System.out.println(
						"L'arc ne pose aucun probleme, aucune valeur n'a ete retiree de xi pour la contrainte: "
								+ p.getC() + "\n");
			}
			System.out.println("*-----------------------------------------------------*");
		}
		return true;

	}

	/**
	 * Revise. Methode qui retire du domaine Di de la variable xi les valeurs sans
	 * support pour la contrainte ci,j
	 *
	 * @param p un arc XY etudie
	 * @return true, if successful
	 */

	public boolean revise(Arc p) {
		// initialise l'elimination d'une valeur de la variable X a faux
		boolean eliminer = false;

		// recuperation de la contrainte de l'arc etudie
		Contrainte c = p.getC();

		// recuperation de la Variable X de l'arbre etudie
		Variable xi = p.getX();

		Set<Integer> listeValEnleverDeXi = new HashSet<>();

		if (p.isUnaire()) { // si la contrainte est unaire
			System.out.println(xi.getNom() + " unaire domaine avant : " + xi.getDomaine().getListeValeurs());
			Integer i = p.getValeur();
			eliminer = c.restreindre(xi, i);
			System.out.println(xi.getNom() + " unaire domaine apres: " + xi.getDomaine().getListeValeurs());

		} else { // si la contrainte est binaire
			Variable xj = p.getY();
			if (xi == null) {
			} else if (xj == null) {
			} else {
				ArrayList<Integer> di = xi.getDomaine().getListeValeurs();
				ArrayList<Integer> dj = xj.getDomaine().getListeValeurs();
				// System.out.println("domaine de " + xi.getName() + " avant : " +
				// xi.getDomaine().getListeValeurs());

				Iterator<Integer> iterator = di.iterator();
				while (iterator.hasNext()) {
					int vi = iterator.next(); // une des valeur du domaine di
					ArrayList<Boolean> s = new ArrayList<>();
					System.out.println("\n Verification de la valeur " + vi + " de " + xi.getNom());
					for (int vj : dj) {

						if (!c.satisfaitContrainte(vi, vj)) {
							System.out.println("-> contrainte non satisfaite pour " + vi + "-" + vj);
							s.add(false);
						} else { // peut le faire donc support
							// System.out.println("contrainte satisfaite pour " + vi + "-" + vj);
							s.add(true);
						}
					}

					System.out.println("\n Existe il au moins 1 support pour la valeur: " + vi + " de la variable "
							+ xi.getNom() + " ?" + s + "\n");
					// s'il y a au moins une valeur support: eliminer = false
					int compteurSupport = 0;
					for (int i = 0; i < s.size(); i++) {
						if (s.get(i) == true) {
							compteurSupport += 1;
						} else {
						}
					}

					// une valeur est viable ssi elle possede au moins 1 support pour chacune des
					// contraintes portant sur elle
					if (compteurSupport >= 1) {
						System.out.println("... Oui, il y a au moins 1 support pour la valeur: " + vi
								+ " du domaine de " + xi.getNom() + " pour la contrainte " + c);
						System.out.println(".... je garde la valeur : " + vi + " qui est viable \n");
					} else {
						listeValEnleverDeXi.add(vi);
						System.out.println(
								"...Non , ajout a la liste des retrait la valeur valant : " + vi + " du domaine de "
										+ xi.getNom() + " car il n'est pas support pour la contrainte " + c);
					}
				}

				if (listeValEnleverDeXi.size() > 0) {
					System.out.println("Elements a enlever de du domaine de la Variable " + xi + " : "
							+ listeValEnleverDeXi + "\n");
					ArrayList<Integer> dd = new ArrayList<>();
					dd.addAll(xi.getDomaine().getListeValeurs());
					dd.removeAll(listeValEnleverDeXi);
					Domaine dk = new Domaine(dd);
					xi.setDomaine(dk);
					eliminer = true;
					this.instanciation.put(xi, null);
					// System.out.println("Instanciation modifiee après elimination: " +
					// this.instanciation);

				} else {
					// arbitraire
					this.instanciation.put(xi, xi.getDomaine().getListeValeurs().get(0));
					// System.out.println("Instanciation modifie: ajout d'une nouvelle valeur: " +
					// this.instanciation);
				}

				// System.out.println("domaine de " + xi.getName() + " apres : " +
				// xi.getDomaine().getListeValeurs());
			}

		}

		return eliminer;
	}

	/**
	 * Obtenir l' assignation.
	 *
	 * @return l'assignation
	 */
	public HashMap<Variable, Integer> getAssignation() {
		return this.instanciation;
	}

	/**
	 * Obtenir le resultat du probleme.
	 *
	 * @return le resultat
	 */
	public void getResultat() {
		
		// creation de l'ensembles des arcs de notre CSP
		this.creationArcs();
		
		System.out.println("----------------------");

		System.out.println("- Debut de la resolution");
		// verifier bien support......

		System.out.println("Ac3 : " + AC3());

		System.out.println("Avant tests de coherence: " + this.instanciation);

		System.out.println("- Fin de la resolution");

		System.out.println("----------------------");
		System.out.println("-- Est ce arc coherent ? ");

		if (this.estArcCoherent(this.getAssignation())) {
			System.out.println("-- OUI -- ");
			System.out.println("---Solution complete: " + this.getAssignation());
			System.out.println("----Detail:");
			for (Map.Entry<Variable, Integer> set : instanciation.entrySet()) {
				System.out.println("Variable " + set.getKey().getNom() + " = " + set.getValue());
			}
		} else {
			System.out.println("-- NON --");
			System.out.println("---Solution partielle: " + this.getAssignation());
		}
	}
}
