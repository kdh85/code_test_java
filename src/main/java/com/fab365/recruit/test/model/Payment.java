package com.fab365.recruit.test.model;

import java.util.List;

import com.fab365.recruit.test.PlanService;

public abstract class Payment implements PlanService {

	@Override
	public String recommendFee(int usageDataInMegabyte) {
		return null;
	}

	@Override
	public int totalAmountCalculate(int overAmount) {
		return 0;
	}

	@Override
	public OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee) {
		throw new IllegalArgumentException("초과 사용량 계산을 할 수 없습니다.");
	}

	@Override
	public OverAmount overAmountCalculate(int overCapacity) {
		throw new IllegalArgumentException("초과 요금 계산을 할 수 없습니다.");
	}

	@Override
	public List<Fee> generateAllFee() {
		return Fee.asList();
	}
}
