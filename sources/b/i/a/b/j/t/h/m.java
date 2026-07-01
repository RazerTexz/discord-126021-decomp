package b.i.a.b.j.t.h;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements c0.a.a {
    public final c0.a.a<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.q.e> f792b;
    public final c0.a.a<b.i.a.b.j.t.i.c> c;
    public final c0.a.a<r> d;
    public final c0.a.a<Executor> e;
    public final c0.a.a<b.i.a.b.j.u.a> f;
    public final c0.a.a<b.i.a.b.j.v.a> g;

    public m(c0.a.a<Context> aVar, c0.a.a<b.i.a.b.j.q.e> aVar2, c0.a.a<b.i.a.b.j.t.i.c> aVar3, c0.a.a<r> aVar4, c0.a.a<Executor> aVar5, c0.a.a<b.i.a.b.j.u.a> aVar6, c0.a.a<b.i.a.b.j.v.a> aVar7) {
        this.a = aVar;
        this.f792b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
    }

    @Override // c0.a.a
    public Object get() {
        return new l(this.a.get(), this.f792b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
