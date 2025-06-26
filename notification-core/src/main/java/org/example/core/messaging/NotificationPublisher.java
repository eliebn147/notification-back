package org.example.core.messaging;

import org.example.domain.entities.Notification;

public interface NotificationPublisher {
    void publish(Notification notification);
}
