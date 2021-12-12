package com.fab365.recruit.test.model.fee;

public enum BasicLimitFeeType implements BasicFeeType{
  BASIC_LIMIT_FEE_TYPE01("29900",29900,300),
  BASIC_LIMIT_FEE_TYPE02("34900",34900,3000);

  private final String feeName;
  private final int basicAmount;
  private final int basicCapacity;

  BasicLimitFeeType(final String feeName, final int basicAmount, final int basicCapacity) {
    this.feeName = feeName;
    this.basicAmount = basicAmount;
    this.basicCapacity = basicCapacity;
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
    return basicCapacity;
  }
}
