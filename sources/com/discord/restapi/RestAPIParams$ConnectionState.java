package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ConnectionState {
    private final String code;
    private final Boolean fromContinuation;
    private final Boolean insecure;
    private final String state;

    public RestAPIParams$ConnectionState(String str, String str2, Boolean bool, Boolean bool2) {
        this.code = str;
        this.state = str2;
        this.fromContinuation = bool;
        this.insecure = bool2;
    }
}
