package com.fab365.recruit.test.model.fee;

public enum BasicUnLimitFeeType implements BasicFeeType{
  BASIC_UN_LIMIT_FEE_TYPE01("69900",69900);

  private final String feeName;
  private final int basicAmount;

  BasicUnLimitFeeType(final String feeName, final int basicAmount) {
    this.feeName = feeName;
    this.basicAmount = basicAmount;
  }

  @Override
  public String feeName() {
    return feeName;
  }

  @Override
  public int feeAmount() {
    return basicAmount;
  }

  @Override
  public int feeCapacity() {
    throw new RuntimeException("무제한 요금제는 기본제공 용량이 무제한입니다.");
  }
}
