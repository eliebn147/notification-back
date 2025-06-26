package org.example.core.services;


import org.example.core.repositories.NotificationRepository;
import org.example.core.messaging.NotificationPublisher;
import org.example.domain.entities.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationPublisher notificationPublisher;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationPublisher notificationPublisher) {
        this.notificationRepository = notificationRepository;
        this.notificationPublisher = notificationPublisher;
    }


    @Override
    public Notification createNotification(Notification notification) {
        // business logic example:
        if (notification.getType() == null || notification.getType().isEmpty()) {
            throw new IllegalArgumentException("Notification type must be provided");
        }

        if(notification.getType().equalsIgnoreCase("email")) {
            notificationPublisher.publish(notification);
        }
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}