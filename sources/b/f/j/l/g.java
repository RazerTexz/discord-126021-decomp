package b.f.j.l;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: BucketMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class g<T> {
    public final SparseArray<g$b<T>> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public g$b<T> f595b;

    @VisibleForTesting
    public g$b<T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(g$b<T> g_b) {
        if (this.f595b == g_b) {
            return;
        }
        b(g_b);
        g$b<T> g_b2 = this.f595b;
        if (g_b2 == 0) {
            this.f595b = g_b;
            this.c = g_b;
        } else {
            g_b.d = g_b2;
            g_b2.a = g_b;
            this.f595b = g_b;
        }
    }

    public final synchronized void b(g$b<T> g_b) {
        g$b g_b2 = (g$b<T>) g_b.a;
        g$b g_b3 = (g$b<T>) g_b.d;
        if (g_b2 != null) {
            g_b2.d = g_b3;
        }
        if (g_b3 != null) {
            g_b3.a = g_b2;
        }
        g_b.a = null;
        g_b.d = null;
        if (g_b == this.f595b) {
            this.f595b = g_b3;
        }
        if (g_b == this.c) {
            this.c = g_b2;
        }
    }
}
