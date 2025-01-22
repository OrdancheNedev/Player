package mk.ukim.finki.wp.player.repository;

import mk.ukim.finki.wp.player.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
