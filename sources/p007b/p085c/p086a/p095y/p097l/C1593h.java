package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1538n;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.y.l.h */
/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class C1593h implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2780a;

    /* JADX INFO: renamed from: b */
    public final a f2781b;

    /* JADX INFO: renamed from: c */
    public final C1573b f2782c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1584m<PointF, PointF> f2783d;

    /* JADX INFO: renamed from: e */
    public final C1573b f2784e;

    /* JADX INFO: renamed from: f */
    public final C1573b f2785f;

    /* JADX INFO: renamed from: g */
    public final C1573b f2786g;

    /* JADX INFO: renamed from: h */
    public final C1573b f2787h;

    /* JADX INFO: renamed from: i */
    public final C1573b f2788i;

    /* JADX INFO: renamed from: j */
    public final boolean f2789j;

    /* JADX INFO: renamed from: b.c.a.y.l.h$a */
    /* JADX INFO: compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: f */
        public static a m776f(int i) {
            a[] aVarArrValues = values();
            for (int i2 = 0; i2 < 2; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C1593h(String str, a aVar, C1573b c1573b, InterfaceC1584m<PointF, PointF> interfaceC1584m, C1573b c1573b2, C1573b c1573b3, C1573b c1573b4, C1573b c1573b5, C1573b c1573b6, boolean z2) {
        this.f2780a = str;
        this.f2781b = aVar;
        this.f2782c = c1573b;
        this.f2783d = interfaceC1584m;
        this.f2784e = c1573b2;
        this.f2785f = c1573b3;
        this.f2786g = c1573b4;
        this.f2787h = c1573b5;
        this.f2788i = c1573b6;
        this.f2789j = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1538n(c1511j, abstractC1603b, this);
    }
}
