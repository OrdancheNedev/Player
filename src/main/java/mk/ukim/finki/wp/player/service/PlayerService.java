package mk.ukim.finki.wp.player.service;

import mk.ukim.finki.wp.player.model.Player;
import mk.ukim.finki.wp.player.model.PlayerPosition;

import java.util.List;

public interface PlayerService {

    List<Player> listAllPlayers();

    Player findById(Long id);

    Player create(String name, String bio, Double pointsPerGame, PlayerPosition position, Long team);

    Player update(Long id, String name, String bio, Double pointsPerGame, PlayerPosition position, Long team);

    Player delete(Long id);

    Player vote(Long id);

    List<Player> listPlayersWithPointsLessThanAndPosition(Double pointsPerGame, PlayerPosition position);
}