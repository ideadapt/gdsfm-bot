package gdsfm.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.airtime.liveinfov2.show.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {

}
