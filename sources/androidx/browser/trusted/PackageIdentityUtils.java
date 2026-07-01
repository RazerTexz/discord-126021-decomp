package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PackageIdentityUtils {
    private static final String TAG = "PackageIdentity";

    private PackageIdentityUtils() {
    }

    @Nullable
    public static byte[] getCertificateSHA256Fingerprint(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Nullable
    public static List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) {
        try {
            return getImpl().getFingerprintsForPackage(str, packageManager);
        } catch (PackageManager$NameNotFoundException e) {
            Log.e(TAG, "Could not get fingerprint for package.", e);
            return null;
        }
    }

    private static PackageIdentityUtils$SignaturesCompat getImpl() {
        return Build$VERSION.SDK_INT >= 28 ? new PackageIdentityUtils$Api28Implementation() : new PackageIdentityUtils$Pre28Implementation();
    }

    public static boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) {
        try {
            return getImpl().packageMatchesToken(str, packageManager, tokenContents);
        } catch (PackageManager$NameNotFoundException | IOException e) {
            Log.e(TAG, "Could not check if package matches token.", e);
            return false;
        }
    }
}
