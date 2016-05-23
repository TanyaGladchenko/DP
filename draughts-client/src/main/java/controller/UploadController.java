package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static final Logger log = Logger.getLogger(UploadController.class);
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupUploadFile() {
		return "uploadFile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processUploadFile(@RequestParam("file") MultipartFile file) {
		// file.getInputStream();
		file.getName();
		return "index";
	}
}
