package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzij;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class h5 {
    public volatile c6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile t3 f1448b;

    static {
        h4.a();
    }

    public final int a() {
        if (this.f1448b != null) {
            return this.f1448b.d();
        }
        if (this.a != null) {
            return this.a.g();
        }
        return 0;
    }

    public final c6 b(c6 c6Var) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        try {
                            this.a = c6Var;
                            this.f1448b = t3.j;
                        } catch (zzij unused) {
                            this.a = c6Var;
                            this.f1448b = t3.j;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.a;
    }

    public final t3 c() {
        if (this.f1448b != null) {
            return this.f1448b;
        }
        synchronized (this) {
            if (this.f1448b != null) {
                return this.f1448b;
            }
            if (this.a == null) {
                this.f1448b = t3.j;
            } else {
                this.f1448b = this.a.b();
            }
            return this.f1448b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h5)) {
            return false;
        }
        h5 h5Var = (h5) obj;
        c6 c6Var = this.a;
        c6 c6Var2 = h5Var.a;
        if (c6Var == null && c6Var2 == null) {
            return c().equals(h5Var.c());
        }
        if (c6Var == null || c6Var2 == null) {
            return c6Var != null ? c6Var.equals(h5Var.b(c6Var.k())) : b(c6Var2.k()).equals(c6Var2);
        }
        return c6Var.equals(c6Var2);
    }

    public int hashCode() {
        return 1;
    }
}
