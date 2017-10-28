/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenters;

import Models.UserDAO;
import Models.Usuario;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Tania
 */
public class UserPresenter {
    private final UserDAO userDao;
            
    public UserPresenter(EntityManagerFactory em){
     userDao=new UserDAO(em);
    }
    public List getUsers(){
    return userDao.getUsers();
    }
    public boolean saveUser(String nombre, String apellido, String descripcion){
        Usuario usuario= new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDescripcion(descripcion);
        return userDao.saveUser(usuario);
    }
    public boolean deleteUser(int id){
    return userDao.deleteUser(id);
    }
    public boolean updateUser(int id, String nombre, String apellido, String descripcion){
        Usuario usuario= new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDescripcion(descripcion);
    return userDao.updateUser(usuario);
    }
}
