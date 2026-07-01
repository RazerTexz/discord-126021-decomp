package androidx.core.os;

import android.os.Build$VERSION;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {
    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i) {
        return Build$VERSION.SDK_INT >= 24 ? ProcessCompat$Api24Impl.isApplicationUid(i) : ProcessCompat$Api17Impl.isApplicationUid(i);
    }
}
