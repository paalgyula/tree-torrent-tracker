package hu.paalgyula.thetree.repositories;

import hu.paalgyula.thetree.entity.Torrent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorrentRepository extends JpaRepository<Torrent, Integer> {
}
