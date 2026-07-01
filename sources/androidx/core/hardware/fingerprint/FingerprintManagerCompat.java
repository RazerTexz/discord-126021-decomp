package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager$AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager$CryptoObject;
import android.os.Build$VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context context) {
        int i = Build$VERSION.SDK_INT;
        if (i == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    @RequiresApi(23)
    public static FingerprintManagerCompat$CryptoObject unwrapCryptoObject(FingerprintManager$CryptoObject fingerprintManager$CryptoObject) {
        if (fingerprintManager$CryptoObject == null) {
            return null;
        }
        if (fingerprintManager$CryptoObject.getCipher() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManager$CryptoObject.getCipher());
        }
        if (fingerprintManager$CryptoObject.getSignature() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManager$CryptoObject.getSignature());
        }
        if (fingerprintManager$CryptoObject.getMac() != null) {
            return new FingerprintManagerCompat$CryptoObject(fingerprintManager$CryptoObject.getMac());
        }
        return null;
    }

    @RequiresApi(23)
    private static FingerprintManager$AuthenticationCallback wrapCallback(FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback) {
        return new FingerprintManagerCompat$1(fingerprintManagerCompat$AuthenticationCallback);
    }

    @RequiresApi(23)
    private static FingerprintManager$CryptoObject wrapCryptoObject(FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject) {
        if (fingerprintManagerCompat$CryptoObject == null) {
            return null;
        }
        if (fingerprintManagerCompat$CryptoObject.getCipher() != null) {
            return new FingerprintManager$CryptoObject(fingerprintManagerCompat$CryptoObject.getCipher());
        }
        if (fingerprintManagerCompat$CryptoObject.getSignature() != null) {
            return new FingerprintManager$CryptoObject(fingerprintManagerCompat$CryptoObject.getSignature());
        }
        if (fingerprintManagerCompat$CryptoObject.getMac() != null) {
            return new FingerprintManager$CryptoObject(fingerprintManagerCompat$CryptoObject.getMac());
        }
        return null;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback, @Nullable Handler handler) {
        FingerprintManager fingerprintManagerOrNull;
        if (Build$VERSION.SDK_INT < 23 || (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) == null) {
            return;
        }
        fingerprintManagerOrNull.authenticate(wrapCryptoObject(fingerprintManagerCompat$CryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, wrapCallback(fingerprintManagerCompat$AuthenticationCallback), handler);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManagerOrNull;
        return Build$VERSION.SDK_INT >= 23 && (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) != null && fingerprintManagerOrNull.hasEnrolledFingerprints();
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManagerOrNull;
        return Build$VERSION.SDK_INT >= 23 && (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) != null && fingerprintManagerOrNull.isHardwareDetected();
    }
}
