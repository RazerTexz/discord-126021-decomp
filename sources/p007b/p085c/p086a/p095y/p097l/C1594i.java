package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1539o;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1577f;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.i */
/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class C1594i implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2793a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1584m<PointF, PointF> f2794b;

    /* JADX INFO: renamed from: c */
    public final C1577f f2795c;

    /* JADX INFO: renamed from: d */
    public final C1573b f2796d;

    /* JADX INFO: renamed from: e */
    public final boolean f2797e;

    public C1594i(String str, InterfaceC1584m<PointF, PointF> interfaceC1584m, C1577f c1577f, C1573b c1573b, boolean z2) {
        this.f2793a = str;
        this.f2794b = interfaceC1584m;
        this.f2795c = c1577f;
        this.f2796d = c1573b;
        this.f2797e = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1539o(c1511j, abstractC1603b, this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RectangleShape{position=");
        sbM833U.append(this.f2794b);
        sbM833U.append(", size=");
        sbM833U.append(this.f2795c);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
