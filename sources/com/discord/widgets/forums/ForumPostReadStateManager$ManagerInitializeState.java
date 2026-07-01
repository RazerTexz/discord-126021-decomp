package com.discord.widgets.forums;

import b.d.b.a.a;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreMessageAck$Ack;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ForumPostReadStateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ForumPostReadStateManager$ManagerInitializeState {
    private final Map<Long, StoreMessageAck$Ack> messageAcks;
    private final StoreChannelsSelected$ResolvedSelectedChannel resolvedSelectedChannel;
    private final Set<Long> threadSyncedGuilds;

    public ForumPostReadStateManager$ManagerInitializeState(Map<Long, StoreMessageAck$Ack> map, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Set<Long> set) {
        m.checkNotNullParameter(map, "messageAcks");
        m.checkNotNullParameter(storeChannelsSelected$ResolvedSelectedChannel, "resolvedSelectedChannel");
        m.checkNotNullParameter(set, "threadSyncedGuilds");
        this.messageAcks = map;
        this.resolvedSelectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
        this.threadSyncedGuilds = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForumPostReadStateManager$ManagerInitializeState copy$default(ForumPostReadStateManager$ManagerInitializeState forumPostReadStateManager$ManagerInitializeState, Map map, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            map = forumPostReadStateManager$ManagerInitializeState.messageAcks;
        }
        if ((i & 2) != 0) {
            storeChannelsSelected$ResolvedSelectedChannel = forumPostReadStateManager$ManagerInitializeState.resolvedSelectedChannel;
        }
        if ((i & 4) != 0) {
            set = forumPostReadStateManager$ManagerInitializeState.threadSyncedGuilds;
        }
        return forumPostReadStateManager$ManagerInitializeState.copy(map, storeChannelsSelected$ResolvedSelectedChannel, set);
    }

    public final Map<Long, StoreMessageAck$Ack> component1() {
        return this.messageAcks;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreChannelsSelected$ResolvedSelectedChannel getResolvedSelectedChannel() {
        return this.resolvedSelectedChannel;
    }

    public final Set<Long> component3() {
        return this.threadSyncedGuilds;
    }

    public final ForumPostReadStateManager$ManagerInitializeState copy(Map<Long, StoreMessageAck$Ack> messageAcks, StoreChannelsSelected$ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> threadSyncedGuilds) {
        m.checkNotNullParameter(messageAcks, "messageAcks");
        m.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
        m.checkNotNullParameter(threadSyncedGuilds, "threadSyncedGuilds");
        return new ForumPostReadStateManager$ManagerInitializeState(messageAcks, resolvedSelectedChannel, threadSyncedGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumPostReadStateManager$ManagerInitializeState)) {
            return false;
        }
        ForumPostReadStateManager$ManagerInitializeState forumPostReadStateManager$ManagerInitializeState = (ForumPostReadStateManager$ManagerInitializeState) other;
        return m.areEqual(this.messageAcks, forumPostReadStateManager$ManagerInitializeState.messageAcks) && m.areEqual(this.resolvedSelectedChannel, forumPostReadStateManager$ManagerInitializeState.resolvedSelectedChannel) && m.areEqual(this.threadSyncedGuilds, forumPostReadStateManager$ManagerInitializeState.threadSyncedGuilds);
    }

    public final Map<Long, StoreMessageAck$Ack> getMessageAcks() {
        return this.messageAcks;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel getResolvedSelectedChannel() {
        return this.resolvedSelectedChannel;
    }

    public final Set<Long> getThreadSyncedGuilds() {
        return this.threadSyncedGuilds;
    }

    public int hashCode() {
        Map<Long, StoreMessageAck$Ack> map = this.messageAcks;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.resolvedSelectedChannel;
        int iHashCode2 = (iHashCode + (storeChannelsSelected$ResolvedSelectedChannel != null ? storeChannelsSelected$ResolvedSelectedChannel.hashCode() : 0)) * 31;
        Set<Long> set = this.threadSyncedGuilds;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ManagerInitializeState(messageAcks=");
        sbU.append(this.messageAcks);
        sbU.append(", resolvedSelectedChannel=");
        sbU.append(this.resolvedSelectedChannel);
        sbU.append(", threadSyncedGuilds=");
        return a.N(sbU, this.threadSyncedGuilds, ")");
    }
}
