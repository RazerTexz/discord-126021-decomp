package p007b.p085c.p086a.p095y.p098m;

import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;

/* JADX INFO: renamed from: b.c.a.y.m.a */
/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1602a implements AbstractC1544a.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC1603b f2835a;

    public C1602a(AbstractC1603b abstractC1603b) {
        this.f2835a = abstractC1603b;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        AbstractC1603b abstractC1603b = this.f2835a;
        boolean z2 = abstractC1603b.f2852q.m739j() == 1.0f;
        if (z2 != abstractC1603b.f2858w) {
            abstractC1603b.f2858w = z2;
            abstractC1603b.f2849n.invalidateSelf();
        }
    }
}
