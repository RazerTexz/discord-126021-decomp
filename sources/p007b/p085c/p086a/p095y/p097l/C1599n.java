package p007b.p085c.p086a.p095y.p097l;

import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1541q;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1579h;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.n */
/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class C1599n implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2815a;

    /* JADX INFO: renamed from: b */
    public final int f2816b;

    /* JADX INFO: renamed from: c */
    public final C1579h f2817c;

    /* JADX INFO: renamed from: d */
    public final boolean f2818d;

    public C1599n(String str, int i, C1579h c1579h, boolean z2) {
        this.f2815a = str;
        this.f2816b = i;
        this.f2817c = c1579h;
        this.f2818d = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1541q(c1511j, abstractC1603b, this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ShapePath{name=");
        sbM833U.append(this.f2815a);
        sbM833U.append(", index=");
        return C1643a.m813A(sbM833U, this.f2816b, '}');
    }
}
