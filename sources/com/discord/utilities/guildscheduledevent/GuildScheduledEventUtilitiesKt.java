package com.discord.utilities.guildscheduledevent;

import android.content.Context;
import android.text.format.DateUtils;
import b.a.k.b;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel;
import d0.z.d.m;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilitiesKt {
    public static final int DATE_FORMAT_FLAGS = 101139;

    public static final boolean canRsvp(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "$this$canRsvp");
        return (getEventTiming(guildScheduledEvent) == GuildScheduledEventTiming.LIVE || guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED) ? false : true;
    }

    public static final UserGuildMember getCreatorUserGuildMember(GuildScheduledEvent guildScheduledEvent, StoreGuilds storeGuilds, StoreUser storeUser) {
        m.checkNotNullParameter(guildScheduledEvent, "$this$getCreatorUserGuildMember");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeUser, "usersStore");
        Long creatorId = guildScheduledEvent.getCreatorId();
        if (creatorId == null) {
            return null;
        }
        long jLongValue = creatorId.longValue();
        User user = storeUser.getUsers(d0.t.m.listOf(Long.valueOf(jLongValue)), false).get(Long.valueOf(jLongValue));
        if (user != null) {
            return new UserGuildMember(user, storeGuilds.getMember(guildScheduledEvent.getGuildId(), jLongValue));
        }
        return null;
    }

    public static /* synthetic */ UserGuildMember getCreatorUserGuildMember$default(GuildScheduledEvent guildScheduledEvent, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        if ((i & 2) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return getCreatorUserGuildMember(guildScheduledEvent, storeGuilds, storeUser);
    }

    public static final CharSequence getEventEndingTimeString(Context context, long j, long j2, GuildScheduledEventStatus guildScheduledEventStatus) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guildScheduledEventStatus, "status");
        if (!isSameDay(j, j2)) {
            return null;
        }
        if (!DateUtils.isToday(j2)) {
            int iOrdinal = getEventTiming(j, guildScheduledEventStatus).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return DateUtils.formatDateTime(context, j2, DATE_FORMAT_FLAGS);
            }
            return null;
        }
        int iOrdinal2 = getEventTiming(j, guildScheduledEventStatus).ordinal();
        if (iOrdinal2 == 2 || iOrdinal2 == 3 || iOrdinal2 == 5) {
            return b.h(context, 2131888872, new Object[]{DateUtils.formatDateTime(context, j2, DATE_FORMAT_FLAGS)}, null, 4);
        }
        return null;
    }

    public static final CharSequence getEventStartingTimeString(GuildScheduledEvent guildScheduledEvent, Context context) {
        m.checkNotNullParameter(guildScheduledEvent, "$this$getEventStartingTimeString");
        m.checkNotNullParameter(context, "context");
        return getEventStartingTimeString(context, guildScheduledEvent.getScheduledStartTime().getDateTimeMillis(), guildScheduledEvent.getEntityType(), guildScheduledEvent.getStatus());
    }

    public static final GuildScheduledEventTiming getEventTiming(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "$this$getEventTiming");
        return getEventTiming(guildScheduledEvent.getScheduledStartTime().getDateTimeMillis(), guildScheduledEvent.getStatus());
    }

    public static final GuildScheduledEvent getLiveEvent(Collection<GuildScheduledEvent> collection) {
        Object next;
        m.checkNotNullParameter(collection, "$this$getLiveEvent");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (getEventTiming((GuildScheduledEvent) next) == GuildScheduledEventTiming.LIVE) {
                return (GuildScheduledEvent) next;
            }
        }
        next = null;
        return (GuildScheduledEvent) next;
    }

    private static final CharSequence getNonRelativeTimeString(long j, Context context) {
        String dateTime = DateUtils.formatDateTime(context, j, DATE_FORMAT_FLAGS);
        m.checkNotNullExpressionValue(dateTime, "DateUtils.formatDateTime… this, DATE_FORMAT_FLAGS)");
        return dateTime;
    }

    public static final boolean hasLiveEvent(Collection<GuildScheduledEvent> collection) {
        m.checkNotNullParameter(collection, "$this$hasLiveEvent");
        return getLiveEvent(collection) != null;
    }

    private static final boolean isSameDay(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        m.checkNotNullExpressionValue(calendar, "eventCalendar");
        calendar.setTimeInMillis(j);
        m.checkNotNullExpressionValue(calendar2, "nowCalendar");
        calendar2.setTimeInMillis(j2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static final int minutesRelativeToTime(long j) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int minutesFromMillis = timeUtils.getMinutesFromMillis(j - ClockFactory.get().currentTimeMillis());
        return minutesFromMillis != 0 ? minutesFromMillis : timeUtils.getMinutesFromMillis(ClockFactory.get().currentTimeMillis() - j) * (-1);
    }

    public static final CharSequence getEventStartingTimeString(Context context, long j, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventStatus guildScheduledEventStatus) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        m.checkNotNullParameter(guildScheduledEventStatus, "status");
        GuildScheduledEventTiming eventTiming = getEventTiming(j, guildScheduledEventStatus);
        Objects.requireNonNull(GuildScheduledEventStatus.Companion);
        if (GuildScheduledEventStatus.access$getDONE$cp().contains(guildScheduledEventStatus)) {
            return getNonRelativeTimeString(j, context);
        }
        switch (eventTiming.ordinal()) {
            case 1:
            case 2:
                return b.h(context, 2131890068, new Object[]{DateUtils.getRelativeTimeSpanString(j, ClockFactory.get().currentTimeMillis(), 86400000L), DateUtils.formatDateTime(context, j, DATE_FORMAT_FLAGS)}, null, 4);
            case 3:
                return b.h(context, 2131895907, new Object[]{Integer.valueOf(minutesRelativeToTime(j))}, null, 4);
            case 4:
            case 6:
                return b.h(context, 2131895908, new Object[0], null, 4);
            case 5:
                return guildScheduledEventEntityType.ordinal() != 3 ? b.h(context, 2131895796, new Object[0], null, 4) : b.h(context, 2131886232, new Object[0], null, 4);
            default:
                return getNonRelativeTimeString(j, context);
        }
    }

    public static final GuildScheduledEventTiming getEventTiming(long j, GuildScheduledEventStatus guildScheduledEventStatus) {
        m.checkNotNullParameter(guildScheduledEventStatus, "status");
        if (guildScheduledEventStatus == GuildScheduledEventStatus.ACTIVE) {
            return GuildScheduledEventTiming.LIVE;
        }
        int iMinutesRelativeToTime = minutesRelativeToTime(j);
        if (iMinutesRelativeToTime <= -60) {
            return GuildScheduledEventTiming.EXPIRED;
        }
        if (iMinutesRelativeToTime <= 0) {
            return GuildScheduledEventTiming.NOW;
        }
        if (iMinutesRelativeToTime <= 15) {
            return GuildScheduledEventTiming.SOON;
        }
        if (DateUtils.isToday(j)) {
            return GuildScheduledEventTiming.TODAY;
        }
        return DateUtils.isToday(j - 86400000) ? GuildScheduledEventTiming.TOMORROW : GuildScheduledEventTiming.LATER;
    }

    public static /* synthetic */ UserGuildMember getCreatorUserGuildMember$default(GuildScheduledEventModel guildScheduledEventModel, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        if ((i & 2) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return getCreatorUserGuildMember(guildScheduledEventModel, storeGuilds, storeUser);
    }

    public static final UserGuildMember getCreatorUserGuildMember(GuildScheduledEventModel guildScheduledEventModel, StoreGuilds storeGuilds, StoreUser storeUser) {
        m.checkNotNullParameter(guildScheduledEventModel, "$this$getCreatorUserGuildMember");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeUser, "usersStore");
        Long creatorId = guildScheduledEventModel.getCreatorId();
        if (creatorId == null) {
            return null;
        }
        long jLongValue = creatorId.longValue();
        User user = storeUser.getUsers(d0.t.m.listOf(Long.valueOf(jLongValue)), false).get(Long.valueOf(jLongValue));
        if (user != null) {
            return new UserGuildMember(user, storeGuilds.getMember(guildScheduledEventModel.getGuildId(), jLongValue));
        }
        return null;
    }
}
