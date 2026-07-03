package com.discord.models.requiredaction;

import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RequiredAction.kt */
/* JADX INFO: loaded from: classes.dex */
public enum RequiredAction {
    AGREEMENTS,
    TOS_UPDATE_ACKNOWLEDGMENT,
    REQUIRE_VERIFIED_EMAIL,
    REQUIRE_VERIFIED_PHONE,
    REQUIRE_CAPTCHA,
    NONE;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: RequiredAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public final RequiredAction fromApiString(String requiredAction) {
            if (requiredAction != null) {
                try {
                    Locale locale = Locale.ROOT;
                    C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                    String upperCase = requiredAction.toUpperCase(locale);
                    C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    RequiredAction requiredActionValueOf = RequiredAction.valueOf(upperCase);
                    if (requiredActionValueOf != null) {
                        return requiredActionValueOf;
                    }
                } catch (IllegalArgumentException unused) {
                    return RequiredAction.NONE;
                } catch (NullPointerException unused2) {
                    return RequiredAction.NONE;
                }
            }
            return RequiredAction.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
