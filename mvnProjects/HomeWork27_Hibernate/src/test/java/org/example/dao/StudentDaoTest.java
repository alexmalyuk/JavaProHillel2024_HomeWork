package org.example.dao;

import org.example.config.HibernateSession;
import org.example.entity.Student;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private static SessionFactory sessionFactory = null;

    @BeforeClass
    public static void setUp() throws Exception {
        sessionFactory = HibernateSession.getSessionFactory();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        HibernateSession.shutdown();
    }

    @Test
    @Order(1)
    public void testAdd() {
        StudentDao dao = new StudentDao(sessionFactory);
        dao.save(new Student("Petrenko", "petrenko1980@mail.com"));
        dao.save(new Student("Kovalenko", "kovalenko2002@mail.com"));
        dao.save(new Student("Kabanenko", "kabanenko777@mail.com"));
    }

    @Test
    public void testUpdate() {
        StudentDao dao = new StudentDao(sessionFactory);

        int TEST_ID = 2;
        String NEW_NAME = "New name";

        Student st = dao.get(TEST_ID);
        st.setName(NEW_NAME);
        dao.update(st);

        Student st2 = dao.get(TEST_ID);
        assertEquals(NEW_NAME, st2.getName());
    }

    @Test
    public void testDelete() {
        int TEST_ID = 1;
        StudentDao dao = new StudentDao(sessionFactory);
        Student st = dao.get(TEST_ID);
        dao.delete(st);
        Student st2 = dao.get(TEST_ID);
        assertNull(st2);
    }

    @Test
    public void testRetrieveOne() {
        int TEST_ID = 2;
        StudentDao dao = new StudentDao(sessionFactory);
        Student st = dao.get(TEST_ID);
        assertEquals(TEST_ID, st.getId());
    }

    @Test
    public void testRetrieveAll() {
        StudentDao dao = new StudentDao(sessionFactory);
        List<Student> studentList = dao.getAll();
        assertFalse(studentList.isEmpty());
    }

}