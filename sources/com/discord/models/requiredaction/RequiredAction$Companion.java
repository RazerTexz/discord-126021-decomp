package com.discord.models.requiredaction;

import d0.z.d.m;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RequiredAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RequiredAction$Companion {
    private RequiredAction$Companion() {
    }

    public final RequiredAction fromApiString(String requiredAction) {
        if (requiredAction != null) {
            try {
                Locale locale = Locale.ROOT;
                m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                String upperCase = requiredAction.toUpperCase(locale);
                m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
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

    public /* synthetic */ RequiredAction$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
