package mk.ukim.finki.wp.player.service.impl;

import mk.ukim.finki.wp.player.model.Team;
import mk.ukim.finki.wp.player.model.exceptions.InvalidTeamIdException;
import mk.ukim.finki.wp.player.repository.TeamRepository;
import mk.ukim.finki.wp.player.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findById(Long id) {
        return this.teamRepository.findById(id).orElseThrow(InvalidTeamIdException::new);
    }

    @Override
    public List<Team> listAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public Team create(String name){
        return this.teamRepository.save(new Team(name));
    }
}
