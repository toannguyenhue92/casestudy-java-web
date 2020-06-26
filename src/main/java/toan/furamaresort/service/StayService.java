package toan.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import toan.furamaresort.model.Stay;

public interface StayService {
    
    Page<Stay> getAllStays(Pageable pageable);

    Stay findById(Integer id);

}
