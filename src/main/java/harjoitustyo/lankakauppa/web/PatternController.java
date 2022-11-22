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

import harjoitustyo.lankakauppa.domain.Pattern;
import harjoitustyo.lankakauppa.domain.PatternRepository;
import harjoitustyo.lankakauppa.domain.YarnRepository;

@Controller
public class PatternController {
	
	@Autowired
	PatternRepository patternRepository;
	@Autowired
	YarnRepository yarnRepository;
	
	@RequestMapping(value= {"/", "/patternlist"})
	public String patternList(Model model) {
		model.addAttribute("patterns", patternRepository.findAll());
		return "patternlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "addpattern")
	public String addPattern(Model model) {
		model.addAttribute("pattern", new Pattern());
		model.addAttribute("yarns", yarnRepository.findAll());
		return "addpattern";
	}

	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@Valid Pattern pattern, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("ERROR");
			return "addpattern";
		}
		patternRepository.save(pattern);
		return "redirect:patternlist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("edit/{id}")
	public String editPattern(@PathVariable("id") Long id, Model model) {
	model.addAttribute("edit", patternRepository.findById(id));
	model.addAttribute("yarns", yarnRepository.findAll());
	return "editpattern";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePattern(@PathVariable("id") Long patternid, Model model) {
		patternRepository.deleteById(patternid);
		return "redirect:../patternlist";
	}
}
