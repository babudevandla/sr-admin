package com.statusraja.admin.categories;

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

import com.statusraja.admin.enums.CategoryStatusEnum;
import com.statusraja.admin.ringtone.RingtoneService;
import com.statusraja.admin.service.GenericService;
import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@Autowired
	GenericService genericService;
	
	
	@GetMapping("/categorieslist")
	public ModelAndView getCategories() {
		logger.info("categories list!..");
		ModelAndView model = new ModelAndView("/admin/category/category_list");
		List<Categories> categories=genericService.getCategories(null);
		model.addObject("categories", categories);
		return model;
	}
	
	@GetMapping("/add/category")
	public ModelAndView addCategory() {
		logger.info("add to category !..");
		ModelAndView model = new ModelAndView("/admin/category/add_category");
		List<Languages> languages=genericService.getLanguageList();
		model.addObject("languages", languages);
		return model;
	}
	
	@PostMapping("/add/category")
	public ModelAndView submitCategory(@ModelAttribute FileDetailsVo fIleDetailsVo,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.info("add to ringtone !..");
		ModelAndView mvc = new ModelAndView("/admin/category/category_list");
		Integer catId=ringtoneService.getMaxCategoryId();
		if(catId!=null) {
			fIleDetailsVo.setCategoryid(catId);
		}else {
			fIleDetailsVo.setCategoryid(1);
		}
		genericService.saveCategory(fIleDetailsVo);
        mvc.setViewName("redirect:/admin/categorieslist");
		return mvc;
	}
}
