package b.i.a.f.h.n;

import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends k {
    public final transient int l;
    public final transient int m;
    public final /* synthetic */ k zzc;

    public j(k kVar, int i, int i2) {
        this.zzc = kVar;
        this.l = i;
        this.m = i2;
    }

    @Override // b.i.a.f.h.n.h
    public final int d() {
        return this.zzc.e() + this.l + this.m;
    }

    @Override // b.i.a.f.h.n.h
    public final int e() {
        return this.zzc.e() + this.l;
    }

    @Override // b.i.a.f.h.n.h
    public final Object[] g() {
        return this.zzc.g();
    }

    @Override // java.util.List
    public final Object get(int i) {
        b.i.a.f.e.o.f.F1(i, this.m, "index");
        return this.zzc.get(i + this.l);
    }

    @Override // b.i.a.f.h.n.k
    public final k h(int i, int i2) {
        b.i.a.f.e.o.f.s2(i, i2, this.m);
        k kVar = this.zzc;
        int i3 = this.l;
        return kVar.h(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.m;
    }

    @Override // b.i.a.f.h.n.k, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return h(i, i2);
    }
}
