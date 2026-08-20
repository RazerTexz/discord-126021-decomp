package com.discord.utilities.duration;

import android.content.Context;
import com.discord.C5419R;
import com.discord.utilities.resources.StringResourceUtilsKt;
import p007b.p008a.p027k.C1107b;
import p507d0.p508a0.C11210a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DurationUtilsKt {
    private static final int FEW_SECONDS_BOUNDARY = 30;

    public static final CharSequence humanizeCountdownDuration(Context context, long j) {
        C12238m.checkNotNullParameter(context, "context");
        float f = j;
        int i = (int) (f / 86400000);
        int i2 = ((int) (f / 3600000)) % 24;
        int i3 = ((int) (f / 60000)) % 60;
        int iCoerceAtLeast = C11226f.coerceAtLeast(((int) (f / 1000)) % 60, 1);
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append(C1107b.m216h(context, C5419R.string.countdown_units_minutes, new Object[0], null, 4));
        sb.append(' ');
        sb.append(iCoerceAtLeast);
        sb.append(C1107b.m216h(context, C5419R.string.countdown_units_seconds, new Object[0], null, 4));
        String string = sb.toString();
        if (i <= 0) {
            if (i2 <= 0) {
                return string;
            }
            return i2 + C1107b.m216h(context, C5419R.string.countdown_units_hours, new Object[0], null, 4) + ' ' + string;
        }
        return i + C1107b.m216h(context, C5419R.string.countdown_units_days, new Object[0], null, 4) + ' ' + i2 + C1107b.m216h(context, C5419R.string.countdown_units_hours, new Object[0], null, 4) + ' ' + string;
    }

    public static final CharSequence humanizeDuration(Context context, long j) {
        C12238m.checkNotNullParameter(context, "context");
        if (j <= 30000) {
            String string = context.getString(C5419R.string.humanize_duration_a_few_seconds);
            C12238m.checkNotNullExpressionValue(string, "context.getString(\n     …ation_a_few_seconds\n    )");
            return string;
        }
        if (j <= 60000) {
            int i = (int) (j / 1000);
            return C1107b.m216h(context, C5419R.string.humanize_duration_seconds, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_seconds_time, i, Integer.valueOf(i))}, null, 4);
        }
        if (j <= 3600000) {
            int i2 = (int) (j / 60000);
            return C1107b.m216h(context, C5419R.string.humanize_duration_minutes, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_minutes_time, i2, Integer.valueOf(i2))}, null, 4);
        }
        if (j <= 86400000) {
            int i3 = (int) (j / 3600000);
            return C1107b.m216h(context, C5419R.string.humanize_duration_hours, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_hours_time, i3, Integer.valueOf(i3))}, null, 4);
        }
        int i4 = (int) (j / 86400000);
        return C1107b.m216h(context, C5419R.string.humanize_duration_days, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_days_time, i4, Integer.valueOf(i4))}, null, 4);
    }

    public static final CharSequence humanizeDurationRounded(Context context, long j) {
        C12238m.checkNotNullParameter(context, "context");
        if (j <= 30000) {
            String string = context.getString(C5419R.string.humanize_duration_a_few_seconds);
            C12238m.checkNotNullExpressionValue(string, "context.getString(\n     …ation_a_few_seconds\n    )");
            return string;
        }
        double d = j;
        if (d <= 54000.0d) {
            float f = j / 1000;
            return C1107b.m216h(context, C5419R.string.humanize_duration_seconds, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_seconds_time, C11210a.roundToInt(f), Integer.valueOf(C11210a.roundToInt(f)))}, null, 4);
        }
        if (d <= 3240000.0d) {
            float f2 = j / 60000;
            return C1107b.m216h(context, C5419R.string.humanize_duration_minutes, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_minutes_time, C11210a.roundToInt(f2), Integer.valueOf(C11210a.roundToInt(f2)))}, null, 4);
        }
        if (d <= 7.776E7d) {
            float f3 = j / 3600000;
            return C1107b.m216h(context, C5419R.string.humanize_duration_hours, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_hours_time, C11210a.roundToInt(f3), Integer.valueOf(C11210a.roundToInt(f3)))}, null, 4);
        }
        float f4 = j / 86400000;
        return C1107b.m216h(context, C5419R.string.humanize_duration_days, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.humanize_duration_days_time, C11210a.roundToInt(f4), Integer.valueOf(C11210a.roundToInt(f4)))}, null, 4);
    }
}
