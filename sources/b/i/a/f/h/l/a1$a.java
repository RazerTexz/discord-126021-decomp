package b.i.a.f.h.l;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a1$a extends u4$b<a1, a1$a> implements d6 {
    public a1$a() {
        super(a1.N());
    }

    public final long A() {
        return ((a1) this.k).J();
    }

    public final a1$a q(int i, c1 c1Var) {
        if (this.l) {
            n();
            this.l = false;
        }
        a1.y((a1) this.k, i, c1Var);
        return this;
    }

    public final a1$a r(long j) {
        if (this.l) {
            n();
            this.l = false;
        }
        a1.z((a1) this.k, j);
        return this;
    }

    public final a1$a s(c1$a c1_a) {
        if (this.l) {
            n();
            this.l = false;
        }
        a1.A((a1) this.k, (c1) ((u4) c1_a.p()));
        return this;
    }

    public final a1$a t(String str) {
        if (this.l) {
            n();
            this.l = false;
        }
        a1.C((a1) this.k, str);
        return this;
    }

    public final c1 u(int i) {
        return ((a1) this.k).u(i);
    }

    public final List<c1> v() {
        return Collections.unmodifiableList(((a1) this.k).v());
    }

    public final int w() {
        return ((a1) this.k).D();
    }

    public final a1$a x(int i) {
        if (this.l) {
            n();
            this.l = false;
        }
        a1.x((a1) this.k, i);
        return this;
    }

    public final String y() {
        return ((a1) this.k).F();
    }

    public final long z() {
        return ((a1) this.k).H();
    }

    public a1$a(k1 k1Var) {
        super(a1.N());
    }
}
