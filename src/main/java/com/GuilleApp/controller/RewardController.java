package com.GuilleApp.controller;

import com.GuilleApp.model.rewards.Reward;
import com.GuilleApp.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reward")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/all")
    public List<Reward> getAll(){ return rewardService.findAll();}



    @PostMapping("/new")
    public void create(@RequestBody Reward reward){
        rewardService.create(reward);
    }
}
