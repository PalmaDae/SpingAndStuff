package com.example.springstuff.repository;


import com.example.springstuff.entity.UserEntity;
import com.example.springstuff.entity.UserStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryManager {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(UserEntity user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }


    public UserEntity findById(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        UserEntity user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public List<UserEntity> findByStatus(UserStatus status) {
        return entityManager.createQuery(
                        "SELECT u FROM UserEntity u WHERE u.status = :status", UserEntity.class)
                .setParameter("status", status)
                .getResultList();
    }
}
