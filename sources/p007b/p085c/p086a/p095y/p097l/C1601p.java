package p007b.p085c.p086a.p095y.p097l;

import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1543s;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.p */
/* JADX INFO: compiled from: ShapeTrimPath.java */
/* JADX INFO: loaded from: classes.dex */
public class C1601p implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2829a;

    /* JADX INFO: renamed from: b */
    public final int f2830b;

    /* JADX INFO: renamed from: c */
    public final C1573b f2831c;

    /* JADX INFO: renamed from: d */
    public final C1573b f2832d;

    /* JADX INFO: renamed from: e */
    public final C1573b f2833e;

    /* JADX INFO: renamed from: f */
    public final boolean f2834f;

    public C1601p(String str, int i, C1573b c1573b, C1573b c1573b2, C1573b c1573b3, boolean z2) {
        this.f2829a = str;
        this.f2830b = i;
        this.f2831c = c1573b;
        this.f2832d = c1573b2;
        this.f2833e = c1573b3;
        this.f2834f = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1543s(abstractC1603b, this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Trim Path: {start: ");
        sbM833U.append(this.f2831c);
        sbM833U.append(", end: ");
        sbM833U.append(this.f2832d);
        sbM833U.append(", offset: ");
        sbM833U.append(this.f2833e);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
