package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters$HeaderExtension {
    private final boolean encrypted;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f3821id;
    private final String uri;

    @CalledByNative("HeaderExtension")
    public RtpParameters$HeaderExtension(String str, int i, boolean z2) {
        this.uri = str;
        this.f3821id = i;
        this.encrypted = z2;
    }

    @CalledByNative("HeaderExtension")
    public boolean getEncrypted() {
        return this.encrypted;
    }

    @CalledByNative("HeaderExtension")
    public int getId() {
        return this.f3821id;
    }

    @CalledByNative("HeaderExtension")
    public String getUri() {
        return this.uri;
    }
}
