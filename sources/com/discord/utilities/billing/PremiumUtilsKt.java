package com.discord.utilities.billing;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.locale.LocaleManager;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().apply { set(2020, 2, 1) }");
        Date time = calendar.getTime();
        C12238m.checkNotNullExpressionValue(time, "Calendar.getInstance().a… { set(2020, 2, 1) }.time");
        GRANDFATHERED_MONTHLY_END_DATE = time;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 0, 1);
        C12238m.checkNotNullExpressionValue(calendar2, "Calendar.getInstance().apply { set(2021, 0, 1) }");
        Date time2 = calendar2.getTime();
        C12238m.checkNotNullExpressionValue(time2, "Calendar.getInstance().a… { set(2021, 0, 1) }.time");
        GRANDFATHERED_YEARLY_END_DATE = time2;
    }

    public static final CharSequence getFormattedPriceUsd(int i, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new LocaleManager().getPrimaryLocale(context));
        currencyInstance.setCurrency(Currency.getInstance("USD"));
        String str = currencyInstance.format(Float.valueOf(i / 100));
        C12238m.checkNotNullExpressionValue(str, "numberFormat.format(priceUsdDollars)");
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
        C12238m.checkNotNullParameter(modelPaymentSource, "paymentSource");
        if (modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            return C5419R.drawable.ic_creditcard_paypal;
        }
        if (!(modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard)) {
            return C5419R.drawable.ic_creditcard_generic;
        }
        String brand = ((ModelPaymentSource.ModelPaymentSourceCard) modelPaymentSource).getBrand();
        Objects.requireNonNull(brand, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = brand.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -2038717326:
                if (lowerCase.equals("mastercard")) {
                    return C5419R.drawable.ic_creditcard_mastercard;
                }
                return C5419R.drawable.ic_creditcard_generic;
            case 2997727:
                if (lowerCase.equals("amex")) {
                    return C5419R.drawable.ic_creditcard_amex;
                }
                return C5419R.drawable.ic_creditcard_generic;
            case 3619905:
                return lowerCase.equals("visa") ? C5419R.drawable.ic_creditcard_visa : C5419R.drawable.ic_creditcard_generic;
            case 61060803:
                if (lowerCase.equals("american-express")) {
                    return C5419R.drawable.ic_creditcard_amex;
                }
                return C5419R.drawable.ic_creditcard_generic;
            case 273184745:
                return lowerCase.equals("discover") ? C5419R.drawable.ic_creditcard_discover : C5419R.drawable.ic_creditcard_generic;
            case 1174445979:
                if (lowerCase.equals("master-card")) {
                    return C5419R.drawable.ic_creditcard_mastercard;
                }
                return C5419R.drawable.ic_creditcard_generic;
            default:
                return C5419R.drawable.ic_creditcard_generic;
        }
    }
}
