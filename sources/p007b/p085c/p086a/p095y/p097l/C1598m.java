package p007b.p085c.p086a.p095y.p097l;

import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1528d;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.m */
/* JADX INFO: compiled from: ShapeGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class C1598m implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2812a;

    /* JADX INFO: renamed from: b */
    public final List<InterfaceC1587b> f2813b;

    /* JADX INFO: renamed from: c */
    public final boolean f2814c;

    public C1598m(String str, List<InterfaceC1587b> list, boolean z2) {
        this.f2812a = str;
        this.f2813b = list;
        this.f2814c = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1528d(c1511j, abstractC1603b, this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ShapeGroup{name='");
        sbM833U.append(this.f2812a);
        sbM833U.append("' Shapes: ");
        sbM833U.append(Arrays.toString(this.f2813b.toArray()));
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
