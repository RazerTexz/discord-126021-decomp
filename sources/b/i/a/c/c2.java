package b.i.a.c;

import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: compiled from: PlaylistTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c2 extends r0 {
    public final int n;
    public final int o;
    public final int[] p;
    public final int[] q;
    public final o2[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object[] f895s;
    public final HashMap<Object, Integer> t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(Collection<? extends t1> collection, b.i.a.c.a3.k0 k0Var) {
        super(false, k0Var);
        int iP = 0;
        int size = collection.size();
        this.p = new int[size];
        this.q = new int[size];
        this.r = new o2[size];
        this.f895s = new Object[size];
        this.t = new HashMap<>();
        int i = 0;
        int i2 = 0;
        for (t1 t1Var : collection) {
            this.r[i2] = t1Var.a();
            this.q[i2] = iP;
            this.p[i2] = i;
            iP += this.r[i2].p();
            i += this.r[i2].i();
            this.f895s[i2] = t1Var.getUid();
            this.t.put(this.f895s[i2], Integer.valueOf(i2));
            i2++;
        }
        this.n = iP;
        this.o = i;
    }

    @Override // b.i.a.c.o2
    public int i() {
        return this.o;
    }

    @Override // b.i.a.c.o2
    public int p() {
        return this.n;
    }
}
