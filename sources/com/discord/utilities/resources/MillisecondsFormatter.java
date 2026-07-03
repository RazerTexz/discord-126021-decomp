package com.discord.utilities.resources;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Pair;
import p507d0.C12116o;
import p507d0.p508a0.C11210a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MillisecondsFormatter {
    public static final MillisecondsFormatter INSTANCE = new MillisecondsFormatter();
    private static final long MS_IN_DAY = 86400000;
    private static final long MS_IN_HOUR = 3600000;
    private static final long MS_IN_MINUTE = 60000;
    private static final long MS_IN_MONTH = 2592000000L;
    private static final long MS_IN_WEEK = 604800000;

    private MillisecondsFormatter() {
    }

    public final CharSequence formatDurationInMillis(Context context, long j) {
        Pair pairM10073to;
        C12238m.checkNotNullParameter(context, "$this$formatDurationInMillis");
        if (2592000000L <= j && RecyclerView.FOREVER_NS >= j) {
            pairM10073to = C12116o.m10073to(DurationUnit.MONTHS, 2592000000L);
        } else if (MS_IN_WEEK <= j && 2592000000L >= j) {
            pairM10073to = C12116o.m10073to(DurationUnit.WEEKS, Long.valueOf(MS_IN_WEEK));
        } else if (MS_IN_DAY <= j && MS_IN_WEEK >= j) {
            pairM10073to = C12116o.m10073to(DurationUnit.DAYS, Long.valueOf(MS_IN_DAY));
        } else {
            pairM10073to = (MS_IN_HOUR <= j && MS_IN_DAY >= j) ? C12116o.m10073to(DurationUnit.HOURS, Long.valueOf(MS_IN_HOUR)) : C12116o.m10073to(DurationUnit.MINUTES, 60000L);
        }
        return DurationUtilsKt.formatDuration(context, (DurationUnit) pairM10073to.component1(), C11210a.roundToInt(j / ((Number) pairM10073to.component2()).longValue()));
    }
}
