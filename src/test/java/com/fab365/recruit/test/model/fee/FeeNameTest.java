package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class FeeNameTest {

  @DisplayName("요금제명을 주입하여 요금제명 객체를 반환한다.")
  @Test
  void createFeeNameTest() {
    FeeName testFeeName = new FeeName("test");
    assertAll(
        () -> assertThat(testFeeName).isEqualTo(new FeeName("test")),
        () -> assertThat(testFeeName.getFeeName()).isEqualTo("test")
    );
  }

  @DisplayName("주입되는 요금제명이 빈값인 경우 에러를 반환한다.")
  @ParameterizedTest
  @NullAndEmptySource
  void validationFeeNameTest(String name) {
    assertThatThrownBy(
        () -> new FeeName(name)
    ).isInstanceOf(IllegalArgumentException.class);
  }
}