package com.ecommerce.notificationservice.service;

import com.ecommerce.notificationservice.dto.NotificationRequest;
import com.ecommerce.notificationservice.entity.Notification;
import com.ecommerce.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(
            NotificationRepository notificationRepository) {

        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(
            NotificationRequest request) {

        Notification notification = new Notification();

        notification.setUserId(request.getUserId());
        notification.setOrderId(request.getOrderId());
        notification.setType(request.getType());
        notification.setMessage(request.getMessage());

        // For now we simulate sending the notification
        notification.setStatus("SENT");

        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {

        return notificationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification not found"));
    }

    public List<Notification> getNotificationsByUserId(
            Long userId) {

        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getNotificationsByOrderId(
            Long orderId) {

        return notificationRepository.findByOrderId(orderId);
    }

    public Notification updateNotificationStatus(
            Long id,
            String status) {

        Notification notification =
                getNotificationById(id);

        notification.setStatus(status);

        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {

        Notification notification =
                getNotificationById(id);

        notificationRepository.delete(notification);
    }
}
