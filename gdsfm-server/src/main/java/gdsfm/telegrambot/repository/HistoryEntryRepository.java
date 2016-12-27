package gdsfm.telegrambot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;

@Repository
public interface HistoryEntryRepository extends JpaRepository<AirtimeHistoryEntry, String> {

	List<AirtimeHistoryEntry> findAllByOrderByStartsAsc(Pageable pageable);

	@Query("select e from AirtimeHistoryEntry e where e.starts < ?1 order by e.starts desc")
	List<AirtimeHistoryEntry> findByTrackAtDate(LocalDateTime date, Pageable pageable); //TODO remove list hack

}
