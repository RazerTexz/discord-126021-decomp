package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class CryptoOptions$Builder {
    private boolean enableAes128Sha1_32CryptoCipher;
    private boolean enableEncryptedRtpHeaderExtensions;
    private boolean enableGcmCryptoSuites;
    private boolean requireFrameEncryption;

    public /* synthetic */ CryptoOptions$Builder(CryptoOptions$1 cryptoOptions$1) {
        this();
    }

    public CryptoOptions createCryptoOptions() {
        return new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption, null);
    }

    public CryptoOptions$Builder setEnableAes128Sha1_32CryptoCipher(boolean z2) {
        this.enableAes128Sha1_32CryptoCipher = z2;
        return this;
    }

    public CryptoOptions$Builder setEnableEncryptedRtpHeaderExtensions(boolean z2) {
        this.enableEncryptedRtpHeaderExtensions = z2;
        return this;
    }

    public CryptoOptions$Builder setEnableGcmCryptoSuites(boolean z2) {
        this.enableGcmCryptoSuites = z2;
        return this;
    }

    public CryptoOptions$Builder setRequireFrameEncryption(boolean z2) {
        this.requireFrameEncryption = z2;
        return this;
    }

    private CryptoOptions$Builder() {
    }
}
