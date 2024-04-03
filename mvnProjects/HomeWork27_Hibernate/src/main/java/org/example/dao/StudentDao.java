package org.example.dao;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao {
    private SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("from Student").list();
        session.getTransaction().commit();
        session.close();
        return students;
    }
}
