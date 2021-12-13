package com.fab365.recruit.test.model.fee;

public abstract class LimitFee extends FeeType {

  @Override
  public boolean isUnLimitFee() {
    return false;
  }

  @Override
  public LimitFee resultFee() {
    throw new IllegalArgumentException("유제한 요금제는 초과사용량을 집계해야 합니다.");
  }
}
