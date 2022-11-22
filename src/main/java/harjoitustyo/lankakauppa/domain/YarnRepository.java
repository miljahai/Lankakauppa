package harjoitustyo.lankakauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface YarnRepository extends CrudRepository<Yarn, Long> {
		
	List<Yarn> findByName(String name);
}
