package com.statusraja.admin.imagestatus;

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
import com.statusraja.admin.wallpapers.WallPapersController;

@Controller
@RequestMapping("/admin")
public class ImageStatusController {

	private static final Logger logger = LoggerFactory.getLogger(WallPapersController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@Autowired
	GenericService genericService;
	
	@GetMapping("/imagestatus_list")
	public ModelAndView getImageStatus() {
		logger.info("image status list!..");
		ModelAndView model = new ModelAndView("/admin/imagestatus/imagestatuslist");
		List<FileDetailsVo> fileDetailsVos=ringtoneService.getMasterDetailsList(CategoryStatusEnum.IMAGESTATUS.getStatus());
		model.addObject("fileDetailsVos", fileDetailsVos);
		
		return model;
	}
	
	@GetMapping("/add_imagestatus")
	public ModelAndView addImagestatus() {
		logger.info("*********** add to image status ************** ");
		ModelAndView model = new ModelAndView("/admin/imagestatus/add_imagestatus");
		List<Languages> languages=genericService.getLanguageList();
		List<Categories> categories=genericService.getCategories(CategoryStatusEnum.IMAGESTATUS.getStatus());
		model.addObject("languages", languages);
		model.addObject("categories", categories);
		return model;
	}
	
	@PostMapping("/add_imagestatus")
	public ModelAndView submitImagestatus(@ModelAttribute FileDetailsVo fIleDetailsVo,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.info("*************** submitImagestatus ********************");
		ModelAndView mvc = new ModelAndView("/admin/imagestatus/imagestatuslist");
		Integer srid=ringtoneService.getMaxSrid();
		if(srid!=null) {
			fIleDetailsVo.setSrid(srid);
		}else {
			fIleDetailsVo.setSrid(1);
		}
		//########## above code is to upload files in filebank root folder ###############
		String fileUrl=null;
        if (!fIleDetailsVo.getFile().isEmpty()) {
        	fileUrl=ringtoneService.uploadFiles(fIleDetailsVo, request );
        	if(fileUrl!=null)
        		mvc.addObject("message","file uploaded successfully!");
        }
        mvc.setViewName("redirect:/admin/imagestatus_list");
		return mvc;
	}
}
