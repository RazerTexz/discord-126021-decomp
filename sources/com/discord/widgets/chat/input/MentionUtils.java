package com.discord.widgets.chat.input;

import d0.g0.CharJVM;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Tuples2;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.MentionUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: MentionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MentionUtils {
    public static final char MENTIONS_CHAR = '@';
    public static final char EMOJIS_AND_STICKERS_CHAR = ':';
    public static final char CHANNELS_CHAR = '#';
    public static final char SLASH_CHAR = '/';
    private static final Set<Character> DEFAULT_LEADING_IDENTIFIERS = Sets5.hashSetOf(Character.valueOf(MENTIONS_CHAR), Character.valueOf(EMOJIS_AND_STICKERS_CHAR), Character.valueOf(CHANNELS_CHAR), Character.valueOf(SLASH_CHAR));

    public static final Set<Character> getDEFAULT_LEADING_IDENTIFIERS() {
        return DEFAULT_LEADING_IDENTIFIERS;
    }

    public static final Tuples2<String, Integer> getSelectedToken(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "content");
        if ((charSequence.length() == 0) || i < 0) {
            return new Tuples2<>(null, -1);
        }
        boolean z2 = i == charSequence.length();
        boolean z3 = i == 0 || CharJVM.isWhitespace(charSequence.charAt(i + (-1)));
        if (z2 && z3) {
            return new Tuples2<>(null, -1);
        }
        int iMax = Math.max(reverseIndexOf(charSequence, ' ', i), reverseIndexOf(charSequence, '\n', i)) + 1;
        String string = charSequence.subSequence(iMax, i).toString();
        return string.length() > 0 ? new Tuples2<>(string, Integer.valueOf(iMax)) : new Tuples2<>(null, -1);
    }

    private static final int reverseIndexOf(CharSequence charSequence, char c, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (charSequence.charAt(i2) == c) {
                return i2;
            }
        }
        return -1;
    }
}
