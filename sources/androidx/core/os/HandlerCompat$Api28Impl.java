package androidx.core.os;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class HandlerCompat$Api28Impl {
    private HandlerCompat$Api28Impl() {
    }

    public static Handler createAsync(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j) {
        return handler.postDelayed(runnable, obj, j);
    }

    public static Handler createAsync(Looper looper, Handler$Callback handler$Callback) {
        return Handler.createAsync(looper, handler$Callback);
    }
}
