package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft extends StoreChannelsSelected$ResolvedSelectedChannel {
    private final Channel parentChannel;
    private final Long starterMessageId;
    private final String threadStartLocation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft(Channel channel, Long l, String str) {
        super(null);
        m.checkNotNullParameter(channel, "parentChannel");
        this.parentChannel = channel;
        this.starterMessageId = l;
        this.threadStartLocation = str;
    }

    public static /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft copy$default(StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, Channel channel, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.parentChannel;
        }
        if ((i & 2) != 0) {
            l = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.starterMessageId;
        }
        if ((i & 4) != 0) {
            str = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.threadStartLocation;
        }
        return storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.copy(channel, l, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getStarterMessageId() {
        return this.starterMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThreadStartLocation() {
        return this.threadStartLocation;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft copy(Channel parentChannel, Long starterMessageId, String threadStartLocation) {
        m.checkNotNullParameter(parentChannel, "parentChannel");
        return new StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft(parentChannel, starterMessageId, threadStartLocation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft)) {
            return false;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = (StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) other;
        return m.areEqual(this.parentChannel, storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.parentChannel) && m.areEqual(this.starterMessageId, storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.starterMessageId) && m.areEqual(this.threadStartLocation, storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.threadStartLocation);
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final Long getStarterMessageId() {
        return this.starterMessageId;
    }

    public final String getThreadStartLocation() {
        return this.threadStartLocation;
    }

    public final boolean hasStarterMessage() {
        return this.starterMessageId != null;
    }

    public int hashCode() {
        Channel channel = this.parentChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Long l = this.starterMessageId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.threadStartLocation;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadDraft(parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", starterMessageId=");
        sbU.append(this.starterMessageId);
        sbU.append(", threadStartLocation=");
        return a.J(sbU, this.threadStartLocation, ")");
    }
}
