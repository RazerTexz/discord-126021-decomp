package com.discord.utilities.resources;

import android.content.Context;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtilsKt {
    public static final CharSequence formatDuration(Context context, DurationUnit durationUnit, int i) {
        m.checkNotNullParameter(context, "$this$formatDuration");
        m.checkNotNullParameter(durationUnit, "unit");
        return b.h(context, durationUnit.getStringRes(), new Object[]{StringResourceUtilsKt.getI18nPluralString(context, durationUnit.getQuantityPluralRes(), i, Integer.valueOf(i))}, null, 4);
    }

    public static final CharSequence formatInviteExpireAfterString(Context context, int i) {
        m.checkNotNullParameter(context, "$this$formatInviteExpireAfterString");
        if (i == 0) {
            return b.h(context, 2131893290, new Object[0], null, 4);
        }
        if (i == 1800) {
            return formatDuration(context, DurationUnit.MINS, 30);
        }
        if (i == 3600) {
            return formatDuration(context, DurationUnit.HOURS, 1);
        }
        if (i == 21600) {
            return formatDuration(context, DurationUnit.HOURS, 6);
        }
        if (i == 43200) {
            return formatDuration(context, DurationUnit.HOURS, 12);
        }
        if (i == 86400) {
            return formatDuration(context, DurationUnit.DAYS, 1);
        }
        if (i == 604800) {
            return formatDuration(context, DurationUnit.DAYS, 7);
        }
        throw new IllegalArgumentException(a.q("Invalid expiration duration ", i));
    }

    public static final void setDurationText(TextView textView, DurationUnit durationUnit, int i) {
        m.checkNotNullParameter(textView, "$this$setDurationText");
        m.checkNotNullParameter(durationUnit, "unit");
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView.setText(formatDuration(context, durationUnit, i));
    }
}
