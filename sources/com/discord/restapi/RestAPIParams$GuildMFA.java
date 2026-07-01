package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GuildMFA {
    private final String code;
    private final int level;

    public RestAPIParams$GuildMFA(int i, String str) {
        this.level = i;
        this.code = str;
    }
}
