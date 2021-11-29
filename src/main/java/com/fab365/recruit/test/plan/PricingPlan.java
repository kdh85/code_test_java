package com.fab365.recruit.test.plan;

import com.fab365.recruit.test.model.BasicOverCost;
import com.fab365.recruit.test.model.Fee;
import com.fab365.recruit.test.model.OverCapacity;
import com.fab365.recruit.test.model.TotalUserAmount;

public interface PricingPlan {
	OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee);

	int calculateAmountByCapacity(BasicOverCost basicOverCost);

	TotalUserAmount totalAmountCalculate(Fee fee);
}
