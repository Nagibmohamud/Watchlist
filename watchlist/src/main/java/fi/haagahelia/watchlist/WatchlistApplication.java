package fi.haagahelia.watchlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.watchlist.domain.Show;
import fi.haagahelia.watchlist.domain.ShowRepository;

@SpringBootApplication
public class WatchlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchlistApplication.class, args);
    }

    @Bean
    public CommandLineRunner testdata(ShowRepository showRepository) {
        return (args) -> {
            // Test data Shows
            Show show1 = new Show("Naruto", "Anime", 220);
            show1.setEpisodesWatched(100);
            show1.setStatus("Watching");

            Show show2 = new Show("Breaking Bad", "TV Show", 62);
            show2.setEpisodesWatched(62);
            show2.setStatus("Completed");

            Show show3 = new Show("The Avengers", "Movie", 1);
            show3.setStatus("Completed");

            // Saves the test data into the repository
            showRepository.save(show1);
            showRepository.save(show2);
            showRepository.save(show3);
        };
    }
}
