package src;

/**
 * @author 21203742 1603763
 */

/**
 * La classe  Variable. Represente une variable d'un CSP
 *
 */

public class Variable {
    
    /** Le nom de la variable. */
    private String nom;
    
    /** Le domaine de la variable. */
    private Domaine domaine;

    /**
     * Instancie une nouvelle variable.
     *
     * @param nom le nom
     * @param domaine le domaine
     */
    public Variable(String nom, Domaine domaine) {
        this.setNom(nom);
        this.setDomaine(domaine);
    }

    /**
     * Accesseur le nom.
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mutateur le nom.
     *
     * @param nom le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur le domaine.
     *
     * @return le domaine
     */
    public Domaine getDomaine() {
        return domaine;
    }

    /**
     * Mutateur le domaine.
     *
     * @param domaine le domaine
     */
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }


    /**
     * To string.
     *
     * @return la chaine de characteres
     */
    @Override
    public String toString() {
        return   ("("+nom +":"+ domaine+") ");
    }

}
