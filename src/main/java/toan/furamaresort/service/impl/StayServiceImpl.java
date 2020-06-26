package toan.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import toan.furamaresort.model.Stay;
import toan.furamaresort.repository.StayRepository;
import toan.furamaresort.service.StayService;

@Service
public class StayServiceImpl implements StayService {

    protected static final String[] rentalTypes = {"Day", "Month", "Year", "Hour"};
    protected static final String[] stayServiceTypes = {"Room", "House", "Villa"};

    @Autowired
    private StayRepository stayRepository;


    @Override
    public Page<Stay> getAllStays(Pageable pageable) {
        return stayRepository.findAllByActive(true, pageable);
    }

    @Override
    public Stay findById(Integer id) {
        return stayRepository.findById(id).orElse(null);
    }

}
