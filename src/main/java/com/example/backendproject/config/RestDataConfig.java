package com.example.backendproject.config;
// I made sure all the packages were imported here
import com.example.backendproject.controllers.*;
import com.example.backendproject.dao.*;
import com.example.backendproject.entities.*;
import com.example.backendproject.services.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * <h1>RestDataConfig</h1>
 * per course instructions include this code to configure the rest api end-points exposed for the project
 * TODO restrict non-used rest api end points
 * <p>
 *
 * @author WGU Course Materials
 * @version 0.1
 * @since 2023-02-27
 */
@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {
    @Autowired //from baeldung resource
    private EntityManager entityManager;

    /**
     * @param config // This method exposes standard rest api end points for the following classes
     * @param cors //
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        Class[] classes = entityManager.getMetamodel()
                .getEntities().stream().map(Type::getJavaType).toArray(Class[]::new);

        config.exposeIdsFor(classes);
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Division.class);
        config.exposeIdsFor(Excursion.class);
        config.exposeIdsFor(Vacation.class);
        //config.exposeIdsFor(Cart.class);
        //config.exposeIdsFor(CartItem.class);
        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);
    }
}

