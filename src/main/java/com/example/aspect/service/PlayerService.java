package com.example.aspect.service;

import com.example.aspect.Entity.Player;
import com.example.aspect.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService extends AbstractService<Player, Long, PlayerRepository> {
}
