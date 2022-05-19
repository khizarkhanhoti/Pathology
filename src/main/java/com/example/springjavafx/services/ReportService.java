//package com.example.springjavafx.services;
//
//import com.example.springjavafx.entities.Patient;
//import com.example.springjavafx.entities.Report;
//import com.example.springjavafx.repositories.PatientRepository;
//import com.example.springjavafx.repositories.ReportRepository;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ResourceUtils;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ReportService {
//
//	@Autowired
//	private ReportRepository reportRepository;
//	@Autowired
//	private DataSource dataSource;
//
//	@Value("${patientReport}")
//	private Resource resource;
//
//	public void exportReport() throws IOException, JRException, SQLException {
//		Report reports = reportRepository.findById("patient").get();
//		File file = ResourceUtils.getFile(resource.getURL());
//		InputStream employeeReportStream = (InputStream) reports.getJasper_report();
//		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(employeeReportStream);
//		JRPrintPage jrPrintPage;
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reports);
//		Map<String, Object> map = new HashMap<>();
//		map.put("Created By ", "Khizar");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, employeeReportStream);
//		JasperViewer viewer = new JasperViewer(jasperPrint);
//		viewer.setVisible(true);
//
////		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\patient.pdf");
//	}
//}
