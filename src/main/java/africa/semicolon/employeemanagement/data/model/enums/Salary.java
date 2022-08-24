package africa.semicolon.employeemanagement.data.model.enums;

import java.math.BigDecimal;

public enum Salary {
    SEVENTY_THOUSAND(70000), TWO_HUNDRED_THOUSAND(200000), FIVE_HUNDRED_THOUSAND(500000),EIGHT_HUNDRED_THOUSAND(800000);
//    public static final BigDecimal INTERNSHIP_SALARY = BigDecimal.valueOf(70000);
//    public static final BigDecimal ENTRY_LEVEL_SALARY = BigDecimal.valueOf(200000);
//    public static final BigDecimal MID_LEVEL_SALARY = BigDecimal.valueOf(500000);
//    public static final BigDecimal SENIOR_LEVEL_SALARY = BigDecimal.valueOf(800000);

    Salary(int amount) {

    }
}
