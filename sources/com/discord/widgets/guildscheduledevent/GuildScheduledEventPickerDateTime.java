package com.discord.widgets.guildscheduledevent;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.utilities.time.TimeUtils;
import java.util.Calendar;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventPickerDateTime {
    public static final GuildScheduledEventPickerDateTime INSTANCE = new GuildScheduledEventPickerDateTime();

    private GuildScheduledEventPickerDateTime() {
    }

    private final Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> toGuildScheduledEventPickerDateTime(Calendar calendar) {
        return new Pair<>(new GuildScheduledEventPickerDate(calendar.get(1), calendar.get(2), calendar.get(5)), new GuildScheduledEventPickerTime(calendar.get(11), calendar.get(12), calendar.get(13)));
    }

    public final Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> fromUtcDateTime(UtcDateTime utcDateTime) {
        C12238m.checkNotNullParameter(utcDateTime, "utcDateTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(utcDateTime.getDateTimeMillis());
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…teTime.dateTimeMillis\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> generateAppropriateStartDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 2);
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…endar.HOUR_OF_DAY, 2)\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> generateDefaultEndDateTime(GuildScheduledEventPickerDate startDate, GuildScheduledEventPickerTime startTime) {
        C12238m.checkNotNullParameter(startDate, "startDate");
        C12238m.checkNotNullParameter(startTime, "startTime");
        Calendar calendar = Calendar.getInstance();
        calendar.set(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), startTime.getHourOfDay(), startTime.getMinute(), startTime.getSecond());
        calendar.add(11, 1);
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…r.HOUR_OF_DAY, 1)\n      }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final long toMillis(GuildScheduledEventPickerDate date, GuildScheduledEventPickerTime time) {
        C12238m.checkNotNullParameter(date, "date");
        C12238m.checkNotNullParameter(time, "time");
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getHourOfDay(), time.getMinute(), time.getSecond());
        calendar.clear(14);
        C12238m.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…ndar.MILLISECOND)\n      }");
        return calendar.getTimeInMillis();
    }

    public final String toUtcDateString(GuildScheduledEventPickerDate date, GuildScheduledEventPickerTime time) {
        C12238m.checkNotNullParameter(date, "date");
        C12238m.checkNotNullParameter(time, "time");
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(toMillis(date, time)), null, 2, null);
        C12238m.checkNotNull(uTCDateTime$default);
        return uTCDateTime$default;
    }
}
