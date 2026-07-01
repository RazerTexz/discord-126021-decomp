package com.discord.utilities.email;

import d0.z.d.m;
import kotlin.text.Regex;

/* JADX INFO: compiled from: EmailUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmailUtils {
    public static final EmailUtils INSTANCE = new EmailUtils();
    private static final Regex EMAIL_REGEX = new Regex("/^([\\w-+]+(?:\\.[\\w-+]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,63}(?:\\.[a-z]{2})?)$/i");

    private EmailUtils() {
    }

    public final boolean isEmailLike(String input) {
        m.checkNotNullParameter(input, "input");
        return EMAIL_REGEX.matches(input);
    }
}
