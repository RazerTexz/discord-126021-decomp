package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PackageIdentityUtils$Pre28Implementation implements PackageIdentityUtils$SignaturesCompat {
    @Override // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager$NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
        ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
        for (Signature signature : packageInfo.signatures) {
            byte[] certificateSHA256Fingerprint = PackageIdentityUtils.getCertificateSHA256Fingerprint(signature);
            if (certificateSHA256Fingerprint == null) {
                return null;
            }
            arrayList.add(certificateSHA256Fingerprint);
        }
        return arrayList;
    }

    @Override // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
    public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager$NameNotFoundException, IOException {
        List<byte[]> fingerprintsForPackage;
        if (str.equals(tokenContents.getPackageName()) && (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) != null) {
            return tokenContents.equals(TokenContents.create(str, fingerprintsForPackage));
        }
        return false;
    }
}
