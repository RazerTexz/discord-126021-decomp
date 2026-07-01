package androidx.core.os;

import android.os.Handler;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class HandlerCompat$Api29Impl {
    private HandlerCompat$Api29Impl() {
    }

    public static boolean hasCallbacks(Handler handler, Runnable runnable) {
        return handler.hasCallbacks(runnable);
    }
}
