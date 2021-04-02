package com.devrezaur.main.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	public String uploadDir = "C:\\Users\\msrez\\Documents\\VS Code Workspace\\DevAcademy\\dev-academy-react-frontend\\src\\Local Bucket";

    public String uploadFile(MultipartFile file) throws Exception {

    	Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
           
    	Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
    	
    	return copyLocation.toString();
    }

}
