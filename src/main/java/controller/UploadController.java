package controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
//文件上传
@Controller
public class UploadController {
//    @Value("${web.upload-path}")
//    private String path;
    @RequestMapping("/upload")
    public void upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) throws Exception {

        String contentType = picture.getContentType();
        String fileName = picture.getOriginalFilename();
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "";
//        System.out.println(path);
//        String filePath = request.getSession().getServletContext().getRealPath(realPath);

        File dir = new File(realPath);
        picture.transferTo(new File(dir,fileName));

        System.out.println(picture.getOriginalFilename());
    }

    @RequestMapping("/test2")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

}
