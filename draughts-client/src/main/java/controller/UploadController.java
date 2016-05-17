import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(method=RequestMethod.GET)
	public String setupUploadFile(){
		return "uploadFile";
	}
	
	public String processUploadFile(@RequestParam("file") MultipartFile file){
		//file.getInputStream();
		file.getName();
		return "index";
	} 
}
