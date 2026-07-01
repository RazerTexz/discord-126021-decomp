package androidx.core.content.pm;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class PackageInfoCompat$Api28Impl {
    private PackageInfoCompat$Api28Impl() {
    }

    @Nullable
    public static Signature[] getApkContentsSigners(@NonNull SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    @Nullable
    public static Signature[] getSigningCertificateHistory(@NonNull SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    public static boolean hasMultipleSigners(@NonNull SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    public static boolean hasSigningCertificate(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i) {
        return packageManager.hasSigningCertificate(str, bArr, i);
    }
}
