package com.fab365.recruit.test.model;

import com.fab365.recruit.test.PricingPlan;

public abstract class Payment implements PricingPlan {

	private static final String ERROR_TOTAL_CALCULATE = "총 사용량을 계산을 할 수 없습니다.";
	private static final String ERROR_OVER_CAPACITY = "초과 사용량 계산을 할 수 없습니다.";
	private static final String ERROR_OVER_AMOUNT = "초과 요금 계산을 할 수 없습니다.";

	@Override
	public TotalUserAmount totalAmountCalculate(Fee fee) {
		throw new IllegalArgumentException(ERROR_TOTAL_CALCULATE);
	}

	@Override
	public void overCapacityCalculate(int usageDataInMegabyte, Fee fee) {
		throw new IllegalArgumentException(ERROR_OVER_CAPACITY);
	}

	@Override
	public OverAmount overAmountCalculate(BasicOverCost basicOverCost) {
		throw new IllegalArgumentException(ERROR_OVER_AMOUNT);
	}

}
