package p007b.p085c.p086a.p095y.p097l;

import android.graphics.Path;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1532h;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1574c;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1577f;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.y.l.d */
/* JADX INFO: compiled from: GradientFill.java */
/* JADX INFO: loaded from: classes.dex */
public class C1589d implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final int f2746a;

    /* JADX INFO: renamed from: b */
    public final Path.FillType f2747b;

    /* JADX INFO: renamed from: c */
    public final C1574c f2748c;

    /* JADX INFO: renamed from: d */
    public final C1575d f2749d;

    /* JADX INFO: renamed from: e */
    public final C1577f f2750e;

    /* JADX INFO: renamed from: f */
    public final C1577f f2751f;

    /* JADX INFO: renamed from: g */
    public final String f2752g;

    /* JADX INFO: renamed from: h */
    public final boolean f2753h;

    public C1589d(String str, int i, Path.FillType fillType, C1574c c1574c, C1575d c1575d, C1577f c1577f, C1577f c1577f2, C1573b c1573b, C1573b c1573b2, boolean z2) {
        this.f2746a = i;
        this.f2747b = fillType;
        this.f2748c = c1574c;
        this.f2749d = c1575d;
        this.f2750e = c1577f;
        this.f2751f = c1577f2;
        this.f2752g = str;
        this.f2753h = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1532h(c1511j, abstractC1603b, this);
    }
}
