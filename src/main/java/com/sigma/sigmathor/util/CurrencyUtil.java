package com.sigma.sigmathor.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class CurrencyUtil {
    public static String format(BigDecimal value) {
        Locale brazil = new Locale("pt", "BR");
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(brazil);
        return decimalFormat.format(value);
    }
}
