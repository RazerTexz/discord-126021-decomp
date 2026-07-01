package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessagesLoader$ChannelChunk {
    private final long channelId;
    private final boolean isAppendingTop;
    private final boolean isInitial;
    private final boolean isJump;
    private final boolean isPresent;
    private final List<Message> messages;

    public StoreMessagesLoader$ChannelChunk(long j, List<Message> list, boolean z2, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(list, "messages");
        this.channelId = j;
        this.messages = list;
        this.isInitial = z2;
        this.isPresent = z3;
        this.isAppendingTop = z4;
        this.isJump = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreMessagesLoader$ChannelChunk copy$default(StoreMessagesLoader$ChannelChunk storeMessagesLoader$ChannelChunk, long j, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        return storeMessagesLoader$ChannelChunk.copy((i & 1) != 0 ? storeMessagesLoader$ChannelChunk.channelId : j, (i & 2) != 0 ? storeMessagesLoader$ChannelChunk.messages : list, (i & 4) != 0 ? storeMessagesLoader$ChannelChunk.isInitial : z2, (i & 8) != 0 ? storeMessagesLoader$ChannelChunk.isPresent : z3, (i & 16) != 0 ? storeMessagesLoader$ChannelChunk.isAppendingTop : z4, (i & 32) != 0 ? storeMessagesLoader$ChannelChunk.isJump : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final List<Message> component2() {
        return this.messages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsInitial() {
        return this.isInitial;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPresent() {
        return this.isPresent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsAppendingTop() {
        return this.isAppendingTop;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsJump() {
        return this.isJump;
    }

    public final StoreMessagesLoader$ChannelChunk copy(long channelId, List<Message> messages, boolean isInitial, boolean isPresent, boolean isAppendingTop, boolean isJump) {
        m.checkNotNullParameter(messages, "messages");
        return new StoreMessagesLoader$ChannelChunk(channelId, messages, isInitial, isPresent, isAppendingTop, isJump);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessagesLoader$ChannelChunk)) {
            return false;
        }
        StoreMessagesLoader$ChannelChunk storeMessagesLoader$ChannelChunk = (StoreMessagesLoader$ChannelChunk) other;
        return this.channelId == storeMessagesLoader$ChannelChunk.channelId && m.areEqual(this.messages, storeMessagesLoader$ChannelChunk.messages) && this.isInitial == storeMessagesLoader$ChannelChunk.isInitial && this.isPresent == storeMessagesLoader$ChannelChunk.isPresent && this.isAppendingTop == storeMessagesLoader$ChannelChunk.isAppendingTop && this.isJump == storeMessagesLoader$ChannelChunk.isJump;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        List<Message> list = this.messages;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isInitial;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isPresent;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isAppendingTop;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isJump;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isAppendingTop() {
        return this.isAppendingTop;
    }

    public final boolean isInitial() {
        return this.isInitial;
    }

    public final boolean isJump() {
        return this.isJump;
    }

    public final boolean isPresent() {
        return this.isPresent;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelChunk(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messages=");
        sbU.append(this.messages);
        sbU.append(", isInitial=");
        sbU.append(this.isInitial);
        sbU.append(", isPresent=");
        sbU.append(this.isPresent);
        sbU.append(", isAppendingTop=");
        sbU.append(this.isAppendingTop);
        sbU.append(", isJump=");
        return a.O(sbU, this.isJump, ")");
    }
}
