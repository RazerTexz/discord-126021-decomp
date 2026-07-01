package com.discord.utilities.textprocessing;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.annotation.AttrRes;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.SpannableUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: SpannableUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpannableUtils {
    public static final void appendWithFont(SpannableStringBuilder spannableStringBuilder, Context context, @AttrRes int i, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "$this$appendWithFont");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(context, i);
        if (themedFont != null) {
            appendWithSpan(spannableStringBuilder, new TypefaceSpanCompat(themedFont), charSequence);
        } else {
            spannableStringBuilder.append(charSequence);
        }
    }

    public static final void appendWithSpan(SpannableStringBuilder spannableStringBuilder, Object obj, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "$this$appendWithSpan");
        Intrinsics3.checkNotNullParameter(obj, "span");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 33);
    }
}
