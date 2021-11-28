package com.fab365.recruit.test;

import java.util.List;

import com.fab365.recruit.test.model.BasicOverCost;
import com.fab365.recruit.test.model.Fee;
import com.fab365.recruit.test.model.OverAmount;
import com.fab365.recruit.test.model.OverCapacity;
import com.fab365.recruit.test.model.TotalUserAmount;

public interface PricingPlan {
	OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee);
	OverAmount overAmountCalculate(int overCapacity, BasicOverCost basicOverCost);
	TotalUserAmount totalAmountCalculate(int overAmount, Fee fee);
}
