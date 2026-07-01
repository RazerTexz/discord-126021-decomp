package androidx.core.hardware.fingerprint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintManagerCompat$CryptoObject {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;

    public FingerprintManagerCompat$CryptoObject(@NonNull Signature signature) {
        this.mSignature = signature;
        this.mCipher = null;
        this.mMac = null;
    }

    @Nullable
    public Cipher getCipher() {
        return this.mCipher;
    }

    @Nullable
    public Mac getMac() {
        return this.mMac;
    }

    @Nullable
    public Signature getSignature() {
        return this.mSignature;
    }

    public FingerprintManagerCompat$CryptoObject(@NonNull Cipher cipher) {
        this.mCipher = cipher;
        this.mSignature = null;
        this.mMac = null;
    }

    public FingerprintManagerCompat$CryptoObject(@NonNull Mac mac) {
        this.mMac = mac;
        this.mCipher = null;
        this.mSignature = null;
    }
}
