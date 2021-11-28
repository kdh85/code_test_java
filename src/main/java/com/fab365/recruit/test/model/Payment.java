package com.fab365.recruit.test.model;

import com.fab365.recruit.test.PricingPlan;

public abstract class Payment implements PricingPlan {

	@Override
	public TotalUserAmount totalAmountCalculate(int overAmount, Fee fee) {
		throw new IllegalArgumentException("총 사용량을 계산을 할 수 없습니다.");
	}

	@Override
	public OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee) {
		throw new IllegalArgumentException("초과 사용량 계산을 할 수 없습니다.");
	}

	@Override
	public OverAmount overAmountCalculate(int overCapacity, BasicOverCost basicOverCost) {
		throw new IllegalArgumentException("초과 요금 계산을 할 수 없습니다.");
	}

}
