package com.mitocode.dao;

import com.mitocode.model.Telefono;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TelefonoDAOImpl extends AbstractDAO implements ITelefonoDAO {

    @Override
    public void registrar(Telefono telefono) {
        persist(telefono);
    }

}
