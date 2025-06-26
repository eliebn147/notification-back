package org.example.infra.repositories;

import org.example.infra.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepositoryJpa extends JpaRepository<NotificationEntity, Integer> {
}
