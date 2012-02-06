package com.khs.report;

import java.math.BigDecimal;

/**
 * @author dpitt@keyholesoftware.com
 */
public class Total {

	private String id;
	private BigDecimal total = new BigDecimal(0.0);

	public void add(BigDecimal bd) {
		setTotal(getTotal().add(bd));
	}

	public void clear() {
		setTotal(new BigDecimal(0.0));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}