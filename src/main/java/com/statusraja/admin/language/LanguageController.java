package com.statusraja.admin.language;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.statusraja.admin.ringtone.RingtoneService;
import com.statusraja.admin.service.GenericService;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

@Controller
@RequestMapping("/admin")
public class LanguageController {

	private static final Logger logger = LoggerFactory.getLogger(LanguageController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@Autowired
	GenericService genericService;
	
	
	@GetMapping("/languagelist")
	public ModelAndView getLanguageList() {
		logger.info("languagelist!..");
		ModelAndView model = new ModelAndView("/admin/languagelist");
		List<Languages> languages=genericService.getLanguageList();
		model.addObject("languages", languages);
		return model;
	}
	
	@GetMapping("/add/language")
	public ModelAndView addLanguage() {
		logger.info("add to language !..");
		ModelAndView model = new ModelAndView("/admin/add_language");
		return model;
	}
	
	@PostMapping("/add/language")
	public ModelAndView submitLanguage(@ModelAttribute FileDetailsVo fIleDetailsVo,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.info("add to language !..");
		ModelAndView mvc = new ModelAndView("/admin/languagelist");
		Integer langId=ringtoneService.getMaxLangId();
		if(langId!=null) {
			fIleDetailsVo.setLangid(langId);
		}else {
			fIleDetailsVo.setLangid(1);
		}
		genericService.saveLanguage(fIleDetailsVo);
        mvc.setViewName("redirect:/admin/languagelist");
		return mvc;
	}
}
