package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OverCapacityTest {

	private OverCapacity overCapacity;

	@BeforeEach
	void setUp() {
		overCapacity = OverCapacity.createCapacity();
	}

	@DisplayName("사용량을 입력받아 요금의 기본 제공 데이터량을 초과한 값을 반환하는 검증.")
	@ParameterizedTest
	@CsvSource(value = {"400,100,0,0", "2500,2200,0,0", "3100,2800,100,0", "5000,4700,2000,0"})
	void createOverCapacityTest(int usageDataInMegabyte, int overDataBy29900, int overDataBy34900,
								int overDataBy69900) {

		assertAll(
			() -> calculateCapacityValue(usageDataInMegabyte, Fee.FEE_29900, overDataBy29900),
			() -> calculateCapacityValue(usageDataInMegabyte, Fee.FEE_34900, overDataBy34900),
			() -> calculateCapacityValue(usageDataInMegabyte, Fee.FEE_69900, overDataBy69900)
		);
	}

	private void calculateCapacityValue(int usageDataInMegabyte, Fee feeName, int overDataInMegabyte) {
		overCapacity.overCapacityCalculate(usageDataInMegabyte, feeName);
		assertThat(overCapacity.getOverCapacity()).isEqualTo(overDataInMegabyte);
	}

	@DisplayName("입력받는 초과데이터 량이 0 미만이면 에러를 반환 검증.")
	@ParameterizedTest
	@ValueSource(ints = {-1, -10, -100})
	void validationUseDateTest(int overData) {
		assertAll(
			() -> assertThatThrownBy(() -> overCapacity.overCapacityCalculate(overData, Fee.FEE_29900))
				.isInstanceOf(IllegalArgumentException.class),

			() -> assertThatThrownBy(() -> overCapacity.overCapacityCalculate(overData, Fee.FEE_34900))
				.isInstanceOf(IllegalArgumentException.class),

			() -> assertThatThrownBy(() -> overCapacity.overCapacityCalculate(overData, Fee.FEE_69900))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@DisplayName("초과사용량에 대한 금액계산을 반환 검증.")
	@Test
	void overAmountCalculateTest() {
		assertThat(overCapacity.calculateAmountByCapacity(BasicOverCost.BASIC_TYPE)).isEqualTo(0);
	}
}