package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecommendFeeTest {

  @DisplayName("사용자 요금객체를 주입받아 추천요금제 객체를 생성한다.")
  @Test
  void createRecommendFeeTest() {
    List<FeeType> feeTypes = new ArrayList<>();
    feeTypes.add(UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01));
    feeTypes.add(UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02));
    feeTypes.add(UserUnLimitFee.of(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01));

    assertThat(RecommendFee.of(feeTypes)).isEqualTo(RecommendFee.of(FeeFactory.createAllFees()));
  }

  @DisplayName("주입되는 요금제 정보가 없으면 에러를 반환한다.")
  @Test
  void validationRecommendFeeTest() {
    assertThatThrownBy(
        () -> RecommendFee.of(new ArrayList<>())
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("요금제정보와 사용된 데이터용량을 주입받아 가장 저렴한 요금제를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"300,29900","3000,34900","30000,69900"})
  void recommendMostCheepFeeTest(int useCapacity, String feeName) {

    RecommendFee of = RecommendFee.of(FeeFactory.createAllFees());
    String recommendFee = of.bestFeeRecommend(useCapacity);

    assertThat(recommendFee).isEqualTo(feeName);
  }
}