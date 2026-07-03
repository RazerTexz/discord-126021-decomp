package p007b.p085c.p086a.p091w.p092b;

import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p095y.p097l.C1601p;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.s */
/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1543s implements InterfaceC1527c, AbstractC1544a.b {

    /* JADX INFO: renamed from: a */
    public final boolean f2590a;

    /* JADX INFO: renamed from: b */
    public final List<AbstractC1544a.b> f2591b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final int f2592c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1544a<?, Float> f2593d;

    /* JADX INFO: renamed from: e */
    public final AbstractC1544a<?, Float> f2594e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1544a<?, Float> f2595f;

    public C1543s(AbstractC1603b abstractC1603b, C1601p c1601p) {
        this.f2590a = c1601p.f2834f;
        this.f2592c = c1601p.f2830b;
        AbstractC1544a<Float, Float> abstractC1544aMo773a = c1601p.f2831c.mo773a();
        this.f2593d = abstractC1544aMo773a;
        AbstractC1544a<Float, Float> abstractC1544aMo773a2 = c1601p.f2832d.mo773a();
        this.f2594e = abstractC1544aMo773a2;
        AbstractC1544a<Float, Float> abstractC1544aMo773a3 = c1601p.f2833e.mo773a();
        this.f2595f = abstractC1544aMo773a3;
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        abstractC1603b.m777e(abstractC1544aMo773a3);
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1544aMo773a3.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        for (int i = 0; i < this.f2591b.size(); i++) {
            this.f2591b.get(i).mo709a();
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
    }
}
