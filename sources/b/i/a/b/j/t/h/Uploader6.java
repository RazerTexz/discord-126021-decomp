package b.i.a.b.j.t.h;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.q.AutoValue_BackendRequest;
import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.q.BackendResponse;
import b.i.a.b.j.q.TransportBackend;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.t.i.PersistedEvent;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.l, reason: use source file name */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class Uploader6 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BackendRegistry f791b;
    public final EventStore c;
    public final WorkScheduler d;
    public final Executor e;
    public final SynchronizationGuard f;
    public final Clock3 g;

    public Uploader6(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock3 clock3) {
        this.a = context;
        this.f791b = backendRegistry;
        this.c = eventStore;
        this.d = workScheduler;
        this.e = executor;
        this.f = synchronizationGuard;
        this.g = clock3;
    }

    public void a(final TransportContext transportContext, final int i) {
        BackendResponse backendResponseA;
        TransportBackend transportBackend = this.f791b.get(transportContext.b());
        final Iterable iterable = (Iterable) this.f.a(new SynchronizationGuard.a(this, transportContext) { // from class: b.i.a.b.j.t.h.h
            public final Uploader6 a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TransportContext f788b;

            {
                this.a = this;
                this.f788b = transportContext;
            }

            @Override // b.i.a.b.j.u.SynchronizationGuard.a
            public Object execute() {
                Uploader6 uploader6 = this.a;
                return uploader6.c.r(this.f788b);
            }
        });
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                AnimatableValueParser.X("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).a());
                }
                byte[] bArrC = transportContext.c();
                if (1 == 0) {
                    throw new IllegalStateException(outline.w("Missing required properties:", ""));
                }
                backendResponseA = transportBackend.a(new AutoValue_BackendRequest(arrayList, bArrC, null));
            }
            final BackendResponse backendResponse = backendResponseA;
            this.f.a(new SynchronizationGuard.a(this, backendResponse, iterable, transportContext, i) { // from class: b.i.a.b.j.t.h.i
                public final Uploader6 a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final BackendResponse f789b;
                public final Iterable c;
                public final TransportContext d;
                public final int e;

                {
                    this.a = this;
                    this.f789b = backendResponse;
                    this.c = iterable;
                    this.d = transportContext;
                    this.e = i;
                }

                @Override // b.i.a.b.j.u.SynchronizationGuard.a
                public Object execute() {
                    Uploader6 uploader6 = this.a;
                    BackendResponse backendResponse2 = this.f789b;
                    Iterable<PersistedEvent> iterable2 = this.c;
                    TransportContext transportContext2 = this.d;
                    int i2 = this.e;
                    if (backendResponse2.c() == BackendResponse.a.TRANSIENT_ERROR) {
                        uploader6.c.n0(iterable2);
                        uploader6.d.a(transportContext2, i2 + 1);
                        return null;
                    }
                    uploader6.c.m(iterable2);
                    if (backendResponse2.c() == BackendResponse.a.OK) {
                        uploader6.c.v(transportContext2, backendResponse2.b() + uploader6.g.a());
                    }
                    if (!uploader6.c.l0(transportContext2)) {
                        return null;
                    }
                    uploader6.d.a(transportContext2, 1);
                    return null;
                }
            });
        }
    }
}
