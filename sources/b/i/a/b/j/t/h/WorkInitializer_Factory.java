package b.i.a.b.j.t.h;

import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import c0.a.Provider3;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.q, reason: use source file name */
/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkInitializer_Factory implements Provider3 {
    public final Provider3<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<EventStore> f794b;
    public final Provider3<WorkScheduler> c;
    public final Provider3<SynchronizationGuard> d;

    public WorkInitializer_Factory(Provider3<Executor> provider3, Provider3<EventStore> provider4, Provider3<WorkScheduler> provider5, Provider3<SynchronizationGuard> provider6) {
        this.a = provider3;
        this.f794b = provider4;
        this.c = provider5;
        this.d = provider6;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new WorkInitializer3(this.a.get(), this.f794b.get(), this.c.get(), this.d.get());
    }
}
