package com.khs.timesheetreport.test;

import static com.khs.timesheetreport.test.TimesheetReportFactory.DEPARTMENT;
import static com.khs.timesheetreport.test.TimesheetReportFactory.EMPLOYEE;
import static com.khs.timesheetreport.test.TimesheetReportFactory.HOURS;
import static com.khs.timesheetreport.test.TimesheetReportFactory.WEEKEND;

import java.util.ArrayList;
import java.util.List;

import com.khs.report.Data;
import com.khs.report.EOF;
import com.khs.report.ReportIterator;

/*
 * Produce report data rows...they must be sorted in report grouping order
 * in reality a database or some kind of data source will be read
 * 
 */
public class TimesheetReportIterator implements ReportIterator {

	List<List<Data>> objects;
	int index = 0;

	public TimesheetReportIterator() {

		objects = doQuery();
		int index = 0;

	}

	/**
	 * Return report data which is a List of List<Data> objects that represent rows and columns of a report
	 * 
	 * @return List<List<Data>>
	 */
	public List<List<Data>> doQuery() {

		// Create 200 test records
		int loops = 200;
		int count = 0;

		List<List<Data>> rows = new ArrayList<List<Data>>();

		while (count < loops) {

			count++;
			List<Data> cols = new ArrayList<Data>();

			Data d = new Data();
			d.setId(WEEKEND);
			d.setValue("06/30/20");

			cols.add(d);

			d = new Data();
			d.setId(DEPARTMENT);
			d.setValue(count > 25 ? "Information Technology" : "Accounting");

			cols.add(d);

			d = new Data();
			d.setId(EMPLOYEE);
			d.setValue(count % 2 == 0 ? "Doe,Jane" : "Squidlow,Clifford");

			cols.add(d);

			d = new Data();
			d.setId(HOURS);
			d.setValue(count);

			cols.add(d);
			rows.add(cols);

		}
		return rows;
	}

	public List<Data> nextRow() {

		if (index >= objects.size()) {
			List<Data> eof = new ArrayList<Data>();
			eof.add(new EOF());
			return eof;
		}

		List<Data> result = objects.get(index);
		index++;
		return result;
	}

}
