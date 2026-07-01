package com.discord.widgets.guildscheduledevent;

import androidx.annotation.DrawableRes;
import com.discord.api.channel.Channel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildScheduledEventLocationInfo {
    public static final GuildScheduledEventLocationInfo$Companion Companion = new GuildScheduledEventLocationInfo$Companion(null);

    private GuildScheduledEventLocationInfo() {
    }

    @DrawableRes
    private final int getChannelIcon(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? 2131231639 : 2131232147;
    }

    @DrawableRes
    private final int getChannelIconSmall(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? 2131231640 : 2131231624;
    }

    @DrawableRes
    public final int getLocationIcon() {
        if (this instanceof GuildScheduledEventLocationInfo$ChannelLocation) {
            return getChannelIcon(((GuildScheduledEventLocationInfo$ChannelLocation) this).getChannel());
        }
        if (this instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            return 2131231901;
        }
        throw new NoWhenBranchMatchedException();
    }

    @DrawableRes
    public final int getLocationIconSmall() {
        if (this instanceof GuildScheduledEventLocationInfo$ChannelLocation) {
            return getChannelIconSmall(((GuildScheduledEventLocationInfo$ChannelLocation) this).getChannel());
        }
        if (this instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            return 2131231900;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getLocationName() {
        String name;
        if (this instanceof GuildScheduledEventLocationInfo$ChannelLocation) {
            Channel channel = ((GuildScheduledEventLocationInfo$ChannelLocation) this).getChannel();
            return (channel == null || (name = channel.getName()) == null) ? "" : name;
        }
        if (this instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            return ((GuildScheduledEventLocationInfo$ExternalLocation) this).getLocation();
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ GuildScheduledEventLocationInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
