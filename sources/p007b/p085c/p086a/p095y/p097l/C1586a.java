package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1530f;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1577f;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.y.l.a */
/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class C1586a implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2739a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1584m<PointF, PointF> f2740b;

    /* JADX INFO: renamed from: c */
    public final C1577f f2741c;

    /* JADX INFO: renamed from: d */
    public final boolean f2742d;

    /* JADX INFO: renamed from: e */
    public final boolean f2743e;

    public C1586a(String str, InterfaceC1584m<PointF, PointF> interfaceC1584m, C1577f c1577f, boolean z2, boolean z3) {
        this.f2739a = str;
        this.f2740b = interfaceC1584m;
        this.f2741c = c1577f;
        this.f2742d = z2;
        this.f2743e = z3;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1530f(c1511j, abstractC1603b, this);
    }
}
