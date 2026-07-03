package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventModelKt {
    public static final GuildScheduledEventModel toModel(GuildScheduledEvent guildScheduledEvent) {
        C12238m.checkNotNullParameter(guildScheduledEvent, "$this$toModel");
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> pairFromUtcDateTime = guildScheduledEventPickerDateTime.fromUtcDateTime(guildScheduledEvent.getScheduledStartTime());
        UtcDateTime scheduledEndTime = guildScheduledEvent.getScheduledEndTime();
        Pair<GuildScheduledEventPickerDate, GuildScheduledEventPickerTime> pairFromUtcDateTime2 = scheduledEndTime != null ? guildScheduledEventPickerDateTime.fromUtcDateTime(scheduledEndTime) : null;
        return new GuildScheduledEventModel(guildScheduledEvent.getGuildId(), guildScheduledEvent.getName(), guildScheduledEvent.getChannelId(), guildScheduledEvent.getCreatorId(), pairFromUtcDateTime.getFirst(), pairFromUtcDateTime.getSecond(), pairFromUtcDateTime2 != null ? pairFromUtcDateTime2.getFirst() : null, pairFromUtcDateTime2 != null ? pairFromUtcDateTime2.getSecond() : null, guildScheduledEvent.getDescription(), guildScheduledEvent.getEntityType(), guildScheduledEvent.getEntityMetadata(), guildScheduledEvent.getUserCount(), null, 4096, null);
    }
}
