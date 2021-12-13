package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FeeFactoryTest {

  @DisplayName("모든 유제한 요금 객체들을 생성한다.")
  @Test
  void createAllLimitFeesTest() {
    List<FeeType> allFees = FeeFactory.createAllLimitFees();

    assertThat(allFees).containsExactly(
        UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01),
        UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02));
  }

  @DisplayName("모든 무제한 요금 객체들을 생성한다.")
  @Test
  void createAllUnLimitFeesTest() {
    List<FeeType> allFees = FeeFactory.createAllUnLimitFees();

    assertThat(allFees).containsExactly(
        UserUnLimitFee.of(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01));
  }

  @DisplayName("모든 요금객체들을 생성한다.")
  @Test
  void createAllFeesTest() {
    List<FeeType> allFees = FeeFactory.createAllFees();

    assertThat(allFees).containsExactly(
        UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01),
        UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02),
        UserUnLimitFee.of(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01));
  }
}