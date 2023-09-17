package com.trungnguyen.processorder.service;

import com.trungnguyen.processorder.entity.OrderCustomer;
import com.trungnguyen.processorder.entity.OrderLog;

public interface OrderLogService {

    void insertLog(OrderLog orderLog);
}
