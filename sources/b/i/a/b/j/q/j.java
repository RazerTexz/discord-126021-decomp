package b.i.a.b.j.q;

import android.content.Context;

/* JADX INFO: compiled from: CreationContextFactory_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements c0.a.a {
    public final c0.a.a<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<b.i.a.b.j.v.a> f775b;
    public final c0.a.a<b.i.a.b.j.v.a> c;

    public j(c0.a.a<Context> aVar, c0.a.a<b.i.a.b.j.v.a> aVar2, c0.a.a<b.i.a.b.j.v.a> aVar3) {
        this.a = aVar;
        this.f775b = aVar2;
        this.c = aVar3;
    }

    @Override // c0.a.a
    public Object get() {
        return new i(this.a.get(), this.f775b.get(), this.c.get());
    }
}
