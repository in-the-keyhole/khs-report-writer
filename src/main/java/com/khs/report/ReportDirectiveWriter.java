package com.khs.report;

import java.util.List;

/**
 * @author dpitt@keyholesoftware.com
 */
public class ReportDirectiveWriter {

	public void write(List<? extends List<String[]>> rows) throws Exception {

		for (List<String[]> row : rows) {

			for (String[] cols : row) {

				System.out.print(cols);
				// for (String c : r) {
				// System.out.print(c);
				// }
			}

			System.out.println("");

		}

	}
}
