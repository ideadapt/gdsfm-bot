package gdsfm.telegrambot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.CurrentTrack;

/**
 * Created by ggrassi on 29.12.16.
 */

@Repository
public interface AirtimeLiveEntryMongoRepository extends MongoRepository<CurrentTrack, String> {
}
