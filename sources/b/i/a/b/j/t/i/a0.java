package b.i.a.b.j.t.i;

import android.content.Context;

/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements c0.a.a {
    public final c0.a.a<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<String> f796b;
    public final c0.a.a<Integer> c;

    public a0(c0.a.a<Context> aVar, c0.a.a<String> aVar2, c0.a.a<Integer> aVar3) {
        this.a = aVar;
        this.f796b = aVar2;
        this.c = aVar3;
    }

    @Override // c0.a.a
    public Object get() {
        return new z(this.a.get(), this.f796b.get(), this.c.get().intValue());
    }
}
