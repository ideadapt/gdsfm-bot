package gdsfm.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.airtime.liveinfov2.track.LiveInfoTrack;

@Repository
public interface LiveInfoTrackRepository extends JpaRepository<LiveInfoTrack, String> {

}
