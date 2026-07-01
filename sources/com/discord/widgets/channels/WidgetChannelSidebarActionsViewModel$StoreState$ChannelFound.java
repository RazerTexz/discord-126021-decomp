package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound extends WidgetChannelSidebarActionsViewModel$StoreState {
    private final Channel channel;
    private final boolean disablePins;
    private final ModelNotificationSettings guildNotificationSettings;
    private final Channel parentChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound(Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.parentChannel = channel2;
        this.guildNotificationSettings = modelNotificationSettings;
        this.disablePins = z2;
    }

    public static /* synthetic */ WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound copy$default(WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound widgetChannelSidebarActionsViewModel$StoreState$ChannelFound, Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.channel;
        }
        if ((i & 2) != 0) {
            channel2 = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.parentChannel;
        }
        if ((i & 4) != 0) {
            modelNotificationSettings = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.guildNotificationSettings;
        }
        if ((i & 8) != 0) {
            z2 = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.disablePins;
        }
        return widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.copy(channel, channel2, modelNotificationSettings, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelNotificationSettings getGuildNotificationSettings() {
        return this.guildNotificationSettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getDisablePins() {
        return this.disablePins;
    }

    public final WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound copy(Channel channel, Channel parentChannel, ModelNotificationSettings guildNotificationSettings, boolean disablePins) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound(channel, parentChannel, guildNotificationSettings, disablePins);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound)) {
            return false;
        }
        WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound widgetChannelSidebarActionsViewModel$StoreState$ChannelFound = (WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound) other;
        return m.areEqual(this.channel, widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.channel) && m.areEqual(this.parentChannel, widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.parentChannel) && m.areEqual(this.guildNotificationSettings, widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.guildNotificationSettings) && this.disablePins == widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.disablePins;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getDisablePins() {
        return this.disablePins;
    }

    public final ModelNotificationSettings getGuildNotificationSettings() {
        return this.guildNotificationSettings;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
        int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        boolean z2 = this.disablePins;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelFound(channel=");
        sbU.append(this.channel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", guildNotificationSettings=");
        sbU.append(this.guildNotificationSettings);
        sbU.append(", disablePins=");
        return a.O(sbU, this.disablePins, ")");
    }
}
