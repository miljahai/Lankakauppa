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

import harjoitustyo.lankakauppa.domain.Pattern;
import harjoitustyo.lankakauppa.domain.PatternRepository;

@RestController
public class PatternRestController {
	
	@Autowired
	PatternRepository patternRepository;
	
	@GetMapping("/patterns")
	public Iterable<Pattern> getPatterns() {
		return patternRepository.findAll();
	}

	@PostMapping("patterns")
	Pattern newPattern(@RequestBody Pattern newPattern) {
		return patternRepository.save(newPattern);
	}
	
	@PutMapping("/patterns/{id}")
	Pattern editPattern(@RequestBody Pattern editedPattern, @PathVariable Long id) {
		editedPattern.setPatternid(id);
		return patternRepository.save(editedPattern);
	}
	
	@DeleteMapping("/patterns/{id}")
	void deletePattern(@PathVariable Long id) {
		patternRepository.deleteById(id);
	}
	
	@GetMapping("/patterns/{id}")
	Optional<Pattern> getPattern(@PathVariable Long id) {
		return patternRepository.findById(id);
	}
}
