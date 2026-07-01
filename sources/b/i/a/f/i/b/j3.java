package b.i.a.f.i.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j3<V> {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1539b;
    public final h3<V> c;
    public final V d;
    public final V e;
    public final Object f = new Object();

    @GuardedBy("cachingLock")
    public volatile V g = null;

    /* JADX WARN: Multi-variable type inference failed */
    public j3(String str, Object obj, Object obj2, h3 h3Var, f3 f3Var) {
        this.f1539b = str;
        this.d = obj;
        this.e = obj2;
        this.c = h3Var;
    }

    public final V a(@Nullable V v) {
        synchronized (this.f) {
        }
        if (v != null) {
            return v;
        }
        if (b.i.a.f.e.o.f.c == null) {
            return this.d;
        }
        synchronized (a) {
            if (ga.a()) {
                return this.g == null ? this.d : this.g;
            }
            try {
                for (j3<?> j3Var : p.a) {
                    if (ga.a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        h3<?> h3Var = j3Var.c;
                        if (h3Var != null) {
                            v2 = (V) h3Var.a();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (a) {
                        j3Var.g = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            h3<V> h3Var2 = this.c;
            if (h3Var2 == null) {
                return this.d;
            }
            try {
                return h3Var2.a();
            } catch (IllegalStateException unused3) {
                return this.d;
            } catch (SecurityException unused4) {
                return this.d;
            }
        }
    }
}
