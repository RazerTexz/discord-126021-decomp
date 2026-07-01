package b.i.a.c.f3;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NetworkTypeObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    @Nullable
    public static v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f982b = new Handler(Looper.getMainLooper());
    public final CopyOnWriteArrayList<WeakReference<v$b>> c = new CopyOnWriteArrayList<>();
    public final Object d = new Object();

    @GuardedBy("networkTypeLock")
    public int e = 0;

    public v(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new v$c(this, null), intentFilter);
    }

    public static void a(v vVar, int i) {
        synchronized (vVar.d) {
            if (vVar.e == i) {
                return;
            }
            vVar.e = i;
            for (WeakReference<v$b> weakReference : vVar.c) {
                v$b v_b = weakReference.get();
                if (v_b != null) {
                    v_b.a(i);
                } else {
                    vVar.c.remove(weakReference);
                }
            }
        }
    }
}
