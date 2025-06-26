package org.example.core.repositories;

import org.example.domain.entities.Notification;

import java.util.List;

public interface NotificationRepository {
    Notification save(Notification notification);
    List<Notification> findAll();
}