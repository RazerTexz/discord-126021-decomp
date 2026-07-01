package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GuildMemberDisconnect {
    private final Long channelId;

    public RestAPIParams$GuildMemberDisconnect() {
        this(null, 1, null);
    }

    public RestAPIParams$GuildMemberDisconnect(Long l) {
        this.channelId = l;
    }

    public /* synthetic */ RestAPIParams$GuildMemberDisconnect(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l);
    }
}
