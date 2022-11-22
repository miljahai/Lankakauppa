package harjoitustyo.lankakauppa.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import harjoitustyo.lankakauppa.domain.Yarn;
import harjoitustyo.lankakauppa.domain.YarnRepository;

@RestController
public class YarnRestController {
	
	@Autowired
	YarnRepository yarnRepository;
	
	@GetMapping("/yarns")
	public Iterable<Yarn> getYarns() {
		return yarnRepository.findAll();
	}

	@PostMapping("yarns")
	Yarn newYarn(@RequestBody Yarn newYarn) {
		return yarnRepository.save(newYarn);
	}
	
	@PutMapping("/yarns/{id}")
	Yarn editYarn(@RequestBody Yarn editedYarn, @PathVariable Long id) {
		editedYarn.setYarnid(id);
		return yarnRepository.save(editedYarn);
	}
	
	@DeleteMapping("/yarns/{id}")
	void deleteYarn(@PathVariable Long id) {
		yarnRepository.deleteById(id);
	}
	
	@GetMapping("/yarns/{id}")
	Optional<Yarn> getYarn(@PathVariable Long id) {
		return yarnRepository.findById(id);
	}
}
