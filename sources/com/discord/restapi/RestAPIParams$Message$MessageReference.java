package com.discord.restapi;


/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Message$MessageReference {
    private final long channelId;
    private final Long guildId;
    private final Long messageId;

    public RestAPIParams$Message$MessageReference(Long l, long j, Long l2) {
        this.guildId = l;
        this.channelId = j;
        this.messageId = l2;
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
}
