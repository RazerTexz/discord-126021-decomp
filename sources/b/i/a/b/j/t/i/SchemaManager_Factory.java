package b.i.a.b.j.t.i;

import android.content.Context;
import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.a0, reason: use source file name */
/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchemaManager_Factory implements Provider3 {
    public final Provider3<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<String> f796b;
    public final Provider3<Integer> c;

    public SchemaManager_Factory(Provider3<Context> provider3, Provider3<String> provider4, Provider3<Integer> provider5) {
        this.a = provider3;
        this.f796b = provider4;
        this.c = provider5;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new SchemaManager5(this.a.get(), this.f796b.get(), this.c.get().intValue());
    }
}
