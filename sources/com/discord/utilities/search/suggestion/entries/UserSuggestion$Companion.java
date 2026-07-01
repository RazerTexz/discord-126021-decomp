package com.discord.utilities.search.suggestion.entries;

import android.annotation.SuppressLint;
import b.d.b.a.a;
import com.discord.utilities.user.UserUtils;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserSuggestion$Companion {
    private UserSuggestion$Companion() {
    }

    public static final /* synthetic */ String access$getUsernameWithDiscriminator(UserSuggestion$Companion userSuggestion$Companion, String str, int i) {
        return userSuggestion$Companion.getUsernameWithDiscriminator(str, i);
    }

    private final String getUsernameWithDiscriminator(String userName, int discriminator) {
        StringBuilder sbU = a.U(userName);
        sbU.append(UserUtils.INSTANCE.padDiscriminator(discriminator));
        return sbU.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean canComplete(String username, int discriminator, String nickname, CharSequence currentInput) {
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(currentInput, "currentInput");
        String usernameWithDiscriminator = getUsernameWithDiscriminator(username, discriminator);
        String string = currentInput.toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = string.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (w.contains((CharSequence) usernameWithDiscriminator, (CharSequence) lowerCase, true)) {
            return true;
        }
        return nickname != null ? w.contains((CharSequence) nickname, (CharSequence) lowerCase, true) : false;
    }

    public /* synthetic */ UserSuggestion$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
