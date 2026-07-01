package com.discord.utilities.billing;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DrawableRes;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource$ModelPaymentSourceCard;
import com.discord.models.domain.ModelPaymentSource$ModelPaymentSourcePaypal;
import com.discord.utilities.locale.LocaleManager;
import d0.z.d.m;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtilsKt {
    public static final int GRACE_PERIOD_LONG = 7;
    public static final int GRACE_PERIOD_SHORT = 3;
    private static final Date GRANDFATHERED_MONTHLY_END_DATE;
    private static final Date GRANDFATHERED_YEARLY_END_DATE;
    public static final int MAX_ACCOUNT_HOLD_DAYS = 30;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 2, 1);
        m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().apply { set(2020, 2, 1) }");
        Date time = calendar.getTime();
        m.checkNotNullExpressionValue(time, "Calendar.getInstance().a… { set(2020, 2, 1) }.time");
        GRANDFATHERED_MONTHLY_END_DATE = time;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 0, 1);
        m.checkNotNullExpressionValue(calendar2, "Calendar.getInstance().apply { set(2021, 0, 1) }");
        Date time2 = calendar2.getTime();
        m.checkNotNullExpressionValue(time2, "Calendar.getInstance().a… { set(2021, 0, 1) }.time");
        GRANDFATHERED_YEARLY_END_DATE = time2;
    }

    public static final CharSequence getFormattedPriceUsd(int i, Context context) {
        m.checkNotNullParameter(context, "context");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new LocaleManager().getPrimaryLocale(context));
        currencyInstance.setCurrency(Currency.getInstance("USD"));
        String str = currencyInstance.format(Float.valueOf(i / 100));
        m.checkNotNullExpressionValue(str, "numberFormat.format(priceUsdDollars)");
        return str;
    }

    public static final Date getGRANDFATHERED_MONTHLY_END_DATE() {
        return GRANDFATHERED_MONTHLY_END_DATE;
    }

    public static final Date getGRANDFATHERED_YEARLY_END_DATE() {
        return GRANDFATHERED_YEARLY_END_DATE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0063 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x006f A[ORIG_RETURN, RETURN] */
    @DrawableRes
    @SuppressLint({"DefaultLocale"})
    public static final int getPaymentSourceIcon(ModelPaymentSource modelPaymentSource) {
        m.checkNotNullParameter(modelPaymentSource, "paymentSource");
        if (modelPaymentSource instanceof ModelPaymentSource$ModelPaymentSourcePaypal) {
            return 2131231699;
        }
        if (!(modelPaymentSource instanceof ModelPaymentSource$ModelPaymentSourceCard)) {
            return 2131231697;
        }
        String brand = ((ModelPaymentSource$ModelPaymentSourceCard) modelPaymentSource).getBrand();
        Objects.requireNonNull(brand, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = brand.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -2038717326:
                if (lowerCase.equals("mastercard")) {
                    return 2131231698;
                }
                return 2131231697;
            case 2997727:
                if (lowerCase.equals("amex")) {
                    return 2131231695;
                }
                return 2131231697;
            case 3619905:
                return lowerCase.equals("visa") ? 2131231700 : 2131231697;
            case 61060803:
                if (lowerCase.equals("american-express")) {
                    return 2131231695;
                }
                return 2131231697;
            case 273184745:
                return lowerCase.equals("discover") ? 2131231696 : 2131231697;
            case 1174445979:
                if (lowerCase.equals("master-card")) {
                    return 2131231698;
                }
                return 2131231697;
            default:
                return 2131231697;
        }
    }
}
