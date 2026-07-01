package com.discord.utilities.duration;

import android.content.Context;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.resources.StringResourceUtils;
import d0.a0.MathJVM;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.duration.DurationUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtils {
    private static final int FEW_SECONDS_BOUNDARY = 30;

    public static final CharSequence humanizeCountdownDuration(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "context");
        float f = j;
        int i = (int) (f / 86400000);
        int i2 = ((int) (f / 3600000)) % 24;
        int i3 = ((int) (f / 60000)) % 60;
        int iCoerceAtLeast = _Ranges.coerceAtLeast(((int) (f / 1000)) % 60, 1);
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append(FormatUtils.b(context, R.string.countdown_units_minutes, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
        sb.append(' ');
        sb.append(iCoerceAtLeast);
        sb.append(FormatUtils.b(context, R.string.countdown_units_seconds, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
        String string = sb.toString();
        if (i <= 0) {
            if (i2 <= 0) {
                return string;
            }
            return i2 + FormatUtils.b(context, R.string.countdown_units_hours, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) + ' ' + string;
        }
        return i + FormatUtils.b(context, R.string.countdown_units_days, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) + ' ' + i2 + FormatUtils.b(context, R.string.countdown_units_hours, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) + ' ' + string;
    }

    public static final CharSequence humanizeDuration(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (j <= 30000) {
            String string = context.getString(R.string.humanize_duration_a_few_seconds);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(\n     …ation_a_few_seconds\n    )");
            return string;
        }
        if (j <= 60000) {
            int i = (int) (j / 1000);
            return FormatUtils.b(context, R.string.humanize_duration_seconds, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_seconds_time, i, Integer.valueOf(i))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (j <= 3600000) {
            int i2 = (int) (j / 60000);
            return FormatUtils.b(context, R.string.humanize_duration_minutes, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_minutes_time, i2, Integer.valueOf(i2))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (j <= 86400000) {
            int i3 = (int) (j / 3600000);
            return FormatUtils.b(context, R.string.humanize_duration_hours, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_hours_time, i3, Integer.valueOf(i3))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        int i4 = (int) (j / 86400000);
        return FormatUtils.b(context, R.string.humanize_duration_days, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_days_time, i4, Integer.valueOf(i4))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }

    public static final CharSequence humanizeDurationRounded(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (j <= 30000) {
            String string = context.getString(R.string.humanize_duration_a_few_seconds);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(\n     …ation_a_few_seconds\n    )");
            return string;
        }
        double d = j;
        if (d <= 54000.0d) {
            float f = j / 1000;
            return FormatUtils.b(context, R.string.humanize_duration_seconds, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_seconds_time, MathJVM.roundToInt(f), Integer.valueOf(MathJVM.roundToInt(f)))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (d <= 3240000.0d) {
            float f2 = j / 60000;
            return FormatUtils.b(context, R.string.humanize_duration_minutes, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_minutes_time, MathJVM.roundToInt(f2), Integer.valueOf(MathJVM.roundToInt(f2)))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (d <= 7.776E7d) {
            float f3 = j / 3600000;
            return FormatUtils.b(context, R.string.humanize_duration_hours, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_hours_time, MathJVM.roundToInt(f3), Integer.valueOf(MathJVM.roundToInt(f3)))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        float f4 = j / 86400000;
        return FormatUtils.b(context, R.string.humanize_duration_days, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.humanize_duration_days_time, MathJVM.roundToInt(f4), Integer.valueOf(MathJVM.roundToInt(f4)))}, (4 & 4) != 0 ? FormatUtils.b.j : null);
    }
}
