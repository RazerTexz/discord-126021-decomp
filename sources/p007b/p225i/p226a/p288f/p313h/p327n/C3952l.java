package p007b.p225i.p226a.p288f.p313h.p327n;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.n.l */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3952l<E> extends AbstractC3951k<E> {

    /* JADX INFO: renamed from: l */
    public static final AbstractC3951k<Object> f10490l = new C3952l(new Object[0]);

    /* JADX INFO: renamed from: m */
    public final transient Object[] f10491m;

    public C3952l(Object[] objArr) {
        this.f10491m = objArr;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k, p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* JADX INFO: renamed from: c */
    public final int mo5430c(Object[] objArr, int i) {
        System.arraycopy(this.f10491m, 0, objArr, 0, 0);
        return 0;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* JADX INFO: renamed from: d */
    public final int mo5431d() {
        return 0;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* JADX INFO: renamed from: e */
    public final int mo5432e() {
        return 0;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3948h
    /* JADX INFO: renamed from: g */
    public final Object[] mo5433g() {
        return this.f10491m;
    }

    @Override // java.util.List
    public final E get(int i) {
        C3404f.m4206F1(i, 0, "index");
        return (E) this.f10491m[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }
}
