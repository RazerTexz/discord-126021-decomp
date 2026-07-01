package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStream$CallStream extends ModelApplicationStream {
    private final long channelId;
    private final long ownerId;
    private final String type;

    public ModelApplicationStream$CallStream(long j, long j2) {
        super(j, j2, null);
        this.channelId = j;
        this.ownerId = j2;
        this.type = StreamType.CALL.getSerializedRepresentation();
    }

    public static /* synthetic */ ModelApplicationStream$CallStream copy$default(ModelApplicationStream$CallStream modelApplicationStream$CallStream, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelApplicationStream$CallStream.getChannelId();
        }
        if ((i & 2) != 0) {
            j2 = modelApplicationStream$CallStream.getOwnerId();
        }
        return modelApplicationStream$CallStream.copy(j, j2);
    }

    public final long component1() {
        return getChannelId();
    }

    public final long component2() {
        return getOwnerId();
    }

    public final ModelApplicationStream$CallStream copy(long channelId, long ownerId) {
        return new ModelApplicationStream$CallStream(channelId, ownerId);
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public String encodeStreamKey() {
        return StreamType.CALL.getSerializedRepresentation() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream$CallStream)) {
            return false;
        }
        ModelApplicationStream$CallStream modelApplicationStream$CallStream = (ModelApplicationStream$CallStream) other;
        return getChannelId() == modelApplicationStream$CallStream.getChannelId() && getOwnerId() == modelApplicationStream$CallStream.getOwnerId();
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public long getOwnerId() {
        return this.ownerId;
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long channelId = getChannelId();
        int i = ((int) (channelId ^ (channelId >>> 32))) * 31;
        long ownerId = getOwnerId();
        return i + ((int) (ownerId ^ (ownerId >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("CallStream(channelId=");
        sbU.append(getChannelId());
        sbU.append(", ownerId=");
        sbU.append(getOwnerId());
        sbU.append(")");
        return sbU.toString();
    }
}
