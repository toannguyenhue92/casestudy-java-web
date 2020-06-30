package toan.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import toan.furamaresort.model.Stay;

public interface StayRepository extends JpaRepository<Stay, Integer> {

    Page<Stay> findAllByActive(Boolean active, Pageable pageable);

}
