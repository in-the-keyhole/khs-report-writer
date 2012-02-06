package com.khs.report;

/**
 * Output raw report writer directives to the console
 * 
 * @author dpitt www.keyholesoftware.com
 * 
 */
public class ConsoleWriter implements ReportWriter {

	public void write(String[] row) {
		for (String cell : row) {
			System.out.print(cell);
		}

		System.out.println("");

	}
}
