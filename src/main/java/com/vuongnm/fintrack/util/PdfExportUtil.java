package com.vuongnm.fintrack.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Component
public class PdfExportUtil {
    public String exportToPdf(Integer userId, Map<String, Object> filter) {
        String fileName = "export_"+userId+"_"+System.currentTimeMillis()+".pdf";
        File file = new File("export/pdf/" + fileName);
        return file.getAbsolutePath();
    }
}
