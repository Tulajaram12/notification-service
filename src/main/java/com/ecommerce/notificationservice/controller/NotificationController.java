package com.ecommerce.notificationservice.controller;

import com.ecommerce.notificationservice.dto.NotificationRequest;
import com.ecommerce.notificationservice.entity.Notification;
import com.ecommerce.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(
            @RequestBody NotificationRequest request) {

        return notificationService.createNotification(request);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {

        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(
            @PathVariable Long id) {

        return notificationService.getNotificationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUserId(
            @PathVariable Long userId) {

        return notificationService
                .getNotificationsByUserId(userId);
    }

    @GetMapping("/order/{orderId}")
    public List<Notification> getNotificationsByOrderId(
            @PathVariable Long orderId) {

        return notificationService
                .getNotificationsByOrderId(orderId);
    }

    @PatchMapping("/{id}/status")
    public Notification updateNotificationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return notificationService
                .updateNotificationStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(
            @PathVariable Long id) {

        notificationService.deleteNotification(id);

        return "Notification deleted successfully";
    }
}
