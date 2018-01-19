package com.allSales.exceptionHandler;

public class DealNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;
	private Long dealId;

	public DealNotFoundException(Long dealId) {
		this.dealId = dealId;
	}

	public Long getDealId() {
		return dealId;
	}
}