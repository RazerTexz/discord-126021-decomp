package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreThreadMessages$ThreadState {
    private int count;
    private final long guildId;
    private Message mostRecentMessage;
    private final long parentId;
    private final long threadId;

    public StoreThreadMessages$ThreadState(long j, long j2, long j3, int i, Message message) {
        this.threadId = j;
        this.guildId = j2;
        this.parentId = j3;
        this.count = i;
        this.mostRecentMessage = message;
    }

    public static /* synthetic */ StoreThreadMessages$ThreadState copy$default(StoreThreadMessages$ThreadState storeThreadMessages$ThreadState, long j, long j2, long j3, int i, Message message, int i2, Object obj) {
        return storeThreadMessages$ThreadState.copy((i2 & 1) != 0 ? storeThreadMessages$ThreadState.threadId : j, (i2 & 2) != 0 ? storeThreadMessages$ThreadState.guildId : j2, (i2 & 4) != 0 ? storeThreadMessages$ThreadState.parentId : j3, (i2 & 8) != 0 ? storeThreadMessages$ThreadState.count : i, (i2 & 16) != 0 ? storeThreadMessages$ThreadState.mostRecentMessage : message);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final StoreThreadMessages$ThreadState copy(long threadId, long guildId, long parentId, int count, Message mostRecentMessage) {
        return new StoreThreadMessages$ThreadState(threadId, guildId, parentId, count, mostRecentMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreThreadMessages$ThreadState)) {
            return false;
        }
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = (StoreThreadMessages$ThreadState) other;
        return this.threadId == storeThreadMessages$ThreadState.threadId && this.guildId == storeThreadMessages$ThreadState.guildId && this.parentId == storeThreadMessages$ThreadState.parentId && this.count == storeThreadMessages$ThreadState.count && m.areEqual(this.mostRecentMessage, storeThreadMessages$ThreadState.mostRecentMessage);
    }

    public final int getCount() {
        return this.count;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final long getParentId() {
        return this.parentId;
    }

    public final long getThreadId() {
        return this.threadId;
    }

    public int hashCode() {
        int iA = (((b.a(this.parentId) + ((b.a(this.guildId) + (b.a(this.threadId) * 31)) * 31)) * 31) + this.count) * 31;
        Message message = this.mostRecentMessage;
        return iA + (message != null ? message.hashCode() : 0);
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setMostRecentMessage(Message message) {
        this.mostRecentMessage = message;
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadState(threadId=");
        sbU.append(this.threadId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", count=");
        sbU.append(this.count);
        sbU.append(", mostRecentMessage=");
        sbU.append(this.mostRecentMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
