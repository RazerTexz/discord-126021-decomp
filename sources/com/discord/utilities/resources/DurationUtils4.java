package com.discord.utilities.resources;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: com.discord.utilities.resources.MillisecondsFormatter, reason: use source file name */
/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtils4 {
    public static final DurationUtils4 INSTANCE = new DurationUtils4();
    private static final long MS_IN_DAY = 86400000;
    private static final long MS_IN_HOUR = 3600000;
    private static final long MS_IN_MINUTE = 60000;
    private static final long MS_IN_MONTH = 2592000000L;
    private static final long MS_IN_WEEK = 604800000;

    private DurationUtils4() {
    }

    public final CharSequence formatDurationInMillis(Context context, long j) {
        Tuples2 tuples2;
        Intrinsics3.checkNotNullParameter(context, "$this$formatDurationInMillis");
        if (2592000000L <= j && RecyclerView.FOREVER_NS >= j) {
            tuples2 = Tuples.to(DurationUtils2.MONTHS, 2592000000L);
        } else if (MS_IN_WEEK <= j && 2592000000L >= j) {
            tuples2 = Tuples.to(DurationUtils2.WEEKS, Long.valueOf(MS_IN_WEEK));
        } else if (MS_IN_DAY <= j && MS_IN_WEEK >= j) {
            tuples2 = Tuples.to(DurationUtils2.DAYS, Long.valueOf(MS_IN_DAY));
        } else {
            tuples2 = (MS_IN_HOUR <= j && MS_IN_DAY >= j) ? Tuples.to(DurationUtils2.HOURS, Long.valueOf(MS_IN_HOUR)) : Tuples.to(DurationUtils2.MINUTES, 60000L);
        }
        return DurationUtils3.formatDuration(context, (DurationUtils2) tuples2.component1(), MathJVM.roundToInt(j / ((Number) tuples2.component2()).longValue()));
    }
}
