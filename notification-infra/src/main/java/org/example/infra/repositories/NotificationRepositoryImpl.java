package org.example.infra.repositories;


import org.example.core.repositories.NotificationRepository;
import org.example.domain.entities.Notification;
import org.example.infra.entities.NotificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationRepositoryJpa jpaRepository;

    @Autowired
    public NotificationRepositoryImpl(NotificationRepositoryJpa jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Notification save(Notification notification) {
        NotificationEntity entity = new NotificationEntity(
                0,
                notification.getMessage(),
                notification.getRecipient(),
                notification.getType()
        );
        NotificationEntity saved = jpaRepository.save(entity);
        return new Notification(saved.getId(), saved.getMessage(), saved.getRecipient(), saved.getType());
    }

    @Override
    public List<Notification> findAll() {
        List<NotificationEntity> entities = jpaRepository.findAll();
        return entities.stream()
                .map(entity -> new Notification(
                        entity.getId(),
                        entity.getMessage(),
                        entity.getRecipient(),
                        entity.getType()
                ))
                .collect(Collectors.toList());
    }
}
