package b.i.a.b.j.t.h;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements c0.a.a {
    public final c0.a.a<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.t.i.c> f794b;
    public final c0.a.a<r> c;
    public final c0.a.a<b.i.a.b.j.u.a> d;

    public q(c0.a.a<Executor> aVar, c0.a.a<b.i.a.b.j.t.i.c> aVar2, c0.a.a<r> aVar3, c0.a.a<b.i.a.b.j.u.a> aVar4) {
        this.a = aVar;
        this.f794b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // c0.a.a
    public Object get() {
        return new p(this.a.get(), this.f794b.get(), this.c.get(), this.d.get());
    }
}
