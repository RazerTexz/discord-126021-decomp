package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VoiceChannel {
    private final Integer bitrate;
    private final String name;
    private final Boolean nsfw;
    private final String rtcRegion;
    private final String topic;
    private final Integer type;
    private final Integer userLimit;

    public RestAPIParams$VoiceChannel(String str, String str2, Integer num, Boolean bool, Integer num2, Integer num3, String str3) {
        this.name = str;
        this.topic = str2;
        this.type = num;
        this.nsfw = bool;
        this.userLimit = num2;
        this.bitrate = num3;
        this.rtcRegion = str3;
    }
}
