package com.cinema.project.service.impl;

import com.cinema.project.entities.Pay;
import java.util.List;

public interface PayServiceImpl {
    List<Pay> getAllPays();

    Pay saveOrUpdatePay(Pay pay);

    Pay getPay(long id);

    void deletePay(long id);
}
