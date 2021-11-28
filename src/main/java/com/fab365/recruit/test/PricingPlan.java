package com.fab365.recruit.test;

import com.fab365.recruit.test.model.BasicOverCost;
import com.fab365.recruit.test.model.Fee;
import com.fab365.recruit.test.model.OverAmount;
import com.fab365.recruit.test.model.TotalUserAmount;

public interface PricingPlan {
	void overCapacityCalculate(int usageDataInMegabyte, Fee fee);

	OverAmount overAmountCalculate(BasicOverCost basicOverCost);

	TotalUserAmount totalAmountCalculate(Fee fee);
}
