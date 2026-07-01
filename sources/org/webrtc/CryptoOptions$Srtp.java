package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public final class CryptoOptions$Srtp {
    private final boolean enableAes128Sha1_32CryptoCipher;
    private final boolean enableEncryptedRtpHeaderExtensions;
    private final boolean enableGcmCryptoSuites;
    public final /* synthetic */ CryptoOptions this$0;

    public /* synthetic */ CryptoOptions$Srtp(CryptoOptions cryptoOptions, boolean z2, boolean z3, boolean z4, CryptoOptions$1 cryptoOptions$1) {
        this(cryptoOptions, z2, z3, z4);
    }

    @CalledByNative("Srtp")
    public boolean getEnableAes128Sha1_32CryptoCipher() {
        return this.enableAes128Sha1_32CryptoCipher;
    }

    @CalledByNative("Srtp")
    public boolean getEnableEncryptedRtpHeaderExtensions() {
        return this.enableEncryptedRtpHeaderExtensions;
    }

    @CalledByNative("Srtp")
    public boolean getEnableGcmCryptoSuites() {
        return this.enableGcmCryptoSuites;
    }

    private CryptoOptions$Srtp(CryptoOptions cryptoOptions, boolean z2, boolean z3, boolean z4) {
        this.this$0 = cryptoOptions;
        this.enableGcmCryptoSuites = z2;
        this.enableAes128Sha1_32CryptoCipher = z3;
        this.enableEncryptedRtpHeaderExtensions = z4;
    }
}
