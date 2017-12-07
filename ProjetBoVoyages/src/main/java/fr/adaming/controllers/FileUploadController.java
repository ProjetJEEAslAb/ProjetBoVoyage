package fr.adaming.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@Autowired
	ServletContext context;

	@RequestMapping(value="/fileUploadPage", method=RequestMethod.GET)
	public ModelAndView fileUploadPage() {
		FileModel file = new FileModel();
		ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
		return modelAndView;
	}

	@RequestMapping(value="/uploadImage", method=RequestMethod.POST)
	public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
		if (result.hasErrors()) {
			System.out.println("Erreur lors de l'upload de l'image");
			return "fileUploadPage";
		} else {
			Integer idVoyage = 2;
			String uploadPath = context.getRealPath("") + File.separator + "images" + File.separator + "voyage_" + idVoyage.toString() + File.separator;
			File imagesDir = new File(uploadPath);
			if (!imagesDir.exists()) {
				imagesDir.mkdirs();
			}
			String filePath;
			Integer i = 0;
			while(true) {
				String tmpFilePath = uploadPath + i.toString() + ".jpg";
				File imageFile = new File(tmpFilePath);
				if (!imageFile.exists()) {
					filePath = tmpFilePath;
					break;
				}
				i++;
			}
			FileCopyUtils.copy(file.getFile().getBytes(), new File(filePath));
			return "accueil";
		}
	}
}
