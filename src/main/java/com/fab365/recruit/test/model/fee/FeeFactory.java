package com.fab365.recruit.test.model.fee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeeFactory {

  public static List<FeeType> createAllLimitFees() {
    return Arrays.stream(BasicLimitFeeType.values())
        .map(UserLimitFee::of)
        .collect(Collectors.toList());
  }

  public static List<FeeType> createAllUnLimitFees() {
    return Arrays.stream(BasicUnLimitFeeType.values())
        .map(UserUnLimitFee::of)
        .collect(Collectors.toList());
  }

  public static List<FeeType> createAllFees() {
    return Stream.concat(createAllLimitFees().stream(), createAllUnLimitFees().stream())
        .collect(Collectors.toList());
  }
}
