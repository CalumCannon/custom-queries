package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    //move to whiskey????????? OR MAYBE TRY DIFF TYPE
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getAllWhiskiesFromYear(int year) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);
            //cr.add(Restrictions.)
            cr.createAlias("whiskies", "whiskyAlias");
            cr.add(Restrictions.eq("whiskyAlias.year", year));
            result = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
            System.out.println(ex.getCause());
        }

        return result;

    }

}
