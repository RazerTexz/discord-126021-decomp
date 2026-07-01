package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager$AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager$AuthenticationResult;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintManagerCompat$1 extends FingerprintManager$AuthenticationCallback {
    public final /* synthetic */ FingerprintManagerCompat$AuthenticationCallback val$callback;

    public FingerprintManagerCompat$1(FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback) {
        this.val$callback = fingerprintManagerCompat$AuthenticationCallback;
    }

    @Override // android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        this.val$callback.onAuthenticationError(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
    public void onAuthenticationFailed() {
        this.val$callback.onAuthenticationFailed();
    }

    @Override // android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        this.val$callback.onAuthenticationHelp(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager$AuthenticationResult fingerprintManager$AuthenticationResult) {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat$AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(fingerprintManager$AuthenticationResult.getCryptoObject())));
    }
}
