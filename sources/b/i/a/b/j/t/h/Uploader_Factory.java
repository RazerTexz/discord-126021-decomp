package b.i.a.b.j.t.h;

import android.content.Context;
import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.m, reason: use source file name */
/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Uploader_Factory implements Provider3 {
    public final Provider3<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<BackendRegistry> f792b;
    public final Provider3<EventStore> c;
    public final Provider3<WorkScheduler> d;
    public final Provider3<Executor> e;
    public final Provider3<SynchronizationGuard> f;
    public final Provider3<Clock3> g;

    public Uploader_Factory(Provider3<Context> provider3, Provider3<BackendRegistry> provider4, Provider3<EventStore> provider5, Provider3<WorkScheduler> provider6, Provider3<Executor> provider7, Provider3<SynchronizationGuard> provider8, Provider3<Clock3> provider9) {
        this.a = provider3;
        this.f792b = provider4;
        this.c = provider5;
        this.d = provider6;
        this.e = provider7;
        this.f = provider8;
        this.g = provider9;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new Uploader6(this.a.get(), this.f792b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
