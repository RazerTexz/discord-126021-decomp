package com.discord.widgets.hubs.events;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubGuildScheduledEventData {
    private final boolean canConnect;
    private final boolean canShare;
    private final boolean canStartEvent;
    private final Channel channel;
    private final long directoryChannelId;
    private final GuildScheduledEvent event;
    private final boolean isConnected;
    private final boolean isInGuild;
    private final boolean isRsvped;

    public HubGuildScheduledEventData(long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        m.checkNotNullParameter(guildScheduledEvent, "event");
        this.directoryChannelId = j;
        this.event = guildScheduledEvent;
        this.channel = channel;
        this.isRsvped = z2;
        this.canShare = z3;
        this.canStartEvent = z4;
        this.canConnect = z5;
        this.isConnected = z6;
        this.isInGuild = z7;
    }

    public static /* synthetic */ HubGuildScheduledEventData copy$default(HubGuildScheduledEventData hubGuildScheduledEventData, long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        return hubGuildScheduledEventData.copy((i & 1) != 0 ? hubGuildScheduledEventData.directoryChannelId : j, (i & 2) != 0 ? hubGuildScheduledEventData.event : guildScheduledEvent, (i & 4) != 0 ? hubGuildScheduledEventData.channel : channel, (i & 8) != 0 ? hubGuildScheduledEventData.isRsvped : z2, (i & 16) != 0 ? hubGuildScheduledEventData.canShare : z3, (i & 32) != 0 ? hubGuildScheduledEventData.canStartEvent : z4, (i & 64) != 0 ? hubGuildScheduledEventData.canConnect : z5, (i & 128) != 0 ? hubGuildScheduledEventData.isConnected : z6, (i & 256) != 0 ? hubGuildScheduledEventData.isInGuild : z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    public final HubGuildScheduledEventData copy(long directoryChannelId, GuildScheduledEvent event, Channel channel, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean canConnect, boolean isConnected, boolean isInGuild) {
        m.checkNotNullParameter(event, "event");
        return new HubGuildScheduledEventData(directoryChannelId, event, channel, isRsvped, canShare, canStartEvent, canConnect, isConnected, isInGuild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubGuildScheduledEventData)) {
            return false;
        }
        HubGuildScheduledEventData hubGuildScheduledEventData = (HubGuildScheduledEventData) other;
        return this.directoryChannelId == hubGuildScheduledEventData.directoryChannelId && m.areEqual(this.event, hubGuildScheduledEventData.event) && m.areEqual(this.channel, hubGuildScheduledEventData.channel) && this.isRsvped == hubGuildScheduledEventData.isRsvped && this.canShare == hubGuildScheduledEventData.canShare && this.canStartEvent == hubGuildScheduledEventData.canStartEvent && this.canConnect == hubGuildScheduledEventData.canConnect && this.isConnected == hubGuildScheduledEventData.isConnected && this.isInGuild == hubGuildScheduledEventData.isInGuild;
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iA = b.a(this.directoryChannelId) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        int iHashCode = (iA + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isRsvped;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.canShare;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canStartEvent;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canConnect;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isConnected;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.isInGuild;
        return i5 + (z7 ? 1 : z7);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbU = a.U("HubGuildScheduledEventData(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", event=");
        sbU.append(this.event);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", canShare=");
        sbU.append(this.canShare);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", isInGuild=");
        return a.O(sbU, this.isInGuild, ")");
    }
}
