package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OverAmountTest {

	private OverAmount overAmount;

	@BeforeEach
	void setUp() {
		overAmount = new OverAmount();
	}

	@DisplayName("초과사용 용량에 대한 초과요금 반환 검증.")
	@ParameterizedTest
	@CsvSource(value = {"100,2000", "0,0", "2500, 50000"})
	void createOverAmountTest(int overCapacity, int overCost) {
		assertThat(overAmount.overAmountCalculate(overCapacity, BasicOverCost.BASIC_TYPE).getOverAmount()).isEqualTo(
			overCost);
	}

	@DisplayName("입력되는 초과사용량이 0 미만인 경우 에러반환 검증.")
	@Test
	void validationAmountTest() {
		assertThatThrownBy(
			() -> overAmount.overAmountCalculate(-1, BasicOverCost.BASIC_TYPE)
		).isInstanceOf(IllegalArgumentException.class);
	}
}