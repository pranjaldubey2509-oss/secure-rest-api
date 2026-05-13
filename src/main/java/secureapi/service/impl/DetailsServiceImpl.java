package secureapi.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import secureapi.entity.Details;
import secureapi.repository.DetailsRepository;
import secureapi.service.DetailsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsServiceImpl
        implements DetailsService {

    private final DetailsRepository repository;

    @Override
    public Details create(Details details) {

        return repository.save(details);
    }

    @Override
    public List<Details> getAll() {

        return repository.findAll();
    }

    @Override
    public Details update(
            Long id,
            Details updated
    ) {

        Details details =
                repository.findById(id)
                        .orElseThrow();

        details.setName(updated.getName());
        details.setEmail(updated.getEmail());
        details.setCountryCode(updated.getCountryCode());
        details.setPhone(updated.getPhone());
        details.setAddress(updated.getAddress());

        return repository.save(details);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }
}