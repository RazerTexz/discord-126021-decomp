package com.discord.models.domain;

import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StreamType {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;
    public static final StreamType$Companion Companion = new StreamType$Companion(null);
    private static final StreamType[] VALUES = values();

    StreamType(String str) {
        this.serializedRepresentation = str;
    }

    public static final /* synthetic */ StreamType[] access$getVALUES$cp() {
        return VALUES;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}
