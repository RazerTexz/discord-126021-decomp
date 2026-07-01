package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class PackageIdentityUtils$Api28Implementation implements PackageIdentityUtils$SignaturesCompat {
    @Override // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
    @Nullable
    public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager$NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
        ArrayList arrayList = new ArrayList();
        SigningInfo signingInfo = packageInfo.signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            for (Signature signature : signingInfo.getApkContentsSigners()) {
                arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signature));
            }
        } else {
            arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signingInfo.getSigningCertificateHistory()[0]));
        }
        return arrayList;
    }

    @Override // androidx.browser.trusted.PackageIdentityUtils$SignaturesCompat
    public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager$NameNotFoundException, IOException {
        List<byte[]> fingerprintsForPackage;
        if (tokenContents.getPackageName().equals(str) && (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) != null) {
            return fingerprintsForPackage.size() == 1 ? packageManager.hasSigningCertificate(str, tokenContents.getFingerprint(0), 1) : tokenContents.equals(TokenContents.create(str, fingerprintsForPackage));
        }
        return false;
    }
}
