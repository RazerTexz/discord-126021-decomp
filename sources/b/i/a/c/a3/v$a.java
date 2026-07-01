package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;

/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$a extends r {
    public static final Object l = new Object();

    @Nullable
    public final Object m;

    @Nullable
    public final Object n;

    public v$a(o2 o2Var, @Nullable Object obj, @Nullable Object obj2) {
        super(o2Var);
        this.m = obj;
        this.n = obj2;
    }

    @Override // b.i.a.c.a3.r, b.i.a.c.o2
    public int b(Object obj) {
        Object obj2;
        o2 o2Var = this.k;
        if (l.equals(obj) && (obj2 = this.n) != null) {
            obj = obj2;
        }
        return o2Var.b(obj);
    }

    @Override // b.i.a.c.o2
    public o2$b g(int i, o2$b o2_b, boolean z2) {
        this.k.g(i, o2_b, z2);
        if (b.i.a.c.f3.e0.a(o2_b.k, this.n) && z2) {
            o2_b.k = l;
        }
        return o2_b;
    }

    @Override // b.i.a.c.a3.r, b.i.a.c.o2
    public Object m(int i) {
        Object objM = this.k.m(i);
        return b.i.a.c.f3.e0.a(objM, this.n) ? l : objM;
    }

    @Override // b.i.a.c.o2
    public o2$c o(int i, o2$c o2_c, long j) {
        this.k.o(i, o2_c, j);
        if (b.i.a.c.f3.e0.a(o2_c.n, this.m)) {
            o2_c.n = o2$c.j;
        }
        return o2_c;
    }
}
