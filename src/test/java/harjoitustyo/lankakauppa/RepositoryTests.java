package harjoitustyo.lankakauppa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import harjoitustyo.lankakauppa.domain.ApplicationUserRepository;
import harjoitustyo.lankakauppa.domain.Pattern;
import harjoitustyo.lankakauppa.domain.PatternRepository;
import harjoitustyo.lankakauppa.domain.Yarn;
import harjoitustyo.lankakauppa.domain.YarnRepository;

@DataJpaTest
class RepositoryTests {

	@Autowired
	PatternRepository patternRepository;
	
	@Autowired
	YarnRepository yarnRepository;
	
	@Autowired
	ApplicationUserRepository appUserRepository;
	
		
	@Test
	public void findPattern() {
		Pattern pattern = patternRepository.findById((long) 1).get();
		System.out.println("Haetaan id 1" + pattern);
		assertEquals(pattern.getName(), "Lapaset");
	}
	
	@Test
	public void findYarn() {
		Yarn yarn = yarnRepository.findById((long) 2).get();
		System.out.println("Haetaan id 2" + yarn);
		assertEquals(yarn.getName(), "Karisma");
	}

}
