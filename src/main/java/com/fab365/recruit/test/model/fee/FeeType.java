package com.fab365.recruit.test.model.fee;

import com.fab365.recruit.test.feepolicy.FeePolicy;
import com.fab365.recruit.test.model.Amount;
import com.fab365.recruit.test.model.Capacity;

public abstract class FeeType implements FeePolicy {

	private static final String ERROR_BEFORE_FEE_CALCULATE_CAPACITY = "요금을 생성 후 초과 사용량을 계산해야 합니다.";
	private static final String ERROR_BEFORE_FEE_RESULT = "요금을 생성 후 총 사용량을 계산해야 합니다.";
	private static final String ERROR_BEFORE_FEE_IS_UN_LIMIT = "요금을 생성 후 유제한/무제한 요금을 구분해야 합니다.";
	private static final String ERROR_BEFORE_FEE_RECOMMEND_FEE = "요금을 생성 후 추천 요금을 구해야 합니다.";
	private static final String ERROR_BEFORE_FEE_AMOUNT = "요금을 생성 후 요금액을 확인해야 합니다.";
	private static final String ERROR_BEFORE_FEE_NAME = "요금을 생성 후 요금제명을 확인해야 합니다.";

	@Override
	public Capacity calculateTotalCapacity(int spendCapacity) {
		throw new RuntimeException(ERROR_BEFORE_FEE_CALCULATE_CAPACITY);
	}

	@Override
	public FeeType resultFee(Capacity useCapacity) {
		throw new RuntimeException(ERROR_BEFORE_FEE_RESULT);
	}

	@Override
	public FeeType resultFee() {
		throw new RuntimeException(ERROR_BEFORE_FEE_RESULT);
	}

	@Override
	public boolean isUnLimitFee() {
		throw new RuntimeException(ERROR_BEFORE_FEE_IS_UN_LIMIT);
	}

	@Override
	public FeeType recommendFeeType(FeeType targetFeeType) {
		throw new RuntimeException(ERROR_BEFORE_FEE_RECOMMEND_FEE);
	}

	@Override
	public Amount getAmount() {
		throw new RuntimeException(ERROR_BEFORE_FEE_AMOUNT);
	}

	@Override
	public String feeName() {
		throw new RuntimeException(ERROR_BEFORE_FEE_NAME);
	}
}
