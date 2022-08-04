package com.springCourse.springBootcamp.Buyer.Service;

import com.springCourse.springBootcamp.Buyer.Converter.BuyerConverter;
import com.springCourse.springBootcamp.Buyer.Dao.BuyerDao;
import com.springCourse.springBootcamp.Buyer.Dto.BuyerDto;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerDao buyerDao;

    private final BuyerConverter buyerConverter;

    public List<Buyer> findAll() {
        return buyerDao.findAll();
    }

    public Buyer findAllById(Long Id) {
        return buyerDao.findAllById(Id);
    }

    public List<Buyer> findByAccessStatus(Boolean accessStatus) {
        return buyerDao.findByIsBanned(accessStatus);
    }

    public List<Buyer> findByBannedStatus(Boolean isBanned) {
        return buyerDao.findByIsBanned(isBanned);
    }

    public Buyer createNewBuyer(Buyer buyer) {
        return buyerDao.save(buyer);
    }

    public Buyer createNewFromDto(BuyerDto buyerDto) {
        Buyer buyer = buyerConverter.convertFromDto(buyerDto);
        buyerDao.save(buyer);
        return buyer;
    }

    public void deleteById(Long Id) {
        buyerDao.deleteAllById(Id);
    }

    public void deleteGivenBuyer(Buyer buyer){buyerDao.delete(buyer);}

    public Buyer findAllByUsernameAndPassword(String username, String password) {
        return buyerDao.findAllByUsernameAndPassword(username, password);
    }

    private void save(Buyer buyer) {
        buyerDao.save(buyer);
    }
}
