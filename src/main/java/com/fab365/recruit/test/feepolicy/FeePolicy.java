package com.fab365.recruit.test.feepolicy;

import com.fab365.recruit.test.model.Amount;
import com.fab365.recruit.test.model.Capacity;
import com.fab365.recruit.test.model.fee.FeeType;

public interface FeePolicy {

  Capacity calculateTotalCapacity(final int spendCapacity);

  FeeType resultFee(Capacity useCapacity);

  FeeType resultFee();

  boolean isUnLimitFee();

  FeeType recommendFeeType(FeeType targetFeeType);

  Amount getAmount();

  String feeName();
}