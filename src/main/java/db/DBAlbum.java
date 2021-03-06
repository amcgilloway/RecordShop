package db;

import models.Album;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBAlbum {
    public static void saveAlbum(Album album) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(album);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Album> getAlbums()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Album> albums = null;
        try {
            transaction = session.beginTransaction();
            albums = session.createQuery("from Album").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return albums;
    }

    public static Album getAlbumById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Album album = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from Album where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            album = (Album) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return album;
    }

    public static void deleteAlbum(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Album album = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from Album where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            album = (Album) query.uniqueResult();
            session.delete(album);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateAlbum(Album album) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(album);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "delete from Album";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
            session.close();
        }
    }
}
