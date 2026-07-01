package b.g.a.c.c0;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: TypeResolutionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0$a implements e0 {
    public final b.g.a.c.h0.n j;
    public final b.g.a.c.h0.m k;

    public e0$a(b.g.a.c.h0.n nVar, b.g.a.c.h0.m mVar) {
        this.j = nVar;
        this.k = mVar;
    }

    @Override // b.g.a.c.c0.e0
    public b.g.a.c.j a(Type type) {
        return this.j.b(null, type, this.k);
    }
}
