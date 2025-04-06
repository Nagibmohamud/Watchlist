package fi.haagahelia.watchlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.watchlist.domain.Show;
import fi.haagahelia.watchlist.domain.ShowRepository;

@Controller

public class WatchlistController {

    @Autowired
    ShowRepository showrepository;

    @GetMapping("/watchlist")
    public String showWatchlist(Model model) {
        model.addAttribute("shows", showrepository.findAll());
        return "watchlist";
    }

    @GetMapping("/addShow")
    public String showAddForm() {
        return "addShow";
    }

    @PostMapping("/addShow")
    public String addShow(@RequestParam String title, @RequestParam String category, @RequestParam int totalEpisodes) {
        Show newShow = new Show(title, category, totalEpisodes);
        showrepository.save(newShow);
        return "redirect:/watchlist"; //redirect to the homepage
    }
}
