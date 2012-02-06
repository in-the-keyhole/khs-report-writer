package com.khs.timesheetreport.test;

import java.util.ArrayList;
import java.util.List;

import com.khs.report.Column;
import com.khs.report.ReportFactory;

/**
 * Example Timesheet report format (i.e. columns,headings, footings, groupings, totaling, etc..)
 * 
 * Defines a report of timesheets that subtotals on employee hours
 * 
 * @author dpitt
 * 
 */
public class TimesheetReportFactory extends ReportFactory {

	// column ids

	public final static String WEEKEND = "weekend";
	public final static String DEPARTMENT = "department";
	public final static String EMPLOYEE = "employee";
	public final static String HOURS = "hours";

	@Override
	public String[] getHeader() {

		return new String[] { "Example Report", "~Example Timesheet Report~Page #" };
	}

	@Override
	public List<Column> getColumns() {

		List<Column> cols = new ArrayList<Column>();
		cols.add(Column.New(WEEKEND, "Weekend"));

		// group on department
		cols.add(Column.NewGroup(DEPARTMENT, "Department"));

		cols.add(Column.New(EMPLOYEE, "Employee"));

		// total on hours
		cols.add(Column.NewTotal(HOURS, "Hours"));

		return cols;
	}

	@Override
	public String[] getFooter() {

		return new String[] { "~Footer for " };

	}

}
