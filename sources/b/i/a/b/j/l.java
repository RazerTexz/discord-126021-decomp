package b.i.a.b.j;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l<T> implements b.i.a.b.f<T> {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f768b;
    public final b.i.a.b.b c;
    public final b.i.a.b.e<T, byte[]> d;
    public final m e;

    public l(i iVar, String str, b.i.a.b.b bVar, b.i.a.b.e<T, byte[]> eVar, m mVar) {
        this.a = iVar;
        this.f768b = str;
        this.c = bVar;
        this.d = eVar;
        this.e = mVar;
    }

    @Override // b.i.a.b.f
    public void a(b.i.a.b.c<T> cVar) {
        b(cVar, k.a);
    }

    @Override // b.i.a.b.f
    public void b(b.i.a.b.c<T> cVar, b.i.a.b.h hVar) {
        m mVar = this.e;
        i iVar = this.a;
        Objects.requireNonNull(iVar, "Null transportContext");
        Objects.requireNonNull(cVar, "Null event");
        String str = this.f768b;
        Objects.requireNonNull(str, "Null transportName");
        b.i.a.b.e<T, byte[]> eVar = this.d;
        Objects.requireNonNull(eVar, "Null transformer");
        b.i.a.b.b bVar = this.c;
        Objects.requireNonNull(bVar, "Null encoding");
        n nVar = (n) mVar;
        b.i.a.b.j.t.e eVar2 = nVar.d;
        b.i.a.b.d dVarC = cVar.c();
        i$a i_aA = i.a();
        i_aA.b(iVar.b());
        i_aA.c(dVarC);
        b$b b_b = (b$b) i_aA;
        b_b.f764b = iVar.c();
        i iVarA = b_b.a();
        a$b a_b = new a$b();
        a_b.f = new HashMap();
        a_b.e(nVar.f769b.a());
        a_b.g(nVar.c.a());
        a_b.f(str);
        a_b.d(new e(bVar, eVar.apply(cVar.b())));
        a_b.f762b = cVar.a();
        eVar2.a(iVarA, a_b.b(), hVar);
    }
}
