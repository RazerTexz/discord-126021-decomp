package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventModel2 {
    public static final GuildScheduledEventModel toModel(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$toModel");
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> tuples2FromUtcDateTime = guildScheduledEventPickerDateTime.fromUtcDateTime(guildScheduledEvent.getScheduledStartTime());
        UtcDateTime scheduledEndTime = guildScheduledEvent.getScheduledEndTime();
        Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> tuples2FromUtcDateTime2 = scheduledEndTime != null ? guildScheduledEventPickerDateTime.fromUtcDateTime(scheduledEndTime) : null;
        return new GuildScheduledEventModel(guildScheduledEvent.getGuildId(), guildScheduledEvent.getName(), guildScheduledEvent.getChannelId(), guildScheduledEvent.getCreatorId(), tuples2FromUtcDateTime.getFirst(), tuples2FromUtcDateTime.getSecond(), tuples2FromUtcDateTime2 != null ? tuples2FromUtcDateTime2.getFirst() : null, tuples2FromUtcDateTime2 != null ? tuples2FromUtcDateTime2.getSecond() : null, guildScheduledEvent.getDescription(), guildScheduledEvent.getEntityType(), guildScheduledEvent.getEntityMetadata(), guildScheduledEvent.getUserCount(), null, 4096, null);
    }
}
