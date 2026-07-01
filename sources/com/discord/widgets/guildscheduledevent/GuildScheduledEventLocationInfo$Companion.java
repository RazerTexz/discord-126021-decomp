package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventLocationInfo$Companion {
    private GuildScheduledEventLocationInfo$Companion() {
    }

    public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEvent guildScheduledEvent, Channel channel) {
        String location;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        if (guildScheduledEvent.getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
            return new GuildScheduledEventLocationInfo$ChannelLocation(channel);
        }
        GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEvent.getEntityMetadata();
        if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
            location = "";
        }
        return new GuildScheduledEventLocationInfo$ExternalLocation(location);
    }

    public /* synthetic */ GuildScheduledEventLocationInfo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEventModel guildScheduledEventModel, Channel channel) {
        String location;
        m.checkNotNullParameter(guildScheduledEventModel, "guildScheduledEventModel");
        if (guildScheduledEventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
            GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEventModel.getEntityMetadata();
            if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
                location = "";
            }
            return new GuildScheduledEventLocationInfo$ExternalLocation(location);
        }
        return new GuildScheduledEventLocationInfo$ChannelLocation(channel);
    }
}
