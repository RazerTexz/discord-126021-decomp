package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChannelsSelected$UserChannelSelection$ThreadDraft extends StoreChannelsSelected$UserChannelSelection {
    private final String locationThreadStart;
    private final long parentChannelId;
    private final Long starterMessageId;

    public StoreChannelsSelected$UserChannelSelection$ThreadDraft(long j, Long l, String str) {
        super(null);
        this.parentChannelId = j;
        this.starterMessageId = l;
        this.locationThreadStart = str;
    }

    public static /* synthetic */ StoreChannelsSelected$UserChannelSelection$ThreadDraft copy$default(StoreChannelsSelected$UserChannelSelection$ThreadDraft storeChannelsSelected$UserChannelSelection$ThreadDraft, long j, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeChannelsSelected$UserChannelSelection$ThreadDraft.parentChannelId;
        }
        if ((i & 2) != 0) {
            l = storeChannelsSelected$UserChannelSelection$ThreadDraft.starterMessageId;
        }
        if ((i & 4) != 0) {
            str = storeChannelsSelected$UserChannelSelection$ThreadDraft.locationThreadStart;
        }
        return storeChannelsSelected$UserChannelSelection$ThreadDraft.copy(j, l, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getParentChannelId() {
        return this.parentChannelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getStarterMessageId() {
        return this.starterMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocationThreadStart() {
        return this.locationThreadStart;
    }

    public final StoreChannelsSelected$UserChannelSelection$ThreadDraft copy(long parentChannelId, Long starterMessageId, String locationThreadStart) {
        return new StoreChannelsSelected$UserChannelSelection$ThreadDraft(parentChannelId, starterMessageId, locationThreadStart);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChannelsSelected$UserChannelSelection$ThreadDraft)) {
            return false;
        }
        StoreChannelsSelected$UserChannelSelection$ThreadDraft storeChannelsSelected$UserChannelSelection$ThreadDraft = (StoreChannelsSelected$UserChannelSelection$ThreadDraft) other;
        return this.parentChannelId == storeChannelsSelected$UserChannelSelection$ThreadDraft.parentChannelId && m.areEqual(this.starterMessageId, storeChannelsSelected$UserChannelSelection$ThreadDraft.starterMessageId) && m.areEqual(this.locationThreadStart, storeChannelsSelected$UserChannelSelection$ThreadDraft.locationThreadStart);
    }

    public final String getLocationThreadStart() {
        return this.locationThreadStart;
    }

    public final long getParentChannelId() {
        return this.parentChannelId;
    }

    public final Long getStarterMessageId() {
        return this.starterMessageId;
    }

    public int hashCode() {
        int iA = b.a(this.parentChannelId) * 31;
        Long l = this.starterMessageId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.locationThreadStart;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadDraft(parentChannelId=");
        sbU.append(this.parentChannelId);
        sbU.append(", starterMessageId=");
        sbU.append(this.starterMessageId);
        sbU.append(", locationThreadStart=");
        return a.J(sbU, this.locationThreadStart, ")");
    }
}
