package com.khs.stockquotereport.test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.junit.Test;

import com.khs.report.ReportProcessor;
import com.khs.report.writer.ReportPDFWriter;

public class UnitTest {

	@Test
	public void reportPDFTest() throws Exception {
		// output writer
		ReportPDFWriter writer = new ReportPDFWriter();
		writer.setOut(new FileOutputStream(new File(new URI("file:/users/dpitt/stocks.pdf"))));
		// column widths
		writer.setColWidths(new int[] { 100, 200, 100, 100, 100, 100 });

		// create processor with factory and iterator
		ReportProcessor processor = new ReportProcessor(new StockQuoteReportFactory(), new StockReportIterator());
		processor.writer = writer;
		processor.process();
	}

}
