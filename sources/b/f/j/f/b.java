package b.f.j.f;

import b.f.j.p.d1;
import b.f.j.p.w0;

/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> extends b.f.e.c<T> {
    public final d1 h;
    public final b.f.j.k.d i;

    public b(w0<T> w0Var, d1 d1Var, b.f.j.k.d dVar) {
        b.f.j.r.b.b();
        this.h = d1Var;
        this.i = dVar;
        this.a = d1Var.h;
        b.f.j.r.b.b();
        dVar.b(d1Var);
        b.f.j.r.b.b();
        b.f.j.r.b.b();
        w0Var.b(new a(this), d1Var);
        b.f.j.r.b.b();
        b.f.j.r.b.b();
    }

    @Override // b.f.e.c, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (c()) {
            return true;
        }
        this.i.i(this.h);
        this.h.u();
        return true;
    }
}
