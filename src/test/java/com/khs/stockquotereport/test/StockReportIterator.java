package com.khs.stockquotereport.test;

import static com.khs.stockquotereport.test.StockQuoteReportFactory.DIVIDEND_YIELD;
import static com.khs.stockquotereport.test.StockQuoteReportFactory.NAME;
import static com.khs.stockquotereport.test.StockQuoteReportFactory.PE;
import static com.khs.stockquotereport.test.StockQuoteReportFactory.PRICE;
import static com.khs.stockquotereport.test.StockQuoteReportFactory.TICKER;
import static com.khs.stockquotereport.test.StockQuoteReportFactory.TRADE_DATE;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.khs.report.Data;
import com.khs.report.ReportIterator;

/**
 * Reads current stock info from YAHOO finance URL and parses into report column rows
 * 
 * @author dpitt www.keyholesoftware.com
 * 
 */
public class StockReportIterator implements ReportIterator {

	class Stock {
		String ticker;
		String name;
		String tradeDate;
		float price;
		float dividendYield;
		float pe;
	}

	private final static String NA = "N/A";
	private final String YAHOO_FINANCE_URL = "http://finance.yahoo.com/d/quotes.csv?";
	private final String TICKERS = "s=XOM+JNJ+MSFT+GOOG+GE+INTC+AAPL+ORCL+VMW+CSCO";
	private final String PARAMS = "snd1l1yrj1";
	private final Queue<Stock> stocks = new ConcurrentLinkedQueue<Stock>();

	public StockReportIterator() {
		loadStocks();
	}

	/**
	 * Return next report row EOF when done.
	 */
	public List<Data> nextRow() {

		Stock stock = stocks.poll();
		if (stock == null) {
			return null;
		}

		List<Data> cols = new ArrayList<Data>();
		cols.add(Data.convertToData(TICKER, stock.ticker));
		cols.add(Data.convertToData(NAME, stock.name));
		cols.add(Data.convertToData(TRADE_DATE, stock.tradeDate));
		cols.add(Data.convertToData(PRICE, stock.price));
		cols.add(Data.convertToData(PE, stock.pe));
		cols.add(Data.convertToData(DIVIDEND_YIELD, stock.dividendYield));

		return cols;
	}

	/**
	 * Load stock data from YAHOO data feed
	 */
	private void loadStocks() {

		String content = "";
		try {
			URL url = new URL(YAHOO_FINANCE_URL + TICKERS + "&f=" + PARAMS);
			InputStreamReader in = new InputStreamReader(url.openStream());
			int c;
			while ((c = in.read()) > 0) {
				content = content + (char) c;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// parse csv result format
		String rows[] = content.split("\r\n");
		for (String value : rows) {
			String[] values = value.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			Stock stock = new Stock();
			stock.ticker = values[0].replaceAll("\"", "");
			stock.name = values[1].replaceAll("\"", "");
			stock.tradeDate = values[2].replaceAll("\"", "");
			stock.price = new Float(values[3]);
			stock.dividendYield = values[4].equals(NA) ? 0.0f : new Float(values[4]);
			stock.pe = new Float(values[5]);
			stocks.add(stock);

		}

	}
}
