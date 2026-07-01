package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$TransferGuildOwnership {
    private final String code;
    private final long ownerId;

    public RestAPIParams$TransferGuildOwnership(long j, String str) {
        this.ownerId = j;
        this.code = str;
    }
}
