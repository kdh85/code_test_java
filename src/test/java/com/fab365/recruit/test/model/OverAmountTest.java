package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OverAmountTest {

	@DisplayName("초과사용 용량에 대한 초과요금 반환 검증.")
	@ParameterizedTest
	@ValueSource(ints = {0, 100, 2500})
	void createOverAmountTest(int overCost) {
		assertThat(OverAmount.from(overCost).getOverAmount()).isEqualTo(overCost);
	}

	@DisplayName("초과사용시 해당 요금제 기준 총 요금액을 반환 검증.")
	@ParameterizedTest
	@CsvSource(value = {"100, 30000, 35000, 70000", "10000, 39900, 44900, 79900"})
	void calculateTotalAmountTest(int overCost, int total29900, int total34900, int total69900) {

		assertAll(
			() -> assertThat(OverAmount.from(overCost).totalAmountCalculate(Fee.FEE_29900).getTotalAmount()).isEqualTo(total29900),
			() -> assertThat(OverAmount.from(overCost).totalAmountCalculate(Fee.FEE_34900).getTotalAmount()).isEqualTo(total34900),
			() -> assertThat(OverAmount.from(overCost).totalAmountCalculate(Fee.FEE_69900).getTotalAmount()).isEqualTo(total69900)
		);
	}
}