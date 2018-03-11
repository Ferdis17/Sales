package com.allSales.exceptionHandler;

public class SaleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;
	private Long saleId;

	public SaleNotFoundException(Long saleId) {
		this.saleId = saleId;
	}

	public Long getSaleId() {
		return saleId;
	}
}