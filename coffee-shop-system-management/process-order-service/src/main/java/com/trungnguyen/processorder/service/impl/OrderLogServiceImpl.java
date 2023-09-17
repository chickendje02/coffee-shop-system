package com.trungnguyen.processorder.service.impl;

import com.trungnguyen.processorder.entity.OrderCustomer;
import com.trungnguyen.processorder.entity.OrderLog;
import com.trungnguyen.processorder.repository.OrderLogRepository;
import com.trungnguyen.processorder.service.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class OrderLogServiceImpl implements OrderLogService {

    @Autowired
    OrderLogRepository orderLogRepository;

    @Override
    @Transactional
    public void insertLog(OrderLog orderLog) {
        orderLogRepository.save(orderLog);
    }
}
