package com.fab365.recruit.test;

import java.util.List;

import com.fab365.recruit.test.model.Fee;
import com.fab365.recruit.test.model.OverAmount;
import com.fab365.recruit.test.model.OverCapacity;

public interface PlanService {
	OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee);
	OverAmount overAmountCalculate(int overCapacity);
	int totalAmountCalculate(int overAmount);
	String recommendFee(int usageDataInMegabyte);
	List<Fee> generateAllFee();
}
