package com.vuongnm.fintrack.service;

import com.vuongnm.fintrack.entity.ExportLog;
import com.vuongnm.fintrack.repository.ExportLogRepository;
import com.vuongnm.fintrack.util.ExcelExportUtil;
import com.vuongnm.fintrack.util.PdfExportUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class ExportLogService {
    private final ExportLogRepository exportLogRepository;
    private final PdfExportUtil pdfExportUtil;
    private final ExcelExportUtil excelExportUtil;

    public String export(String type, Integer userId, Map<String, Object> filter, HttpServletRequest request) {
        String filePath = null;
        String status = "SUCCESS";

        try {
            if("PDF".equalsIgnoreCase(type)) {
                filePath = pdfExportUtil.exportToPdf(userId, filter);
            } else if("EXCEL".equalsIgnoreCase(type)) {
                filePath = excelExportUtil.exportToExcel(userId, filter);
            } else {
                throw new IllegalArgumentException("Unsupported export type: " + type);
            }
            log.info("Export success: " + filePath);
        } catch (Exception e) {
            log.error("Export fail ", e);
            status = "FAILED";
        }

        saveExportLog(userId, type, status, filePath, filter, request);
        return filePath;
    }

    private void saveExportLog(Integer userId, String type, String status, String filePath,
                               Map<String, Object> filter, HttpServletRequest request) {
        ExportLog logEntry = new ExportLog();
        logEntry.setExportId(userId);
        logEntry.setExportType(type.toUpperCase());
        logEntry.setStatus(status);
        logEntry.setExportTime(LocalDateTime.now());
        logEntry.setFilePath(filePath);
        logEntry.setFilterInfo(filter.toString()); // bạn có thể dùng Jackson để chuyển JSON
        logEntry.setRequestedByIp(request.getRemoteAddr());
        logEntry.setFileSizeKb(100); // TODO: tính size file thực
        logEntry.setDeleted(false);

        exportLogRepository.save(logEntry);
    }
}
