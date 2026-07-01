package com.discord.utilities.billing;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DrawableRes;
import com.discord.R;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.locale.LocaleManager;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.utilities.billing.PremiumUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PremiumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PremiumUtils2 {
    public static final int GRACE_PERIOD_LONG = 7;
    public static final int GRACE_PERIOD_SHORT = 3;
    private static final Date GRANDFATHERED_MONTHLY_END_DATE;
    private static final Date GRANDFATHERED_YEARLY_END_DATE;
    public static final int MAX_ACCOUNT_HOLD_DAYS = 30;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 2, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().apply { set(2020, 2, 1) }");
        Date time = calendar.getTime();
        Intrinsics3.checkNotNullExpressionValue(time, "Calendar.getInstance().a… { set(2020, 2, 1) }.time");
        GRANDFATHERED_MONTHLY_END_DATE = time;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 0, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "Calendar.getInstance().apply { set(2021, 0, 1) }");
        Date time2 = calendar2.getTime();
        Intrinsics3.checkNotNullExpressionValue(time2, "Calendar.getInstance().a… { set(2021, 0, 1) }.time");
        GRANDFATHERED_YEARLY_END_DATE = time2;
    }

    public static final CharSequence getFormattedPriceUsd(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new LocaleManager().getPrimaryLocale(context));
        currencyInstance.setCurrency(Currency.getInstance("USD"));
        String str = currencyInstance.format(Float.valueOf(i / 100));
        Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(priceUsdDollars)");
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
        Intrinsics3.checkNotNullParameter(modelPaymentSource, "paymentSource");
        if (modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            return R.drawable.ic_creditcard_paypal;
        }
        if (!(modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard)) {
            return R.drawable.ic_creditcard_generic;
        }
        String brand = ((ModelPaymentSource.ModelPaymentSourceCard) modelPaymentSource).getBrand();
        Objects.requireNonNull(brand, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = brand.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -2038717326:
                if (lowerCase.equals("mastercard")) {
                    return R.drawable.ic_creditcard_mastercard;
                }
                return R.drawable.ic_creditcard_generic;
            case 2997727:
                if (lowerCase.equals("amex")) {
                    return R.drawable.ic_creditcard_amex;
                }
                return R.drawable.ic_creditcard_generic;
            case 3619905:
                return lowerCase.equals("visa") ? R.drawable.ic_creditcard_visa : R.drawable.ic_creditcard_generic;
            case 61060803:
                if (lowerCase.equals("american-express")) {
                    return R.drawable.ic_creditcard_amex;
                }
                return R.drawable.ic_creditcard_generic;
            case 273184745:
                return lowerCase.equals("discover") ? R.drawable.ic_creditcard_discover : R.drawable.ic_creditcard_generic;
            case 1174445979:
                if (lowerCase.equals("master-card")) {
                    return R.drawable.ic_creditcard_mastercard;
                }
                return R.drawable.ic_creditcard_generic;
            default:
                return R.drawable.ic_creditcard_generic;
        }
    }
}
