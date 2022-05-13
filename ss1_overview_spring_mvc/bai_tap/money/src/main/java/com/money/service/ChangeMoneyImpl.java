package com.money.service;

import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyImpl implements IChangeMoney{

    @Override
    public int changeMoney(Integer usd) {
        int vnd = usd * 22000;
        return vnd;
    }
}
