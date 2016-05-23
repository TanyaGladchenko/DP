package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	private static final Logger log = Logger.getLogger(UploadController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView setupUploadFile() {
		log.debug("Get");
		return new ModelAndView("uploadFile", "file", new Object());
	}

	@RequestMapping(value = "/processUploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String processUploadFile(@RequestParam("file") MultipartFile file) {
		// file.getInputStream();
		// file.getName();
		log.debug("You successfully uploaded file");
		return "You successfully uploaded file";
	}
}
