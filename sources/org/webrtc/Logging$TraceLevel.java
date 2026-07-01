package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public enum Logging$TraceLevel {
    TRACE_NONE(0),
    TRACE_STATEINFO(1),
    TRACE_WARNING(2),
    TRACE_ERROR(4),
    TRACE_CRITICAL(8),
    TRACE_APICALL(16),
    TRACE_DEFAULT(255),
    TRACE_MODULECALL(32),
    TRACE_MEMORY(256),
    TRACE_TIMER(512),
    TRACE_STREAM(1024),
    TRACE_DEBUG(2048),
    TRACE_INFO(4096),
    TRACE_TERSEINFO(8192),
    TRACE_ALL(65535);

    public final int level;

    Logging$TraceLevel(int i) {
        this.level = i;
    }
}
