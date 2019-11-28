package com.aop.serviceimpl;

import com.aop.aspect.LoggableService;
import com.aop.model.Aop;
import com.aop.service.AopService;
import org.springframework.stereotype.Service;

/**
 * Project aop
 * User : suren_v
 * Date : 11/28/2019
 * Time : 9:28 AM
 */
@Service
public class AopServiceImpl implements AopService {

    @Override
    @LoggableService
    public void welcomeMessage(Aop aop) {
        System.out.println("Testing if AOP Loggable Service Works");
        System.out.println(aop.getId() + " ---- " + aop.getCode());
    }
}
