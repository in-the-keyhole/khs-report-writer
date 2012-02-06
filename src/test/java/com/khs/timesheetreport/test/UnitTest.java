package com.khs.timesheetreport.test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.junit.Test;

import com.khs.report.ConsoleWriter;
import com.khs.report.ReportFactory;
import com.khs.report.ReportProcessor;
import com.khs.report.ReportWriter;
import com.khs.report.writer.ReportPDFWriter;

public class UnitTest {

	@Test
	public void reportTestPDF() throws Exception {
		ReportPDFWriter writer = new ReportPDFWriter();
		writer.setOut(new FileOutputStream(new File(new URI("file:/users/dpitt/test2.pdf"))));
		ReportProcessor processor = new ReportProcessor(new TimesheetReportFactory(), new TimesheetReportIterator());
		processor.writer = writer;
		processor.process();

	}

	@Test
	public void reportTestConsole() {
		ReportWriter writer = new ConsoleWriter();
		ReportFactory factory = new TimesheetReportFactory();
		ReportProcessor processor = new ReportProcessor();
		processor.writer = writer;
		processor.iterator = new TimesheetReportIterator();
		processor.setFactory(factory);
		processor.process();
	}

}
