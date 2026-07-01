package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationInteractions$SentInteraction {
    private final long channelId;
    private final Long guildId;
    private final Long messageId;
    private StoreApplicationInteractions$SentInteractionState state;

    public StoreApplicationInteractions$SentInteraction(long j, Long l, Long l2, StoreApplicationInteractions$SentInteractionState storeApplicationInteractions$SentInteractionState) {
        m.checkNotNullParameter(storeApplicationInteractions$SentInteractionState, "state");
        this.channelId = j;
        this.messageId = l;
        this.guildId = l2;
        this.state = storeApplicationInteractions$SentInteractionState;
    }

    public static /* synthetic */ StoreApplicationInteractions$SentInteraction copy$default(StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction, long j, Long l, Long l2, StoreApplicationInteractions$SentInteractionState storeApplicationInteractions$SentInteractionState, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeApplicationInteractions$SentInteraction.channelId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            l = storeApplicationInteractions$SentInteraction.messageId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = storeApplicationInteractions$SentInteraction.guildId;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            storeApplicationInteractions$SentInteractionState = storeApplicationInteractions$SentInteraction.state;
        }
        return storeApplicationInteractions$SentInteraction.copy(j2, l3, l4, storeApplicationInteractions$SentInteractionState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreApplicationInteractions$SentInteractionState getState() {
        return this.state;
    }

    public final StoreApplicationInteractions$SentInteraction copy(long channelId, Long messageId, Long guildId, StoreApplicationInteractions$SentInteractionState state) {
        m.checkNotNullParameter(state, "state");
        return new StoreApplicationInteractions$SentInteraction(channelId, messageId, guildId, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreApplicationInteractions$SentInteraction)) {
            return false;
        }
        StoreApplicationInteractions$SentInteraction storeApplicationInteractions$SentInteraction = (StoreApplicationInteractions$SentInteraction) other;
        return this.channelId == storeApplicationInteractions$SentInteraction.channelId && m.areEqual(this.messageId, storeApplicationInteractions$SentInteraction.messageId) && m.areEqual(this.guildId, storeApplicationInteractions$SentInteraction.guildId) && m.areEqual(this.state, storeApplicationInteractions$SentInteraction.state);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final StoreApplicationInteractions$SentInteractionState getState() {
        return this.state;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        Long l = this.messageId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        StoreApplicationInteractions$SentInteractionState storeApplicationInteractions$SentInteractionState = this.state;
        return iHashCode2 + (storeApplicationInteractions$SentInteractionState != null ? storeApplicationInteractions$SentInteractionState.hashCode() : 0);
    }

    public final void setState(StoreApplicationInteractions$SentInteractionState storeApplicationInteractions$SentInteractionState) {
        m.checkNotNullParameter(storeApplicationInteractions$SentInteractionState, "<set-?>");
        this.state = storeApplicationInteractions$SentInteractionState;
    }

    public String toString() {
        StringBuilder sbU = a.U("SentInteraction(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ StoreApplicationInteractions$SentInteraction(long j, Long l, Long l2, StoreApplicationInteractions$SentInteractionState storeApplicationInteractions$SentInteractionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, l2, (i & 8) != 0 ? StoreApplicationInteractions$SentInteractionState.SENDING : storeApplicationInteractions$SentInteractionState);
    }
}
