package com.discord.utilities.websocket;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$Closed {
    private final int code;
    private final String reason;

    public WebSocket$Closed(int i, String str) {
        this.code = i;
        this.reason = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getReason() {
        return this.reason;
    }
}
