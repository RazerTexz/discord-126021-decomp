package com.discord.rtcconnection.mediaengine;

import d0.z.d.m;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnection$FailedConnectionException extends Exception {
    private final MediaEngineConnection$FailedConnectionException$FailureType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEngineConnection$FailedConnectionException(String str, MediaEngineConnection$FailedConnectionException$FailureType mediaEngineConnection$FailedConnectionException$FailureType) {
        super(str);
        m.checkNotNullParameter(mediaEngineConnection$FailedConnectionException$FailureType, "type");
        this.type = mediaEngineConnection$FailedConnectionException$FailureType;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final MediaEngineConnection$FailedConnectionException$FailureType getType() {
        return this.type;
    }
}
