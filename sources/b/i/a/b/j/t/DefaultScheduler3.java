package b.i.a.b.j.t;

import b.d.b.a.outline;
import b.i.a.b.TransportScheduleCallback;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.TransportRuntime;
import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.q.TransportBackend;
import b.i.a.b.j.t.h.WorkScheduler;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: renamed from: b.i.a.b.j.t.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultScheduler3 implements Scheduler2 {
    public static final Logger a = Logger.getLogger(TransportRuntime.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WorkScheduler f781b;
    public final Executor c;
    public final BackendRegistry d;
    public final EventStore e;
    public final SynchronizationGuard f;

    public DefaultScheduler3(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.c = executor;
        this.d = backendRegistry;
        this.f781b = workScheduler;
        this.e = eventStore;
        this.f = synchronizationGuard;
    }

    @Override // b.i.a.b.j.t.Scheduler2
    public void a(final TransportContext transportContext, final EventInternal eventInternal, final TransportScheduleCallback transportScheduleCallback) {
        this.c.execute(new Runnable(this, transportContext, transportScheduleCallback, eventInternal) { // from class: b.i.a.b.j.t.a
            public final DefaultScheduler3 j;
            public final TransportContext k;
            public final TransportScheduleCallback l;
            public final EventInternal m;

            {
                this.j = this;
                this.k = transportContext;
                this.l = transportScheduleCallback;
                this.m = eventInternal;
            }

            @Override // java.lang.Runnable
            public void run() {
                final DefaultScheduler3 defaultScheduler3 = this.j;
                final TransportContext transportContext2 = this.k;
                TransportScheduleCallback transportScheduleCallback2 = this.l;
                EventInternal eventInternal2 = this.m;
                Logger logger = DefaultScheduler3.a;
                try {
                    TransportBackend transportBackend = defaultScheduler3.d.get(transportContext2.b());
                    if (transportBackend == null) {
                        String str = String.format("Transport backend '%s' is not registered", transportContext2.b());
                        DefaultScheduler3.a.warning(str);
                        transportScheduleCallback2.a(new IllegalArgumentException(str));
                    } else {
                        final EventInternal eventInternalB = transportBackend.b(eventInternal2);
                        defaultScheduler3.f.a(new SynchronizationGuard.a(defaultScheduler3, transportContext2, eventInternalB) { // from class: b.i.a.b.j.t.b
                            public final DefaultScheduler3 a;

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            public final TransportContext f780b;
                            public final EventInternal c;

                            {
                                this.a = defaultScheduler3;
                                this.f780b = transportContext2;
                                this.c = eventInternalB;
                            }

                            @Override // b.i.a.b.j.u.SynchronizationGuard.a
                            public Object execute() {
                                DefaultScheduler3 defaultScheduler4 = this.a;
                                TransportContext transportContext3 = this.f780b;
                                defaultScheduler4.e.a0(transportContext3, this.c);
                                defaultScheduler4.f781b.a(transportContext3, 1);
                                return null;
                            }
                        });
                        transportScheduleCallback2.a(null);
                    }
                } catch (Exception e) {
                    Logger logger2 = DefaultScheduler3.a;
                    StringBuilder sbU = outline.U("Error scheduling event ");
                    sbU.append(e.getMessage());
                    logger2.warning(sbU.toString());
                    transportScheduleCallback2.a(e);
                }
            }
        });
    }
}
