/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author Tania
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class UserDAO {
    EntityManagerFactory em;

    public UserDAO(EntityManagerFactory emf) {
      em=emf;
    }
    public boolean saveUser(Usuario user) {
    EntityManager entityManager = em.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(user);
    entityManager.getTransaction().commit();
    entityManager.close();
    return true;
    }
    public boolean updateUser(Usuario user) {
    EntityManager entityManager = em.createEntityManager();
    entityManager.getTransaction().begin();
    Usuario updateUser=entityManager.find(Usuario.class, user.getId());
    updateUser.setNombre(user.getNombre());
    updateUser.setApellido(user.getApellido());
    updateUser.setDescripcion(user.getDescripcion());    
    entityManager.getTransaction().commit();
    entityManager.close();
    return true;
    }
    public boolean deleteUser(int id) {         
    EntityManager entityManager = em.createEntityManager();
    Usuario user=entityManager.find(Usuario.class, id);
    entityManager.getTransaction().begin();
    entityManager.remove(user);
    entityManager.getTransaction().commit();
    entityManager.close();
    return true;
    } 
    public List getUsers(){
    EntityManager entityManager = em.createEntityManager();
    entityManager.getTransaction().begin();
    List result = entityManager.createNamedQuery("Usuario.findAll").getResultList();    
    entityManager.getTransaction().commit();
    entityManager.close();
    return result;
    }
}
