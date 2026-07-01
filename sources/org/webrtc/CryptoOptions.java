package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public final class CryptoOptions {
    private final CryptoOptions$SFrame sframe;
    private final CryptoOptions$Srtp srtp;

    public /* synthetic */ CryptoOptions(boolean z2, boolean z3, boolean z4, boolean z5, CryptoOptions$1 cryptoOptions$1) {
        this(z2, z3, z4, z5);
    }

    public static CryptoOptions$Builder builder() {
        return new CryptoOptions$Builder(null);
    }

    @CalledByNative
    public CryptoOptions$SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public CryptoOptions$Srtp getSrtp() {
        return this.srtp;
    }

    private CryptoOptions(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.srtp = new CryptoOptions$Srtp(this, z2, z3, z4, null);
        this.sframe = new CryptoOptions$SFrame(this, z5, null);
    }
}
