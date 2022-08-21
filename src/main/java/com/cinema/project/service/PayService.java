package com.cinema.project.service;

import com.cinema.project.entities.Pay;
import com.cinema.project.repository.PayRepository;
import com.cinema.project.service.impl.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PayService implements PayServiceImpl {

    private PayRepository payRepository;

    @Autowired
    public PayService(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    @Override
    public List<Pay> getAllPays() {
        return payRepository.findAll();
    }

    @Override
    public Pay saveOrUpdatePay(Pay pay) {
        return payRepository.save(pay);
    }

    @Override
    public Pay getPay(long id) {
        return payRepository.getById(id);
    }

    @Override
    public void deletePay(long id) {
        payRepository.deleteById(id);
    }
}
