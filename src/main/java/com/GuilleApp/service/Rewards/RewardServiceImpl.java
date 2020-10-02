package com.GuilleApp.service.Rewards;

import com.GuilleApp.model.rewards.Reward;
import com.GuilleApp.repository.RewardRepository;
import com.GuilleApp.security.SecurityUtils;
import com.GuilleApp.service.exceptions.NotEnoughPoints;
import com.GuilleApp.service.exceptions.rewardAlreadyExchanged;
import com.GuilleApp.service.users.UserService;
import com.GuilleApp.service.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<Reward> findAll() {
        return rewardRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reward findById(String id) {
        Optional<Reward> rewardOptional = rewardRepository.findById(UUIDUtils.parseUUID(id));
        return rewardOptional.get();
    }

    @Override
    @Transactional
    public void create(Reward reward) {
        rewardRepository.save(reward);
    }

    @Override
    @Transactional
    public void exchangeReward(String id) {
        Reward rewardToExchange = findById(id);
        System.out.println(!rewardToExchange.getExchanged());
        if(!rewardToExchange.getExchanged()){
            userService.substractPoints(rewardToExchange.getValue());
            rewardToExchange.setExchanged(true);
            rewardRepository.save(rewardToExchange);
        } else {
            throw new rewardAlreadyExchanged();
        }

    }
}
