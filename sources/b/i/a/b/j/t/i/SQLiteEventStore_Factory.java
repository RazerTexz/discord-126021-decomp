package b.i.a.b.j.t.i;

import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.u, reason: use source file name */
/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SQLiteEventStore_Factory implements Provider3 {
    public final Provider3<Clock3> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<Clock3> f803b;
    public final Provider3<EventStoreConfig> c;
    public final Provider3<SchemaManager5> d;

    public SQLiteEventStore_Factory(Provider3<Clock3> provider3, Provider3<Clock3> provider4, Provider3<EventStoreConfig> provider5, Provider3<SchemaManager5> provider6) {
        this.a = provider3;
        this.f803b = provider4;
        this.c = provider5;
        this.d = provider6;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new t(this.a.get(), this.f803b.get(), this.c.get(), this.d.get());
    }
}
