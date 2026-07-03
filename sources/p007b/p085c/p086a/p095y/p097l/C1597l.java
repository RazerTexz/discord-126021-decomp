package p007b.p085c.p086a.p095y.p097l;

import android.graphics.Path;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1531g;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.l.l */
/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class C1597l implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final boolean f2806a;

    /* JADX INFO: renamed from: b */
    public final Path.FillType f2807b;

    /* JADX INFO: renamed from: c */
    public final String f2808c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final C1572a f2809d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final C1575d f2810e;

    /* JADX INFO: renamed from: f */
    public final boolean f2811f;

    public C1597l(String str, boolean z2, Path.FillType fillType, @Nullable C1572a c1572a, @Nullable C1575d c1575d, boolean z3) {
        this.f2808c = str;
        this.f2806a = z2;
        this.f2807b = fillType;
        this.f2809d = c1572a;
        this.f2810e = c1575d;
        this.f2811f = z3;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1531g(c1511j, abstractC1603b, this);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ShapeFill{color=, fillEnabled=");
        sbM833U.append(this.f2806a);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
