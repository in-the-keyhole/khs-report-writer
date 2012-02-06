package com.khs.stockquotereport.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;

import com.khs.report.Column;
import com.khs.report.ReportFactory;
import com.khs.report.ReportingDefaultConstants;

/**
 * 
 * Stock report columns, headings and footings
 * 
 * @author dpitt (www.keyholesoftware.com)
 * 
 */
public class StockQuoteReportFactory extends ReportFactory {

	// column ids and heading names

	public final static String TICKER = "Ticker";
	public final static String NAME = "Name";
	public final static String PRICE = "Price";
	public final static String TRADE_DATE = "Trade Date";
	public final static String PE = "P/E";
	public final static String DIVIDEND_YIELD = "Dividend Yield";

	@Override
	public List<Column> getColumns() {

		List<Column> cols = new ArrayList<Column>();
		cols.add(Column.New(TICKER, TICKER));
		cols.add(Column.New(NAME, NAME));
		cols.add(Column.New(TRADE_DATE, TRADE_DATE));
		cols.add(Column.NewNumeric(PRICE, PRICE));
		cols.add(Column.NewNumeric(PE, PE));
		cols.add(Column.NewNumeric(DIVIDEND_YIELD, DIVIDEND_YIELD));
		return cols;

	}

	@Override
	// No footer
	public String[] getFooter() {
		return new String[] {};
	}

	@Override
	// report header with current date and time
	public String[] getHeader() {
		Calendar cal = Calendar.getInstance();
		String date = DateFormatUtils.format(cal, ReportingDefaultConstants.DATE_FORMAT);
		String time = DateFormatUtils.format(cal, ReportingDefaultConstants.TIME_FORMAT);
		return new String[] { "Date: " + date, "Time: " + time, "~Stock Information~" };

	}

}
