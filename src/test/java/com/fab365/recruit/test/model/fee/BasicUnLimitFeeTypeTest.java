package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicUnLimitFeeTypeTest {

  @DisplayName("요금제별 각 요금명을 반환한다.")
  @Test
  void return_fee_nameTest() {
    assertThat(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01.feeName()).isEqualTo("69900");
  }

  @DisplayName("요금제별 각 요금을 반환한다.")
  @Test
  void return_fee_amountTest() {
    assertThat(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01.feeAmount()).isEqualTo(69900);
  }

  @DisplayName("요금제별 각 기본 용량을 반환한다.")
  @Test
  void return_fee_capacityTest() {
    assertThatThrownBy(
        BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01::feeCapacity
    ).isInstanceOf(RuntimeException.class);
  }
}