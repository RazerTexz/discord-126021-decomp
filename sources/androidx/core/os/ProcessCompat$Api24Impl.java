package androidx.core.os;

import android.os.Process;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class ProcessCompat$Api24Impl {
    private ProcessCompat$Api24Impl() {
    }

    public static boolean isApplicationUid(int i) {
        return Process.isApplicationUid(i);
    }
}
