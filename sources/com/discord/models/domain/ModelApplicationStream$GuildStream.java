package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStream$GuildStream extends ModelApplicationStream {
    private final long channelId;
    private final long guildId;
    private final long ownerId;
    private final String type;

    public ModelApplicationStream$GuildStream(long j, long j2, long j3) {
        super(j2, j3, null);
        this.guildId = j;
        this.channelId = j2;
        this.ownerId = j3;
        this.type = StreamType.GUILD.getSerializedRepresentation();
    }

    public static /* synthetic */ ModelApplicationStream$GuildStream copy$default(ModelApplicationStream$GuildStream modelApplicationStream$GuildStream, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelApplicationStream$GuildStream.guildId;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = modelApplicationStream$GuildStream.getChannelId();
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = modelApplicationStream$GuildStream.getOwnerId();
        }
        return modelApplicationStream$GuildStream.copy(j4, j5, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final long component2() {
        return getChannelId();
    }

    public final long component3() {
        return getOwnerId();
    }

    public final ModelApplicationStream$GuildStream copy(long guildId, long channelId, long ownerId) {
        return new ModelApplicationStream$GuildStream(guildId, channelId, ownerId);
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public String encodeStreamKey() {
        return StreamType.GUILD.getSerializedRepresentation() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + this.guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream$GuildStream)) {
            return false;
        }
        ModelApplicationStream$GuildStream modelApplicationStream$GuildStream = (ModelApplicationStream$GuildStream) other;
        return this.guildId == modelApplicationStream$GuildStream.guildId && getChannelId() == modelApplicationStream$GuildStream.getChannelId() && getOwnerId() == modelApplicationStream$GuildStream.getOwnerId();
    }

    @Override // com.discord.models.domain.ModelApplicationStream
    public long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
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
        long j = this.guildId;
        long channelId = getChannelId();
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (channelId ^ (channelId >>> 32)))) * 31;
        long ownerId = getOwnerId();
        return i + ((int) (ownerId ^ (ownerId >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildStream(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", ownerId=");
        sbU.append(getOwnerId());
        sbU.append(")");
        return sbU.toString();
    }
}
