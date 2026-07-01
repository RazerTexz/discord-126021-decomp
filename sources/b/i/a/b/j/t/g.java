package b.i.a.b.j.t;

import android.content.Context;

/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements c0.a.a {
    public final c0.a.a<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.t.i.c> f783b;
    public final c0.a.a<b.i.a.b.j.t.h.f> c;
    public final c0.a.a<b.i.a.b.j.v.a> d;

    public g(c0.a.a<Context> aVar, c0.a.a<b.i.a.b.j.t.i.c> aVar2, c0.a.a<b.i.a.b.j.t.h.f> aVar3, c0.a.a<b.i.a.b.j.v.a> aVar4) {
        this.a = aVar;
        this.f783b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    @Override // c0.a.a
    public Object get() {
        Context context = this.a.get();
        b.i.a.b.j.t.i.c cVar = this.f783b.get();
        b.i.a.b.j.t.h.f fVar = this.c.get();
        this.d.get();
        return new b.i.a.b.j.t.h.d(context, cVar, fVar);
    }
}
