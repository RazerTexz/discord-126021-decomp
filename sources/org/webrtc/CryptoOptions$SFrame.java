package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public final class CryptoOptions$SFrame {
    private final boolean requireFrameEncryption;
    public final /* synthetic */ CryptoOptions this$0;

    public /* synthetic */ CryptoOptions$SFrame(CryptoOptions cryptoOptions, boolean z2, CryptoOptions$1 cryptoOptions$1) {
        this(cryptoOptions, z2);
    }

    @CalledByNative("SFrame")
    public boolean getRequireFrameEncryption() {
        return this.requireFrameEncryption;
    }

    private CryptoOptions$SFrame(CryptoOptions cryptoOptions, boolean z2) {
        this.this$0 = cryptoOptions;
        this.requireFrameEncryption = z2;
    }
}
