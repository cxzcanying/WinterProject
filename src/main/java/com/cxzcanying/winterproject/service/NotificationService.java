package com.cxzcanying.winterproject.service;

import java.util.Date;

/**
 * @author 21311
 */
public interface NotificationService {
    public void sendBorrowReminder(String email, String bookTitle, Date dueDate);
}
