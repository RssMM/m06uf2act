package com.example.app;

import com.example.beans.Modulo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EscapeRoom {
    public static void main(String[] args) {
        int x=codigo1();
        int y=codigo2();
        int z=codigo3();
        int w=codigo4();
        System.out.println("El código descubierto es :" +x+y+z+w);
    }
    public static int codigo1() {
        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
        session1.beginTransaction();
        Query query = session1.createQuery("Select count(*) from Modulo");
        Long resposta = (Long) query.uniqueResult();
        return resposta.intValue();
    }
    public static int codigo2() {
        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session1.createQuery("Select count(distinct idModul) from Examen");
        Long resposta = (Long) query.uniqueResult();
        return resposta.intValue();
    }
    public static int codigo3() {
        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session1.createQuery("Select ceiling(avg(nota))from Examen where idModul = 1");
        Double resposta = (Double) query.uniqueResult();
        return resposta.intValue();
    }
    public static int codigo4() {
        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session1.createQuery("Select count(apellidos) from Alumno where apellidos like '%z%'");
        Long resposta = (Long) query.uniqueResult();
        return resposta.intValue();
    }
}
