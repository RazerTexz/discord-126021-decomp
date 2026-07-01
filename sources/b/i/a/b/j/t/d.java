package b.i.a.b.j.t;

import b.i.a.b.j.t.h.r;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c0.a.a {
    public final c0.a.a<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.q.e> f782b;
    public final c0.a.a<r> c;
    public final c0.a.a<b.i.a.b.j.t.i.c> d;
    public final c0.a.a<b.i.a.b.j.u.a> e;

    public d(c0.a.a<Executor> aVar, c0.a.a<b.i.a.b.j.q.e> aVar2, c0.a.a<r> aVar3, c0.a.a<b.i.a.b.j.t.i.c> aVar4, c0.a.a<b.i.a.b.j.u.a> aVar5) {
        this.a = aVar;
        this.f782b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    @Override // c0.a.a
    public Object get() {
        return new c(this.a.get(), this.f782b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
