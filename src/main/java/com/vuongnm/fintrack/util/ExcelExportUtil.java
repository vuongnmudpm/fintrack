package com.vuongnm.fintrack.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Component
public class ExcelExportUtil {
    public String exportToExcel(Integer userId, Map<String, Object> filter) {
        String fileName = "export_" + userId + "_" + System.currentTimeMillis() + ".xlsx";
        File file = new File("exports/excel/" + fileName);
        return file.getAbsolutePath();
    }
}
