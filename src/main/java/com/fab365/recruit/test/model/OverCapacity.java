package com.fab365.recruit.test.model;

public class OverCapacity extends Payment {

	private static final int MIN_OVER_CAPACITY_VALUE = 0;
	private static final String ERROR_MIN_OVER_CAPACITY_VALUE = String.format("초과 사용량은 %d 이상부터 가능합니다.",
		MIN_OVER_CAPACITY_VALUE);

	private int overCapacity;

	public OverCapacity() {
	}

	public int getOverCapacity() {
		return overCapacity;
	}

	@Override
	public OverCapacity overCapacityCalculate(int usageDataInMegabyte, Fee fee) {

		validationUseData(usageDataInMegabyte);

		this.overCapacity = usageDataInMegabyte - fee.getBasicFreeCapacity();

		if (this.overCapacity < MIN_OVER_CAPACITY_VALUE) {
			this.overCapacity = MIN_OVER_CAPACITY_VALUE;
		}
		return this;
	}

	private void validationUseData(int usageDataInMegabyte) {
		if (usageDataInMegabyte < MIN_OVER_CAPACITY_VALUE) {
			throw new IllegalArgumentException(ERROR_MIN_OVER_CAPACITY_VALUE);
		}
	}
}
