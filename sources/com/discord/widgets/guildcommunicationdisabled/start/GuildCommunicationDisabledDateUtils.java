package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.d.b.a.a;
import com.discord.R$plurals;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import d0.z.d.m;
import java.util.Calendar;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

/* JADX INFO: compiled from: GuildCommunicationDisabledDateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledDateUtils {
    public static final GuildCommunicationDisabledDateUtils INSTANCE = new GuildCommunicationDisabledDateUtils();

    private GuildCommunicationDisabledDateUtils() {
    }

    public final CharSequence getFriendlyDurationString(Context context, TimeDurationDisabledCommunication durationMs) {
        CharSequence i18nPluralString;
        CharSequence i18nPluralString2;
        CharSequence i18nPluralString3;
        CharSequence i18nPluralString4;
        CharSequence i18nPluralString5;
        CharSequence i18nPluralString6;
        m.checkNotNullParameter(durationMs, "durationMs");
        int iOrdinal = durationMs.ordinal();
        if (iOrdinal == 0) {
            return (context == null || (i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_seconds_capitalize_seconds, 60, 60)) == null) ? "60 Seconds" : i18nPluralString;
        }
        if (iOrdinal == 1) {
            return (context == null || (i18nPluralString2 = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_minutes_capitalize_minutes, 5, 5)) == null) ? "5 Minutes" : i18nPluralString2;
        }
        if (iOrdinal == 2) {
            return (context == null || (i18nPluralString3 = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_minutes_capitalize_minutes, 10, 10)) == null) ? "10 Minutes" : i18nPluralString3;
        }
        if (iOrdinal == 3) {
            return (context == null || (i18nPluralString4 = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_hours_capitalize_hours, 1, new Object[0])) == null) ? "1 Hour" : i18nPluralString4;
        }
        if (iOrdinal == 4) {
            return (context == null || (i18nPluralString5 = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_days_capitalize_days, 1, new Object[0])) == null) ? "1 Day" : i18nPluralString5;
        }
        if (iOrdinal == 5) {
            return (context == null || (i18nPluralString6 = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.duration_weeks_capitalize_weeks, 1, new Object[0])) == null) ? "1 Week" : i18nPluralString6;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Pair<String, Long> getFutureTimestamp(int durationMs) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, durationMs);
        m.checkNotNullExpressionValue(calendar, "date");
        long timeInMillis = calendar.getTimeInMillis();
        return new Pair<>(a.w(TimeUtils.toUTCDateTime(Long.valueOf(timeInMillis), TimeUtils$UTCFormat.LONG), ".000Z"), Long.valueOf(timeInMillis));
    }
}
