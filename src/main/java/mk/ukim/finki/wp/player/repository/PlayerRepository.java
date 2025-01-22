package mk.ukim.finki.wp.player.repository;

import mk.ukim.finki.wp.player.model.Player;
import mk.ukim.finki.wp.player.model.PlayerPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    List<Player> findByPosition(PlayerPosition position);

    List<Player> findByPointsPerGameLessThan(Double pointsPerGame);

    List<Player> findByPointsPerGameLessThanAndPosition(Double pointsPerGame, PlayerPosition position);
}
