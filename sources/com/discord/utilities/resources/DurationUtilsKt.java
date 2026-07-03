package com.discord.utilities.resources;

import android.content.Context;
import android.widget.TextView;
import com.discord.C5419R;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtilsKt {
    public static final CharSequence formatDuration(Context context, DurationUnit durationUnit, int i) {
        C12238m.checkNotNullParameter(context, "$this$formatDuration");
        C12238m.checkNotNullParameter(durationUnit, "unit");
        return C1107b.m210b(context, durationUnit.getStringRes(), new Object[]{StringResourceUtilsKt.getI18nPluralString(context, durationUnit.getQuantityPluralRes(), i, Integer.valueOf(i))}, (4 & 4) != 0 ? C1107b.b.f1491j : null);
    }

    public static final CharSequence formatInviteExpireAfterString(Context context, int i) {
        C12238m.checkNotNullParameter(context, "$this$formatInviteExpireAfterString");
        if (i == 0) {
            return C1107b.m210b(context, C5419R.string.no_user_limit, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
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
        throw new IllegalArgumentException(C1643a.m871q("Invalid expiration duration ", i));
    }

    public static final void setDurationText(TextView textView, DurationUnit durationUnit, int i) {
        C12238m.checkNotNullParameter(textView, "$this$setDurationText");
        C12238m.checkNotNullParameter(durationUnit, "unit");
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView.setText(formatDuration(context, durationUnit, i));
    }
}
