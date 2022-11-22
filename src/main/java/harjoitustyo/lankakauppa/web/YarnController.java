package harjoitustyo.lankakauppa.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harjoitustyo.lankakauppa.domain.PatternRepository;
import harjoitustyo.lankakauppa.domain.Yarn;
import harjoitustyo.lankakauppa.domain.YarnRepository;

@Controller
public class YarnController {
	
	@Autowired
	PatternRepository patternRepository;
	@Autowired
	YarnRepository yarnRepository;
	
	@RequestMapping(value= {"/yarnlist"})
	public String yarnList(Model model) {
		model.addAttribute("yarns", yarnRepository.findAll());
		return "yarnlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "addyarn")
	public String addPattern(Model model) {
		model.addAttribute("yarn", new Yarn());		
		return "addyarn";
	}

	@RequestMapping(value= "/saveyarn", method = RequestMethod.POST)
	public String save(@Valid Yarn yarn, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("ERROR");
			return "addyarn";
		}
		yarnRepository.save(yarn);
		return "redirect:yarnlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("edityarn/{id}")
	public String editYarn(@PathVariable("id") Long id, Model model) {
	model.addAttribute("edityarn", yarnRepository.findById(id));
	return "edityarn";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteyarn/{id}", method = RequestMethod.GET)
	public String deleteYarn(@PathVariable("id") Long yarnid, Model model) {
		yarnRepository.deleteById(yarnid);
		return "redirect:../yarnlist";
	}

}
