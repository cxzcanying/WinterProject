// package com.cxzcanying.winterproject.service.impl;

// import com.cxzcanying.winterproject.service.NotificationService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

// import java.util.Date;

// @Service
// public class NotificationServiceImpl implements NotificationService {

//     @Autowired
//     private JavaMailSender mailSender;

//     @Override
//     public void sendBorrowReminder(String email, String bookTitle, Date dueDate) {
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setTo(email);
//         message.setSubject("Borrow Reminder");
//         message.setText("Dear user, your borrowed book '" + bookTitle + 
//                       "' is due on " + dueDate);
//         mailSender.send(message);
//     }
// } 