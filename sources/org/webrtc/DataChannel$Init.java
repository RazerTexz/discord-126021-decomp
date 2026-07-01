package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class DataChannel$Init {
    public boolean negotiated;
    public boolean ordered = true;
    public int maxRetransmitTimeMs = -1;
    public int maxRetransmits = -1;
    public String protocol = "";

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f3819id = -1;

    @CalledByNative("Init")
    public int getId() {
        return this.f3819id;
    }

    @CalledByNative("Init")
    public int getMaxRetransmitTimeMs() {
        return this.maxRetransmitTimeMs;
    }

    @CalledByNative("Init")
    public int getMaxRetransmits() {
        return this.maxRetransmits;
    }

    @CalledByNative("Init")
    public boolean getNegotiated() {
        return this.negotiated;
    }

    @CalledByNative("Init")
    public boolean getOrdered() {
        return this.ordered;
    }

    @CalledByNative("Init")
    public String getProtocol() {
        return this.protocol;
    }
}
