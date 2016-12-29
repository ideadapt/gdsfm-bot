package gdsfm.telegrambot.repository;

import gdsfm.telegrambot.model.CurrentTrack;
import gdsfm.telegrambot.model.airtime.liveinfov2.LiveInfo;
import gdsfm.telegrambot.model.airtime.liveinfov2.LiveInfo_;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggrassi on 29.12.16.
 */

@Repository
public interface AirtimeLiveEntryRepository extends MongoRepository<CurrentTrack, String> {
}
