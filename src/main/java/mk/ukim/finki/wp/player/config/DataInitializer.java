package mk.ukim.finki.wp.player.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.player.model.PlayerPosition;
import mk.ukim.finki.wp.player.service.PlayerService;
import mk.ukim.finki.wp.player.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final TeamService teamService;

    private final PlayerService playerService;

    public DataInitializer(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    private PlayerPosition randomizePosition(int i) {
        if(i % 3 == 0) return PlayerPosition.G;
        else if(i % 3 == 1) return PlayerPosition.F;
        return PlayerPosition.C;
    }
// After the database is initialized, you have to comment this so the data doesn't double or add with the changed data
//    @PostConstruct
//    public void initData() {
//        for (int i = 1; i < 6; i++) {
//            this.teamService.create("Team: " + i);
//        }
//
//        for (int i = 1; i < 11; i++) {
//            this.playerService.create("Player: " + i, "Bio: " + i , 20.9 * i, this.randomizePosition(i), this.teamService.listAll().get((i-1)%5).getId());
//        }
//    }
}