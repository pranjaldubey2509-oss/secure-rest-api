package secureapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import secureapi.entity.Details;

public interface DetailsRepository
        extends JpaRepository<Details, Long> {
}