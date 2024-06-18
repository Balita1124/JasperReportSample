package com.balita;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
            String reportPath = "src/main/resources/sample_report_balita.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            List<Map<String, Object>> dataSource = new ArrayList<>();
            Map<String, Object> data = new HashMap<>();
            data.put("name", "John Doe");
            data.put("age", 29);
            dataSource.add(data);

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataSource);
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\data\\sample_report_balita.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
