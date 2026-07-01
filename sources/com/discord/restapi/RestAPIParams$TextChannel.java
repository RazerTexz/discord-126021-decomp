package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$TextChannel {
    private final Integer defaultAutoArchiveDuration;
    private final String name;
    private final Boolean nsfw;
    private final Integer rateLimitPerUser;
    private final String topic;
    private final Integer type;

    public RestAPIParams$TextChannel(String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3) {
        this.name = str;
        this.type = num;
        this.topic = str2;
        this.nsfw = bool;
        this.rateLimitPerUser = num2;
        this.defaultAutoArchiveDuration = num3;
    }
}
