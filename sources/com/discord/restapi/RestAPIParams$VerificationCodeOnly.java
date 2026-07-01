package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VerificationCodeOnly {
    private final String code;

    public RestAPIParams$VerificationCodeOnly(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }
}
