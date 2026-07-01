package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreLurking$LurkRequest {
    private final Long channelId;
    private final long guildId;

    public StoreLurking$LurkRequest(long j, Long l) {
        this.guildId = j;
        this.channelId = l;
    }

    public static /* synthetic */ StoreLurking$LurkRequest copy$default(StoreLurking$LurkRequest storeLurking$LurkRequest, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeLurking$LurkRequest.guildId;
        }
        if ((i & 2) != 0) {
            l = storeLurking$LurkRequest.channelId;
        }
        return storeLurking$LurkRequest.copy(j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    public final StoreLurking$LurkRequest copy(long guildId, Long channelId) {
        return new StoreLurking$LurkRequest(guildId, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreLurking$LurkRequest)) {
            return false;
        }
        StoreLurking$LurkRequest storeLurking$LurkRequest = (StoreLurking$LurkRequest) other;
        return this.guildId == storeLurking$LurkRequest.guildId && m.areEqual(this.channelId, storeLurking$LurkRequest.channelId);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        Long l = this.channelId;
        return iA + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("LurkRequest(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        return a.G(sbU, this.channelId, ")");
    }

    public /* synthetic */ StoreLurking$LurkRequest(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l);
    }
}
