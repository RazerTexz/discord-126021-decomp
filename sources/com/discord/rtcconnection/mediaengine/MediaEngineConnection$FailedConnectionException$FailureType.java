package com.discord.rtcconnection.mediaengine;


/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaEngineConnection$FailedConnectionException$FailureType {
    DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED,
    TIMEOUT,
    ADDRESS_IP_RESOLVED,
    NO_CONNECTION_INFO,
    CODEC_NEGOTIATION_FAILED,
    UNKNOWN;

    public static final MediaEngineConnection$FailedConnectionException$FailureType$a Companion = new MediaEngineConnection$FailedConnectionException$FailureType$a(null);
}
