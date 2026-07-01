package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.Intrinsics3;
import java.util.Locale;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompletableKt {
    public static final int getSortIndex(Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "$this$getSortIndex");
        if (autocompletable instanceof UserAutocompletable) {
            return 0;
        }
        if (autocompletable instanceof RoleAutocompletable) {
            return 1;
        }
        if (autocompletable instanceof GlobalRoleAutocompletable) {
            return 2;
        }
        if (autocompletable instanceof ChannelAutocompletable) {
            return 3;
        }
        if (autocompletable instanceof EmojiAutocompletable) {
            return 4;
        }
        if (autocompletable instanceof ApplicationCommandAutocompletable) {
            return 5;
        }
        if (autocompletable instanceof ApplicationCommandChoiceAutocompletable) {
            return 6;
        }
        if (autocompletable instanceof ApplicationCommandLoadingPlaceholder) {
            return 7;
        }
        if (autocompletable instanceof ApplicationPlaceholder) {
            return 8;
        }
        if (autocompletable instanceof EmojiUpsellPlaceholder) {
            return 9;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String lower(String str) {
        Locale locale = Locale.getDefault();
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
