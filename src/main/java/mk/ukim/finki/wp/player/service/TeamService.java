package mk.ukim.finki.wp.player.service;

import mk.ukim.finki.wp.player.model.Team;

import java.util.List;

public interface TeamService {

    Team findById(Long id);

    List<Team> listAll();

    Team create(String name);
}
