package com.fab365.recruit.test.model.fee;

public abstract class LimitFee extends FeeType {

	private static final String ERROR_EMPTY_USE_CAPACITY = "유제한 요금제는 초과사용량을 집계해야 합니다.";

	@Override
	public boolean isUnLimitFee() {
		return false;
	}

	@Override
	public LimitFee resultFee() {
		throw new RuntimeException(ERROR_EMPTY_USE_CAPACITY);
	}
}
