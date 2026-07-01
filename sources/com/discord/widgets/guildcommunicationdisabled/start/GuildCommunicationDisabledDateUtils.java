package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;

/* JADX INFO: compiled from: GuildCommunicationDisabledDateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledDateUtils {
    public static final GuildCommunicationDisabledDateUtils INSTANCE = new GuildCommunicationDisabledDateUtils();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildCommunicationDisabledDateUtils2.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildCommunicationDisabledDateUtils2.SECONDS_60.ordinal()] = 1;
            iArr[GuildCommunicationDisabledDateUtils2.MINUTES_5.ordinal()] = 2;
            iArr[GuildCommunicationDisabledDateUtils2.MINUTES_10.ordinal()] = 3;
            iArr[GuildCommunicationDisabledDateUtils2.HOUR_1.ordinal()] = 4;
            iArr[GuildCommunicationDisabledDateUtils2.DAY_1.ordinal()] = 5;
            iArr[GuildCommunicationDisabledDateUtils2.WEEK_1.ordinal()] = 6;
        }
    }

    private GuildCommunicationDisabledDateUtils() {
    }

    public final CharSequence getFriendlyDurationString(Context context, GuildCommunicationDisabledDateUtils2 durationMs) {
        CharSequence i18nPluralString;
        CharSequence i18nPluralString2;
        CharSequence i18nPluralString3;
        CharSequence i18nPluralString4;
        CharSequence i18nPluralString5;
        CharSequence i18nPluralString6;
        Intrinsics3.checkNotNullParameter(durationMs, "durationMs");
        int iOrdinal = durationMs.ordinal();
        if (iOrdinal == 0) {
            return (context == null || (i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_seconds_capitalize_seconds, 60, 60)) == null) ? "60 Seconds" : i18nPluralString;
        }
        if (iOrdinal == 1) {
            return (context == null || (i18nPluralString2 = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_minutes_capitalize_minutes, 5, 5)) == null) ? "5 Minutes" : i18nPluralString2;
        }
        if (iOrdinal == 2) {
            return (context == null || (i18nPluralString3 = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_minutes_capitalize_minutes, 10, 10)) == null) ? "10 Minutes" : i18nPluralString3;
        }
        if (iOrdinal == 3) {
            return (context == null || (i18nPluralString4 = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_hours_capitalize_hours, 1, new Object[0])) == null) ? "1 Hour" : i18nPluralString4;
        }
        if (iOrdinal == 4) {
            return (context == null || (i18nPluralString5 = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_days_capitalize_days, 1, new Object[0])) == null) ? "1 Day" : i18nPluralString5;
        }
        if (iOrdinal == 5) {
            return (context == null || (i18nPluralString6 = StringResourceUtils.getI18nPluralString(context, R.plurals.duration_weeks_capitalize_weeks, 1, new Object[0])) == null) ? "1 Week" : i18nPluralString6;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Tuples2<String, Long> getFutureTimestamp(int durationMs) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, durationMs);
        Intrinsics3.checkNotNullExpressionValue(calendar, "date");
        long timeInMillis = calendar.getTimeInMillis();
        return new Tuples2<>(outline.w(TimeUtils.toUTCDateTime(Long.valueOf(timeInMillis), TimeUtils.UTCFormat.LONG), ".000Z"), Long.valueOf(timeInMillis));
    }
}
