package gdsfm.telegrambot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;

@Repository
public interface AirtimeHistoryEntryMongoRepository extends MongoRepository<HistoryTrack, String> {

	@Query("select e from AirtimeHistoryEntry e where e.starts < ?1 order by e.starts desc")
	List<AirtimeHistoryEntry> findByTrackAtDate(LocalDateTime date, Pageable pageable); //TODO remove list hack


	List<HistoryTrack> findAllByOrderByStartsDesc(Pageable pageable);

	List<HistoryTrack> findByEndsAfter(LocalDateTime date, Pageable pageable); //TODO remove list hack

}
