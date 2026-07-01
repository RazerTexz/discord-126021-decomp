package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$TopicalChannel {
    private final String name;
    private final String topic;
    private final Integer type;

    public RestAPIParams$TopicalChannel(String str, Integer num, String str2) {
        this.name = str;
        this.type = num;
        this.topic = str2;
    }
}
