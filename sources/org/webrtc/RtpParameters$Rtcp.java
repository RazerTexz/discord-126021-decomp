package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class RtpParameters$Rtcp {
    private final String cname;
    private final boolean reducedSize;

    @CalledByNative("Rtcp")
    public RtpParameters$Rtcp(String str, boolean z2) {
        this.cname = str;
        this.reducedSize = z2;
    }

    @CalledByNative("Rtcp")
    public String getCname() {
        return this.cname;
    }

    @CalledByNative("Rtcp")
    public boolean getReducedSize() {
        return this.reducedSize;
    }
}
