package com.discord.widgets.guildscheduledevent;

import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildScheduledEventLocationInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
    public static final /* data */ class ChannelLocation extends GuildScheduledEventLocationInfo {
        private final Channel channel;

        public ChannelLocation(Channel channel) {
            super(null);
            this.channel = channel;
        }

        public static /* synthetic */ ChannelLocation copy$default(ChannelLocation channelLocation, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelLocation.channel;
            }
            return channelLocation.copy(channel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelLocation copy(Channel channel) {
            return new ChannelLocation(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelLocation) && C12238m.areEqual(this.channel, ((ChannelLocation) other).channel);
            }
            return true;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public int hashCode() {
            Channel channel = this.channel;
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelLocation(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEvent guildScheduledEvent, Channel channel) {
            String location;
            C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            if (guildScheduledEvent.getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
                return new ChannelLocation(channel);
            }
            GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEvent.getEntityMetadata();
            if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
                location = "";
            }
            return new ExternalLocation(location);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GuildScheduledEventLocationInfo buildLocationInfo(GuildScheduledEventModel guildScheduledEventModel, Channel channel) {
            String location;
            C12238m.checkNotNullParameter(guildScheduledEventModel, "guildScheduledEventModel");
            if (guildScheduledEventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
                GuildScheduledEventEntityMetadata entityMetadata = guildScheduledEventModel.getEntityMetadata();
                if (entityMetadata == null || (location = entityMetadata.getLocation()) == null) {
                    location = "";
                }
                return new ExternalLocation(location);
            }
            return new ChannelLocation(channel);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventLocationInfo.kt */
    public static final /* data */ class ExternalLocation extends GuildScheduledEventLocationInfo {
        private final String location;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExternalLocation(String str) {
            super(null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            this.location = str;
        }

        public static /* synthetic */ ExternalLocation copy$default(ExternalLocation externalLocation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalLocation.location;
            }
            return externalLocation.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        public final ExternalLocation copy(String location) {
            C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return new ExternalLocation(location);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ExternalLocation) && C12238m.areEqual(this.location, ((ExternalLocation) other).location);
            }
            return true;
        }

        public final String getLocation() {
            return this.location;
        }

        public int hashCode() {
            String str = this.location;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("ExternalLocation(location="), this.location, ")");
        }
    }

    private GuildScheduledEventLocationInfo() {
    }

    @DrawableRes
    private final int getChannelIcon(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? C5419R.drawable.ic_channel_voice : C5419R.drawable.ic_stage_20dp;
    }

    @DrawableRes
    private final int getChannelIconSmall(Channel channel) {
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        return ((numValueOf != null && numValueOf.intValue() == 2) || numValueOf == null || numValueOf.intValue() != 13) ? C5419R.drawable.ic_channel_voice_16dp : C5419R.drawable.ic_channel_stage_16dp;
    }

    @DrawableRes
    public final int getLocationIcon() {
        if (this instanceof ChannelLocation) {
            return getChannelIcon(((ChannelLocation) this).getChannel());
        }
        if (this instanceof ExternalLocation) {
            return C5419R.drawable.ic_location_24dp;
        }
        throw new NoWhenBranchMatchedException();
    }

    @DrawableRes
    public final int getLocationIconSmall() {
        if (this instanceof ChannelLocation) {
            return getChannelIconSmall(((ChannelLocation) this).getChannel());
        }
        if (this instanceof ExternalLocation) {
            return C5419R.drawable.ic_location_16dp;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getLocationName() {
        String name;
        if (this instanceof ChannelLocation) {
            Channel channel = ((ChannelLocation) this).getChannel();
            return (channel == null || (name = channel.getName()) == null) ? "" : name;
        }
        if (this instanceof ExternalLocation) {
            return ((ExternalLocation) this).getLocation();
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ GuildScheduledEventLocationInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
