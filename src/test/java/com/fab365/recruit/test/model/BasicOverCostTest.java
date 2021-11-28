package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicOverCostTest {

	@DisplayName("기본 초과요금 생성 검증.")
	@Test
	void createBasicOverCostTest() {
		assertAll(
			() -> assertThat(BasicOverCost.BASIC_TYPE.getBasicAmount()).isEqualTo(20),
			() -> assertThat(BasicOverCost.BASIC_TYPE.getBasicCapacity()).isEqualTo(1)
		);
	}

	@DisplayName("초과용량에 따른 비용 반환 검증.")
	@Test
	void costCalculateTest() {
		assertThat(BasicOverCost.BASIC_TYPE.calculateAmount(100)).isEqualTo(2000);
	}
}