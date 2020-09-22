package com.GuilleApp.service.Rewards;

import com.GuilleApp.model.rewards.Reward;

import java.util.List;

public interface RewardService {
    List<Reward> findAll();
    Reward findById(String id);
    void create(Reward reward);
}
