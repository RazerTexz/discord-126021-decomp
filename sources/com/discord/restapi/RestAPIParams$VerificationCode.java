package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$VerificationCode {
    private final String code;
    private final String phone;

    public RestAPIParams$VerificationCode(String str, String str2) {
        m.checkNotNullParameter(str, "phone");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.phone = str;
        this.code = str2;
    }
}
