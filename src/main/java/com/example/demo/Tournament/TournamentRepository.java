package com.example.demo.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Optional<Tournament> findByLocation(String location);
    List<Tournament> findByStartDate(LocalDate startDate);
}
