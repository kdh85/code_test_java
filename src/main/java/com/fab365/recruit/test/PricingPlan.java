package com.fab365.recruit.test;

import com.fab365.recruit.test.model.BasicOverCost;
import com.fab365.recruit.test.model.Fee;

public interface PricingPlan {
	void overCapacityCalculate(int usageDataInMegabyte, Fee fee);

	int calculateAmountByCapacity(BasicOverCost basicOverCost);

	int totalAmountCalculate(Fee fee);
}
