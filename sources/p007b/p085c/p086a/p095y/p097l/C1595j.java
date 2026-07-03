package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1540p;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.y.l.j */
/* JADX INFO: compiled from: Repeater.java */
/* JADX INFO: loaded from: classes.dex */
public class C1595j implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2798a;

    /* JADX INFO: renamed from: b */
    public final C1573b f2799b;

    /* JADX INFO: renamed from: c */
    public final C1573b f2800c;

    /* JADX INFO: renamed from: d */
    public final C1583l f2801d;

    /* JADX INFO: renamed from: e */
    public final boolean f2802e;

    public C1595j(String str, C1573b c1573b, C1573b c1573b2, C1583l c1583l, boolean z2) {
        this.f2798a = str;
        this.f2799b = c1573b;
        this.f2800c = c1573b2;
        this.f2801d = c1583l;
        this.f2802e = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    @Nullable
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1540p(c1511j, abstractC1603b, this);
    }
}
