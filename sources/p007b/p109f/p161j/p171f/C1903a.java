package p007b.p109f.p161j.p171f;

import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p181p.AbstractC1965b;
import p007b.p109f.p161j.p181p.C1973d1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.f.j.f.a */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1903a<T> extends AbstractC1965b<T> {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC1904b f3865b;

    public C1903a(AbstractC1904b abstractC1904b) {
        this.f3865b = abstractC1904b;
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1965b
    /* JADX INFO: renamed from: g */
    public void mo1318g() {
        AbstractC1904b abstractC1904b = this.f3865b;
        synchronized (abstractC1904b) {
            C1460d.m419B(abstractC1904b.m1025i());
        }
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1965b
    /* JADX INFO: renamed from: h */
    public void mo1319h(Throwable th) {
        AbstractC1904b abstractC1904b = this.f3865b;
        if (abstractC1904b.m1027k(th, abstractC1904b.f3866h.mo1443a())) {
            abstractC1904b.f3867i.mo1361h(abstractC1904b.f3866h, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p109f.p161j.p181p.AbstractC1965b
    /* JADX INFO: renamed from: i */
    public void mo1320i(T t, int i) {
        AbstractC1904b abstractC1904b = this.f3865b;
        C1973d1 c1973d1 = abstractC1904b.f3866h;
        C1906d c1906d = (C1906d) abstractC1904b;
        Objects.requireNonNull(c1906d);
        CloseableReference closeableReferenceM8636n = CloseableReference.m8636n((CloseableReference) t);
        boolean zM1419e = AbstractC1965b.m1419e(i);
        if (c1906d.m1029m(closeableReferenceM8636n, zM1419e, c1973d1.mo1443a()) && zM1419e) {
            c1906d.f3867i.mo1359f(c1906d.f3866h);
        }
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1965b
    /* JADX INFO: renamed from: j */
    public void mo1321j(float f) {
        this.f3865b.m1028l(f);
    }
}
