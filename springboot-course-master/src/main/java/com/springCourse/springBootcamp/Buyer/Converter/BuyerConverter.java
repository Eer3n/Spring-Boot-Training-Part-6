package com.springCourse.springBootcamp.Buyer.Converter;

import com.springCourse.springBootcamp.Buyer.Dto.BuyerDto;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import org.springframework.stereotype.Component;

@Component
public class BuyerConverter {

    public Buyer convertFromDto(BuyerDto buyerDto) {
        Buyer buyer = new Buyer();
        
        buyer.setName(buyer.getName());
        buyer.setSurname(buyer.getSurname());
        buyer.setUsername(buyer.getUsername());
        buyer.setMailAddress(buyer.getMailAddress());
        buyer.setPassword(buyer.getPassword());
        buyer.setAge(buyer.getAge());
        buyer.setImageUrl(buyer.getImageUrl());
        buyer.setIsBanned(buyer.getIsBanned());
        buyer.setGender(buyer.getGender());
        buyer.setBackupMailAddress(buyer.getBackupMailAddress());

        return buyer;
    }
}
