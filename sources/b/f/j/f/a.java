package b.f.j.f;

import b.f.j.p.d1;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> extends b.f.j.p.b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f587b;

    public a(b bVar) {
        this.f587b = bVar;
    }

    @Override // b.f.j.p.b
    public void g() {
        b bVar = this.f587b;
        synchronized (bVar) {
            b.c.a.a0.d.B(bVar.i());
        }
    }

    @Override // b.f.j.p.b
    public void h(Throwable th) {
        b bVar = this.f587b;
        if (bVar.k(th, bVar.h.a())) {
            bVar.i.h(bVar.h, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.f.j.p.b
    public void i(T t, int i) {
        b bVar = this.f587b;
        d1 d1Var = bVar.h;
        d dVar = (d) bVar;
        Objects.requireNonNull(dVar);
        CloseableReference closeableReferenceN = CloseableReference.n((CloseableReference) t);
        boolean zE = b.f.j.p.b.e(i);
        if (dVar.m(closeableReferenceN, zE, d1Var.a()) && zE) {
            dVar.i.f(dVar.h);
        }
    }

    @Override // b.f.j.p.b
    public void j(float f) {
        this.f587b.l(f);
    }
}
