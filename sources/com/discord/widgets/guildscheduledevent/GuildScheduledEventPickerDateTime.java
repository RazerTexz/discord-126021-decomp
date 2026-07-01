package com.discord.widgets.guildscheduledevent;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.Tuples2;

/* JADX INFO: compiled from: GuildScheduledEventPickerDateTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventPickerDateTime {
    public static final GuildScheduledEventPickerDateTime INSTANCE = new GuildScheduledEventPickerDateTime();

    private GuildScheduledEventPickerDateTime() {
    }

    private final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> toGuildScheduledEventPickerDateTime(Calendar calendar) {
        return new Tuples2<>(new GuildScheduledEventPickerDateTime2(calendar.get(1), calendar.get(2), calendar.get(5)), new GuildScheduledEventPickerDateTime3(calendar.get(11), calendar.get(12), calendar.get(13)));
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> fromUtcDateTime(UtcDateTime utcDateTime) {
        Intrinsics3.checkNotNullParameter(utcDateTime, "utcDateTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(utcDateTime.getDateTimeMillis());
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…teTime.dateTimeMillis\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> generateAppropriateStartDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 2);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…endar.HOUR_OF_DAY, 2)\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> generateDefaultEndDateTime(GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        Calendar calendar = Calendar.getInstance();
        calendar.set(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), startTime.getHourOfDay(), startTime.getMinute(), startTime.getSecond());
        calendar.add(11, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…r.HOUR_OF_DAY, 1)\n      }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final long toMillis(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        Intrinsics3.checkNotNullParameter(date, "date");
        Intrinsics3.checkNotNullParameter(time, "time");
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getHourOfDay(), time.getMinute(), time.getSecond());
        calendar.clear(14);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…ndar.MILLISECOND)\n      }");
        return calendar.getTimeInMillis();
    }

    public final String toUtcDateString(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        Intrinsics3.checkNotNullParameter(date, "date");
        Intrinsics3.checkNotNullParameter(time, "time");
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(toMillis(date, time)), null, 2, null);
        Intrinsics3.checkNotNull(uTCDateTime$default);
        return uTCDateTime$default;
    }
}
