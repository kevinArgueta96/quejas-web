/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quejas.diaco.svc.imp;

import com.quejas.diaco.ServiceBd;
import com.quejas.diaco.entity.TblUser;
import com.quejas.diaco.svc.UsuarioSvc;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author argue
 */
@Repository
@Transactional
public class UsuarioSvcImp extends ServiceBd implements UsuarioSvc, Serializable {

    @Override
    public TblUser obtenerUsuarioPorCredenciales(TblUser User) {
        String query = "FROM TblUser WHERE username = :username ";
        List<TblUser> listaU = entityManager.createQuery(query)
                .setParameter("username", User.getUsername())
                .getResultList();

        if (listaU.isEmpty()) {
            return null;
        }
        String PassHash = listaU.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (argon2.verify(PassHash, User.getPassword())) {
            return listaU.get(0);
        }
        return null;
    }

    @Override
    public void guardarUsu(TblUser usuario) {
        entityManager.merge(usuario);
    }

}
