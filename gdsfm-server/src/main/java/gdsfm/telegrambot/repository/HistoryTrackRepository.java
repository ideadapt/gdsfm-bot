package gdsfm.telegrambot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.HistoryTrack;

@Repository
public interface HistoryTrackRepository extends JpaRepository<HistoryTrack, String> {

	@Query("select e from HistoryTrack e where e.starts < ?1 order by e.starts desc")
	List<HistoryTrack> findByTrackAtDate(LocalDateTime date, Pageable pageable);
	List<HistoryTrack> findByEndsAfter(LocalDateTime date, Pageable pageable); //TODO remove list hack
}
