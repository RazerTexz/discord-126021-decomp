package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p095y.p097l.C1596k;
import p007b.p085c.p086a.p095y.p097l.C1599n;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.q */
/* JADX INFO: compiled from: ShapeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1541q implements InterfaceC1537m, AbstractC1544a.b {

    /* JADX INFO: renamed from: b */
    public final boolean f2580b;

    /* JADX INFO: renamed from: c */
    public final C1511j f2581c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1544a<?, Path> f2582d;

    /* JADX INFO: renamed from: e */
    public boolean f2583e;

    /* JADX INFO: renamed from: a */
    public final Path f2579a = new Path();

    /* JADX INFO: renamed from: f */
    public C1526b f2584f = new C1526b();

    public C1541q(C1511j c1511j, AbstractC1603b abstractC1603b, C1599n c1599n) {
        this.f2580b = c1599n.f2818d;
        this.f2581c = c1511j;
        AbstractC1544a<C1596k, Path> abstractC1544aMo773a = c1599n.f2817c.mo773a();
        this.f2582d = abstractC1544aMo773a;
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1544aMo773a.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2583e = false;
        this.f2581c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC1527c interfaceC1527c = list.get(i);
            if (interfaceC1527c instanceof C1543s) {
                C1543s c1543s = (C1543s) interfaceC1527c;
                if (c1543s.f2592c == 1) {
                    this.f2584f.f2481a.add(c1543s);
                    c1543s.f2591b.add(this);
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        if (this.f2583e) {
            return this.f2579a;
        }
        this.f2579a.reset();
        if (this.f2580b) {
            this.f2583e = true;
            return this.f2579a;
        }
        this.f2579a.set(this.f2582d.mo727e());
        this.f2579a.setFillType(Path.FillType.EVEN_ODD);
        this.f2584f.m715a(this.f2579a);
        this.f2583e = true;
        return this.f2579a;
    }
}
