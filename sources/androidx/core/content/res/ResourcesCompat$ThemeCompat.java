package androidx.core.content.res;

import android.content.res.Resources$Theme;
import android.os.Build$VERSION;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat$ThemeCompat {
    private ResourcesCompat$ThemeCompat() {
    }

    public static void rebase(@NonNull Resources$Theme resources$Theme) {
        int i = Build$VERSION.SDK_INT;
        if (i >= 29) {
            ResourcesCompat$ThemeCompat$ImplApi29.rebase(resources$Theme);
        } else if (i >= 23) {
            ResourcesCompat$ThemeCompat$ImplApi23.rebase(resources$Theme);
        }
    }
}
