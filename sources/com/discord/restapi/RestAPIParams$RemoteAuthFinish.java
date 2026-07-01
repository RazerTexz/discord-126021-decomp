package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$RemoteAuthFinish {
    private final String handshakeToken;
    private final boolean temporary;

    public RestAPIParams$RemoteAuthFinish(boolean z2, String str) {
        m.checkNotNullParameter(str, "handshakeToken");
        this.temporary = z2;
        this.handshakeToken = str;
    }
}
