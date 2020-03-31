package com.qintess.HibernateEstudo.Config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.HibernateEstudo.Model.ItemVenda;
import com.qintess.HibernateEstudo.Model.Produto;
import com.qintess.HibernateEstudo.Model.Venda;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {

            try {

                Configuration configuration = new Configuration();

                Properties prop = new Properties();

                // config de conexao ao banco de dados
            	prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/ConceitoHibernate?serverTimezone=UTC");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "asd123456!");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");


                prop.put(Environment.SHOW_SQL, "false");
                prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(prop);

                configuration.addAnnotatedClass(Produto.class);
                configuration.addAnnotatedClass(Venda.class);
                configuration.addAnnotatedClass(ItemVenda.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                    .applySettings(configuration.getProperties())
                                                    .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

}
