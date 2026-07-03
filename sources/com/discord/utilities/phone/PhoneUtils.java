package com.discord.utilities.phone;

import android.content.Context;
import com.discord.models.phone.PhoneCountryCode;
import java.util.Locale;
import java.util.Objects;
import kotlin.text.Regex;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PhoneUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneUtils {
    public static final PhoneUtils INSTANCE = new PhoneUtils();
    private static final Regex PARTIAL_PHONE_RE = new Regex("^[-() \\d]+$");

    private PhoneUtils() {
    }

    public final String getTranslatedStringForCountry(PhoneCountryCode data, Context context) {
        C12238m.checkNotNullParameter(data, "data");
        C12238m.checkNotNullParameter(context, "context");
        String phoneCountryCode = data.getPhoneCountryCode();
        Locale locale = Locale.getDefault();
        C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(phoneCountryCode, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = phoneCountryCode.toLowerCase(locale);
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        int identifier = context.getResources().getIdentifier(C1643a.m883w("country_name_", lowerCase), "string", context.getPackageName());
        if (identifier == 0) {
            return data.getName();
        }
        String string = context.getString(identifier);
        C12238m.checkNotNullExpressionValue(string, "context.getString(identifier)");
        return string;
    }

    public final boolean isLikelyToContainPhoneNumber(String input) {
        C12238m.checkNotNullParameter(input, "input");
        if (input.length() < 3) {
            return false;
        }
        return isValidPhoneFragment(input);
    }

    public final boolean isValidPhoneFragment(String input) {
        C12238m.checkNotNullParameter(input, "input");
        return PARTIAL_PHONE_RE.matches(input);
    }
}
