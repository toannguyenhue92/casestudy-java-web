package toan.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import toan.furamaresort.model.Stay;

public interface StayRepository extends PagingAndSortingRepository<Stay, Integer> {
    
    Page<Stay> findAllByActive(Boolean active, Pageable pageable);

}
