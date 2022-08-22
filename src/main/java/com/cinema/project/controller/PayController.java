package com.cinema.project.controller;

import com.cinema.project.entities.Pay;
import com.cinema.project.service.impl.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay")
public class PayController {
    private PayServiceImpl payService;

    @Autowired
    public PayController(PayServiceImpl payService) {
        this.payService = payService;
    }

    @GetMapping("/pays")
    public List<Pay> getAllPays(){
        return payService.getAllPays();
    }

    @PostMapping("/pay")
    public Pay savePay(@RequestBody Pay pay){
        return payService.saveOrUpdatePay(pay);
    }

    @GetMapping("/pay/{id}")
    public Pay getPay(@PathVariable long id){
        return payService.getPay(id);
    }

    @DeleteMapping("/pay/{id}")
    public void deletePay(@PathVariable long id){
        payService.deletePay(id);
    }
}
