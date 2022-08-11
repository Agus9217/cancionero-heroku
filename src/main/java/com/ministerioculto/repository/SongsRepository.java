package com.ministerioculto.repository;

import com.ministerioculto.entity.Songs;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {
   List<Songs>deleteByTitle(String title);
   List<Songs>findByTitleContaining(String title);
}
