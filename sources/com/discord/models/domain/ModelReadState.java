package com.discord.models.domain;

import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelReadState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelReadState {
    private final long channelId;
    private final long lastMessageId;
    private final int mentionCount;
    private final int version;

    public ModelReadState(long j, long j2, int i, int i2) {
        this.channelId = j;
        this.lastMessageId = j2;
        this.mentionCount = i;
        this.version = i2;
    }

    public static /* synthetic */ ModelReadState copy$default(ModelReadState modelReadState, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = modelReadState.channelId;
        }
        long j3 = j;
        if ((i3 & 2) != 0) {
            j2 = modelReadState.lastMessageId;
        }
        long j4 = j2;
        if ((i3 & 4) != 0) {
            i = modelReadState.mentionCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = modelReadState.version;
        }
        return modelReadState.copy(j3, j4, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final ModelReadState copy(long channelId, long lastMessageId, int mentionCount, int version) {
        return new ModelReadState(channelId, lastMessageId, mentionCount, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelReadState)) {
            return false;
        }
        ModelReadState modelReadState = (ModelReadState) other;
        return this.channelId == modelReadState.channelId && this.lastMessageId == modelReadState.lastMessageId && this.mentionCount == modelReadState.mentionCount && this.version == modelReadState.version;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.lastMessageId;
        return ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.mentionCount) * 31) + this.version;
    }

    public final boolean isMentioned() {
        return this.mentionCount > 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", lastMessageId=");
        sbU.append(this.lastMessageId);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", version=");
        return a.B(sbU, this.version, ")");
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, i, i2);
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j4, i, i2);
    }

    private ModelReadState(long j, long j2, long j3, long j4, int i, int i2) {
        this(j2 != 0 ? j2 : j, j3 != 0 ? j3 : j4, i, i2);
    }
}
