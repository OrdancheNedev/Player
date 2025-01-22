package mk.ukim.finki.wp.player.web;

import mk.ukim.finki.wp.player.model.Player;
import mk.ukim.finki.wp.player.model.PlayerPosition;
import mk.ukim.finki.wp.player.service.PlayerService;
import mk.ukim.finki.wp.player.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayersController {

    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayersController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }



    @GetMapping({"/","/players"})
    public String showPlayers(@RequestParam(required = false) Double pointsPerGame,
                              @RequestParam(required = false) PlayerPosition position, Model model) {
        List<Player> players;
        if (pointsPerGame == null && position == null) {
            players=this.playerService.listAllPlayers();
        } else {
            players=this.playerService.listPlayersWithPointsLessThanAndPosition(pointsPerGame, position);
        }
        model.addAttribute("players",players);
        model.addAttribute("positions",PlayerPosition.values());
        return "list";
    }


    @GetMapping("/players/add")
    public String showAdd(Model model) {
        model.addAttribute("positions",PlayerPosition.values());
        model.addAttribute("teams",this.teamService.listAll());
        return "form";
    }


    @GetMapping("/players/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("player",this.playerService.findById(id));
        model.addAttribute("positions",PlayerPosition.values());
        model.addAttribute("teams",this.teamService.listAll());
        return "form";
    }


    @PostMapping("/players")
    public String create(@RequestParam String name,
                         @RequestParam String bio,
                         @RequestParam Double pointsPerGame,
                         @RequestParam PlayerPosition position,
                         @RequestParam Long team) {
        this.playerService.create(name, bio, pointsPerGame, position, team);
        return "redirect:/players";
    }


    @PostMapping("/players/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String bio,
                         @RequestParam Double pointsPerGame,
                         @RequestParam PlayerPosition position,
                         @RequestParam Long team) {
        this.playerService.update(id, name, bio, pointsPerGame, position, team);
        return "redirect:/players";
    }


    @PostMapping("/players/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.playerService.delete(id);
        return "redirect:/players";
    }

    @PostMapping("/players/{id}/vote")
    public String vote(@PathVariable Long id) {
        this.playerService.vote(id);
        return "redirect:/players";
    }
}