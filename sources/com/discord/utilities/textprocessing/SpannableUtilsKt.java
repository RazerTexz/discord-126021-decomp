package com.discord.utilities.textprocessing;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.annotation.AttrRes;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SpannableUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpannableUtilsKt {
    public static final void appendWithFont(SpannableStringBuilder spannableStringBuilder, Context context, @AttrRes int i, CharSequence charSequence) {
        C12238m.checkNotNullParameter(spannableStringBuilder, "$this$appendWithFont");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(context, i);
        if (themedFont != null) {
            appendWithSpan(spannableStringBuilder, new TypefaceSpanCompat(themedFont), charSequence);
        } else {
            spannableStringBuilder.append(charSequence);
        }
    }

    public static final void appendWithSpan(SpannableStringBuilder spannableStringBuilder, Object obj, CharSequence charSequence) {
        C12238m.checkNotNullParameter(spannableStringBuilder, "$this$appendWithSpan");
        C12238m.checkNotNullParameter(obj, "span");
        C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 33);
    }
}
