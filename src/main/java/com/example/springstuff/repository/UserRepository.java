package com.example.springstuff.repository;


import com.example.springstuff.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity findById(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    public UserEntity findByLogin(String login) {
        try {
            return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.login = :login", UserEntity.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



    @Transactional
    public void saveUser(@NonNull UserEntity user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } {
            entityManager.merge(user);
        }
    }
}
