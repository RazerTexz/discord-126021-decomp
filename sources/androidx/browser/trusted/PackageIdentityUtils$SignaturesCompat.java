package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface PackageIdentityUtils$SignaturesCompat {
    @Nullable
    List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager$NameNotFoundException;

    boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager$NameNotFoundException, IOException;
}
