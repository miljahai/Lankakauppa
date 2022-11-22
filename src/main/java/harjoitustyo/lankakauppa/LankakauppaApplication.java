package harjoitustyo.lankakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import harjoitustyo.lankakauppa.domain.ApplicationUser;
import harjoitustyo.lankakauppa.domain.ApplicationUserRepository;
import harjoitustyo.lankakauppa.domain.Pattern;
import harjoitustyo.lankakauppa.domain.PatternRepository;
import harjoitustyo.lankakauppa.domain.Yarn;
import harjoitustyo.lankakauppa.domain.YarnRepository;

@SpringBootApplication
public class LankakauppaApplication implements CommandLineRunner {
	
	public static final Logger log = LoggerFactory.getLogger(LankakauppaApplication.class);
	
	@Autowired
	PatternRepository prepository;
	@Autowired
	YarnRepository yrepository;
	@Autowired
	ApplicationUserRepository appUserRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(LankakauppaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		appUserRepository.save(new ApplicationUser("Milja", "Haiko", "USER", "user", "$2a$10$GL7Mjm745jTV5KXEzC3nI.7OC3wBluMPmvHqYnZDJ1hIR/lGSStHu"));
//		appUserRepository.save(new ApplicationUser("Milja", "Haiko", "ADMIN", "admin", "$2a$10$yKd/VEAj6KdYyAhR14Xx1.W/xS1sixv0SnUD.4m/pGRNdp/a0Y1O6"));
//		
//		yrepository.save(new Yarn("Novita", "7-veljestä", "75%villa 25%polyamidi", 2.7));
//		yrepository.save(new Yarn("DROPS", "Karisma", "100%villa", 2.7));
//		
//		prepository.save(new Pattern("Lapaset", "Neulo joustinneuleella resorit, sitten sileää, kavenna, päättele ja tee peukalot", yrepository.findByName("7-veljestä").get(0)));
		
		
		for (Yarn yarn : yrepository.findAll()) {
			log.info(yarn.toString());
		}
	}
}
