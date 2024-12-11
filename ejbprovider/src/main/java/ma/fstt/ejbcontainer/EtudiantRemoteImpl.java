package ma.fstt.ejbcontainer;

import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import ma.fstt.entities.Etudiant;

import java.util.List;

@Stateless
public class EtudiantRemoteImpl implements EtudiantRemote {
    // Injection de l'EntityManager géré par le conteneur
    @PersistenceContext(unitName = "Etudiant")
    private EntityManager entityManager;

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        entityManager.persist(etudiant);
    }

    @Override
    public Etudiant trouverEtudiant(int id) {
        return entityManager.find(Etudiant.class, id);
    }

    @Override
    public void modifierEtudiant(Etudiant etudiant) {
        entityManager.merge(etudiant);
    }

    @Override
    public void supprimerEtudiant(int id) {
        Etudiant etudiant = entityManager.find(Etudiant.class, id);
        if (etudiant != null) {
            entityManager.remove(etudiant);
        }
    }

    @Override
    public List<Etudiant> listerEtudiants() {
        return entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
    }
}
