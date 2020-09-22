package com.GuilleApp.service.Rewards;

import com.GuilleApp.model.rewards.Reward;
import com.GuilleApp.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    private RewardRepository rewardRepository;

    public List<Reward> findAll(){
        return rewardRepository.findAll();
    }

    public Reward findById(String id) {
        Optional<Reward> rewardOptional = rewardRepository.findById(parseUUID(id));
        return rewardOptional.get();
    }

    public void create(Reward reward) {
        rewardRepository.save(reward);
    }
    private UUID parseUUID(String id){
        return UUID.fromString(id);
    }
}
