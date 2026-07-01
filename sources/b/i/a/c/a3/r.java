package b.i.a.c.a3;

import b.i.a.c.o2;

/* JADX INFO: compiled from: ForwardingTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends o2 {
    public final o2 k;

    public r(o2 o2Var) {
        this.k = o2Var;
    }

    @Override // b.i.a.c.o2
    public int a(boolean z2) {
        return this.k.a(z2);
    }

    @Override // b.i.a.c.o2
    public int b(Object obj) {
        return this.k.b(obj);
    }

    @Override // b.i.a.c.o2
    public int c(boolean z2) {
        return this.k.c(z2);
    }

    @Override // b.i.a.c.o2
    public int e(int i, int i2, boolean z2) {
        return this.k.e(i, i2, z2);
    }

    @Override // b.i.a.c.o2
    public int i() {
        return this.k.i();
    }

    @Override // b.i.a.c.o2
    public int l(int i, int i2, boolean z2) {
        return this.k.l(i, i2, z2);
    }

    @Override // b.i.a.c.o2
    public Object m(int i) {
        return this.k.m(i);
    }

    @Override // b.i.a.c.o2
    public int p() {
        return this.k.p();
    }
}
