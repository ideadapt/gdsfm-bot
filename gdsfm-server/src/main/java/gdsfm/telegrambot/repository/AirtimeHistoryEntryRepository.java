package gdsfm.telegrambot.repository;

import java.time.LocalDateTime;
import java.util.List;

import gdsfm.telegrambot.model.HistoryTrack;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;

@Repository
public interface HistoryEntryRepository extends MongoRepository<HistoryTrack, String> {


	List<HistoryTrack> findAllByOrderByStartsDesc(Pageable pageable);

	List<HistoryTrack> findByEndsAfter(LocalDateTime date, Pageable pageable); //TODO remove list hack

}
