package com.discord.widgets.hubs.events;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(guildScheduledEvent, "event");
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
        C12238m.checkNotNullParameter(event, "event");
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
        return this.directoryChannelId == hubGuildScheduledEventData.directoryChannelId && C12238m.areEqual(this.event, hubGuildScheduledEventData.event) && C12238m.areEqual(this.channel, hubGuildScheduledEventData.channel) && this.isRsvped == hubGuildScheduledEventData.isRsvped && this.canShare == hubGuildScheduledEventData.canShare && this.canStartEvent == hubGuildScheduledEventData.canStartEvent && this.canConnect == hubGuildScheduledEventData.canConnect && this.isConnected == hubGuildScheduledEventData.isConnected && this.isInGuild == hubGuildScheduledEventData.isInGuild;
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
        int iM3a = C0002b.m3a(this.directoryChannelId) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        int iHashCode = (iM3a + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
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
        StringBuilder sbM833U = C1643a.m833U("HubGuildScheduledEventData(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", event=");
        sbM833U.append(this.event);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", isRsvped=");
        sbM833U.append(this.isRsvped);
        sbM833U.append(", canShare=");
        sbM833U.append(this.canShare);
        sbM833U.append(", canStartEvent=");
        sbM833U.append(this.canStartEvent);
        sbM833U.append(", canConnect=");
        sbM833U.append(this.canConnect);
        sbM833U.append(", isConnected=");
        sbM833U.append(this.isConnected);
        sbM833U.append(", isInGuild=");
        return C1643a.m827O(sbM833U, this.isInGuild, ")");
    }
}
