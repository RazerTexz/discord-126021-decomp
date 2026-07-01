package b.i.a.b.j;

import android.content.Context;
import b.i.a.b.j.t.h.q;
import b.i.a.b.j.t.h.r;
import b.i.a.b.j.t.i.a0;
import b.i.a.b.j.t.i.e$a;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.t.i.u;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends o {
    public c0.a.a<Executor> j;
    public c0.a.a<Context> k;
    public c0.a.a l;
    public c0.a.a m;
    public c0.a.a n;
    public c0.a.a<t> o;
    public c0.a.a<b.i.a.b.j.t.h.f> p;
    public c0.a.a<r> q;
    public c0.a.a<b.i.a.b.j.t.c> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c0.a.a<b.i.a.b.j.t.h.l> f765s;
    public c0.a.a<b.i.a.b.j.t.h.p> t;
    public c0.a.a<n> u;

    public c(Context context, c$a c_a) {
        c0.a.a<Executor> aVar = g$a.a;
        Object obj = b.i.a.b.j.r.a.a.a;
        this.j = aVar instanceof b.i.a.b.j.r.a.a ? aVar : new b.i.a.b.j.r.a.a(aVar);
        Objects.requireNonNull(context, "instance cannot be null");
        b.i.a.b.j.r.a.b bVar = new b.i.a.b.j.r.a.b(context);
        this.k = bVar;
        b.i.a.b.j.v.b bVar2 = b.i.a.b.j.v.b$a.a;
        b.i.a.b.j.v.c cVar = b.i.a.b.j.v.c$a.a;
        b.i.a.b.j.q.j jVar = new b.i.a.b.j.q.j(bVar, bVar2, cVar);
        this.l = jVar;
        c0.a.a lVar = new b.i.a.b.j.q.l(bVar, jVar);
        this.m = lVar instanceof b.i.a.b.j.r.a.a ? lVar : new b.i.a.b.j.r.a.a(lVar);
        a0 a0Var = new a0(this.k, e$a.a, b.i.a.b.j.t.i.f$a.a);
        this.n = a0Var;
        u uVar = new u(bVar2, cVar, b.i.a.b.j.t.i.g$a.a, a0Var);
        c0.a.a<t> aVar2 = uVar instanceof b.i.a.b.j.r.a.a ? uVar : new b.i.a.b.j.r.a.a<>(uVar);
        this.o = aVar2;
        b.i.a.b.j.t.f fVar = new b.i.a.b.j.t.f(bVar2);
        this.p = fVar;
        c0.a.a<Context> aVar3 = this.k;
        b.i.a.b.j.t.g gVar = new b.i.a.b.j.t.g(aVar3, aVar2, fVar, cVar);
        this.q = gVar;
        c0.a.a<Executor> aVar4 = this.j;
        c0.a.a aVar5 = this.m;
        b.i.a.b.j.t.d dVar = new b.i.a.b.j.t.d(aVar4, aVar5, gVar, aVar2, aVar2);
        this.r = dVar;
        b.i.a.b.j.t.h.m mVar = new b.i.a.b.j.t.h.m(aVar3, aVar5, aVar2, gVar, aVar4, aVar2, bVar2);
        this.f765s = mVar;
        q qVar = new q(aVar4, aVar2, gVar, aVar2);
        this.t = qVar;
        c0.a.a<n> pVar = new p(bVar2, cVar, dVar, mVar, qVar);
        this.u = pVar instanceof b.i.a.b.j.r.a.a ? pVar : new b.i.a.b.j.r.a.a(pVar);
    }
}
