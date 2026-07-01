package b.i.a.b.j.t.i;

import b.i.a.b.j.t.i.SchemaManager5;
import c0.a.Provider3;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.f, reason: use source file name */
/* JADX INFO: compiled from: EventStoreModule_SchemaVersionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EventStoreModule_SchemaVersionFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.f$a */
    /* JADX INFO: compiled from: EventStoreModule_SchemaVersionFactory.java */
    public static final class a {
        public static final EventStoreModule_SchemaVersionFactory a = new EventStoreModule_SchemaVersionFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        List<SchemaManager5.a> list = SchemaManager5.j;
        return 4;
    }
}
