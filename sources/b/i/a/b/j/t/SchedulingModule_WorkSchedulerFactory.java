package b.i.a.b.j.t;

import android.content.Context;
import b.i.a.b.j.t.h.JobInfoScheduler;
import b.i.a.b.j.t.h.SchedulerConfig;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.g, reason: use source file name */
/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Provider3 {
    public final Provider3<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider3<EventStore> f783b;
    public final Provider3<SchedulerConfig> c;
    public final Provider3<Clock3> d;

    public SchedulingModule_WorkSchedulerFactory(Provider3<Context> provider3, Provider3<EventStore> provider4, Provider3<SchedulerConfig> provider5, Provider3<Clock3> provider6) {
        this.a = provider3;
        this.f783b = provider4;
        this.c = provider5;
        this.d = provider6;
    }

    @Override // c0.a.Provider3
    public Object get() {
        Context context = this.a.get();
        EventStore eventStore = this.f783b.get();
        SchedulerConfig schedulerConfig = this.c.get();
        this.d.get();
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
