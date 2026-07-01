package b.i.a.b.j.t;

import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.t.h.WorkScheduler;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import c0.a.Provider3;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.b.j.t.d, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultScheduler_Factory implements Provider3 {
    public final Provider3<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<BackendRegistry> f782b;
    public final Provider3<WorkScheduler> c;
    public final Provider3<EventStore> d;
    public final Provider3<SynchronizationGuard> e;

    public DefaultScheduler_Factory(Provider3<Executor> provider3, Provider3<BackendRegistry> provider4, Provider3<WorkScheduler> provider5, Provider3<EventStore> provider6, Provider3<SynchronizationGuard> provider7) {
        this.a = provider3;
        this.f782b = provider4;
        this.c = provider5;
        this.d = provider6;
        this.e = provider7;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new DefaultScheduler3(this.a.get(), this.f782b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
