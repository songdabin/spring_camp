package com.example.demo.controller.page;

import com.amazonaws.util.IOUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;

@RequestMapping("")
@Controller
public class DefaultController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @GetMapping(value = "/image/{file_name:.+}")
    public byte[] getImage(@PathVariable("file_name") String file_name) {
        String root_path = "uploadfiles/";
        byte[] return_byte = null;

        File file = new File(root_path + file_name);
        InputStream in = null;

        try {
            in = new FileInputStream(file);
            return_byte = IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return return_byte;
    }

    @ResponseBody
    @RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)
    public void download(@PathVariable("file_name") String file_name, HttpServletResponse response) throws IOException {
        String root_path = "uploadfiles/";
        File file = new File(root_path + file_name);

        String mimeType = URLConnection.guessContentTypeFromName(file_name);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode(file.getName(), "utf-8") +"\"");

        InputStream in = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
}
