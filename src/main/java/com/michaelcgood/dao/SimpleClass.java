package com.michaelcgood.dao;

import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.EntityType;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SimpleClass implements SessionFactory {

    @Override
    public SessionFactoryImplementor getSessionFactory() {
        return null;
    }

    @Override
    public EntityType getEntityTypeByName(String entityName) {
        return null;
    }

    public SimpleClass() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public SessionFactoryOptions getSessionFactoryOptions() {
        return null;
    }

    @Override
    public SessionBuilder withOptions() {
        return null;
    }

    @Override
    public Session openSession() throws HibernateException {
        return null;
    }

    @Override
    public Session getCurrentSession() throws HibernateException {
        return null;
    }

    @Override
    public StatelessSessionBuilder withStatelessOptions() {
        return null;
    }

    @Override
    public StatelessSession openStatelessSession() {
        return null;
    }

    @Override
    public StatelessSession openStatelessSession(Connection connection) {
        return null;
    }

    @Override
    public Statistics getStatistics() {
        return null;
    }

    @Override
    public void close() throws HibernateException {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public Cache getCache() {
        return null;
    }

    @Override
    public Set getDefinedFilterNames() {
        return null;
    }

    @Override
    public FilterDefinition getFilterDefinition(String s) throws HibernateException {
        return null;
    }

    @Override
    public boolean containsFetchProfileDefinition(String s) {
        return false;
    }

    @Override
    public TypeHelper getTypeHelper() {
        return null;
    }

    @Override
    public ClassMetadata getClassMetadata(Class aClass) {
        return null;
    }

    @Override
    public ClassMetadata getClassMetadata(String s) {
        return null;
    }

    @Override
    public CollectionMetadata getCollectionMetadata(String s) {
        return null;
    }

    @Override
    public Map<String, ClassMetadata> getAllClassMetadata() {
        return null;
    }

    @Override
    public Map getAllCollectionMetadata() {
        return null;
    }

    @Override
    public Reference getReference() throws NamingException {
        return null;
    }

    @Override
    public <T> List<EntityGraph<? super T>> findEntityGraphsByType(Class<T> aClass) {
        return null;
    }

    @Override
    public Metamodel getMetamodel() {
        return null;
    }

    @Override
    public EntityManager createEntityManager() {
        return null;
    }

    @Override
    public EntityManager createEntityManager(Map map) {
        return null;
    }

    @Override
    public EntityManager createEntityManager(SynchronizationType synchronizationType) {
        return null;
    }

    @Override
    public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return null;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public PersistenceUnitUtil getPersistenceUnitUtil() {
        return null;
    }

    @Override
    public void addNamedQuery(String s, javax.persistence.Query query) {

    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> void addNamedEntityGraph(String s, EntityGraph<T> entityGraph) {

    }
}
