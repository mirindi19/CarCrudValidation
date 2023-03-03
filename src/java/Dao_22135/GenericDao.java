/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao_22135;

import Util_22135.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Mirindi
 * @param <X>
 */
public class GenericDao<X> {
     Class<X> type;
    public GenericDao(Class<X> type) {
        this.type = type;
    }
    public void create(X obj) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(obj);
        ss.getTransaction().commit();
        ss.close();
    }
    public void update(X obj) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(obj);
        ss.getTransaction().commit();
        ss.close();
    }
    public void delete(X obj) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(obj);
        ss.getTransaction().commit();
        ss.close();
    }
    public List<X> findAll() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Query qry = ss.createQuery("from " + type.getName());
        List<X> list = qry.list();
        ss.close();
        return list;
    }
    public X findById(String id) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        X obj = (X) ss.get(type, id);
        ss.close();
        return obj;
    }
    public X finds(String name){
        Query query= HibernateUtil.getSessionFactory().openSession().
        createQuery("from "+ type.getName()+" where depname=:name");
        query.setParameter("name", name);
        X x = (X) query.uniqueResult();
        return x;
    }
    public X find(String name){
        Query query= HibernateUtil.getSessionFactory().openSession().
        createQuery("from "+ type.getName()+" where firstName=:name");
        query.setParameter("name", name);
        X x = (X) query.uniqueResult();
        return x;
    }
    public X findBook(String name){
        Query query= HibernateUtil.getSessionFactory().openSession().
        createQuery("from "+ type.getName()+" where title=:name");
        query.setParameter("name", name);
        X x = (X) query.uniqueResult();
        return x;
    }
    
}
