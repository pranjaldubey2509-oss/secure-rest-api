package secureapi.service;

import secureapi.entity.Details;

import java.util.List;

public interface DetailsService {

    Details create(Details details);

    List<Details> getAll();

    Details update(Long id, Details details);

    void delete(Long id);
}