package com.discord.utilities.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import java.util.Comparator;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventsComparator implements Comparator<GuildScheduledEvent> {
    public static final GuildScheduledEventsComparator INSTANCE = new GuildScheduledEventsComparator();

    private GuildScheduledEventsComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2) {
        return compare2(guildScheduledEvent, guildScheduledEvent2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    /* JADX WARN: Code duplicated, block: B:15:0x0022  */
    /* JADX WARN: Code duplicated, block: B:17:0x0025 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    /* JADX WARN: Code duplicated, block: B:26:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(GuildScheduledEvent o1, GuildScheduledEvent o2) {
        GuildScheduledEventStatus status;
        GuildScheduledEventStatus status2 = o1 != null ? o1.getStatus() : null;
        GuildScheduledEventStatus guildScheduledEventStatus = GuildScheduledEventStatus.ACTIVE;
        if (status2 != guildScheduledEventStatus) {
            if (o1 != null) {
                status = o1.getStatus();
            } else {
                status = null;
            }
            if (status != guildScheduledEventStatus) {
                if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
                    return 1;
                }
            }
            if (o1 == null && o2 != null) {
                return o1.getScheduledStartTime().f(o2.getScheduledStartTime());
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return 0;
            }
        } else {
            if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
                if (o1 != null) {
                    status = o1.getStatus();
                } else {
                    status = null;
                }
                if (status != guildScheduledEventStatus) {
                    if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
                        return 1;
                    }
                }
                if (o1 == null) {
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return 0;
                }
            }
        }
        return -1;
    }
}
