package com.discord.utilities.resources;

import android.content.Context;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.resources.DurationUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtils3 {
    public static final CharSequence formatDuration(Context context, DurationUtils2 durationUtils2, int i) {
        Intrinsics3.checkNotNullParameter(context, "$this$formatDuration");
        Intrinsics3.checkNotNullParameter(durationUtils2, "unit");
        return FormatUtils.b(context, durationUtils2.getStringRes(), new Object[]{StringResourceUtils.getI18nPluralString(context, durationUtils2.getQuantityPluralRes(), i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    public static final CharSequence formatInviteExpireAfterString(Context context, int i) {
        Intrinsics3.checkNotNullParameter(context, "$this$formatInviteExpireAfterString");
        if (i == 0) {
            return FormatUtils.b(context, R.string.no_user_limit, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (i == 1800) {
            return formatDuration(context, DurationUtils2.MINS, 30);
        }
        if (i == 3600) {
            return formatDuration(context, DurationUtils2.HOURS, 1);
        }
        if (i == 21600) {
            return formatDuration(context, DurationUtils2.HOURS, 6);
        }
        if (i == 43200) {
            return formatDuration(context, DurationUtils2.HOURS, 12);
        }
        if (i == 86400) {
            return formatDuration(context, DurationUtils2.DAYS, 1);
        }
        if (i == 604800) {
            return formatDuration(context, DurationUtils2.DAYS, 7);
        }
        throw new IllegalArgumentException(outline.q("Invalid expiration duration ", i));
    }

    public static final void setDurationText(TextView textView, DurationUtils2 durationUtils2, int i) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setDurationText");
        Intrinsics3.checkNotNullParameter(durationUtils2, "unit");
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(formatDuration(context, durationUtils2, i));
    }
}
