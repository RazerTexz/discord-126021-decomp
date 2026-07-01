package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$MFALogin {
    private final String code;
    private final String ticket;

    public RestAPIParams$MFALogin(String str, String str2) {
        this.ticket = str;
        this.code = str2;
    }
}
