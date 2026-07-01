package b.i.c.k.d;

import android.os.RemoteException;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.p;
import b.i.a.f.h.k.g;
import b.i.a.f.h.k.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends p<g, Void> implements b.i.a.f.e.h.j.e<Status> {
    public TaskCompletionSource<Void> c;

    public e(d dVar) {
    }

    @Override // b.i.a.f.e.h.j.e
    public void a(Status status) {
        AnimatableValueParser.o(!status.w0(), "Failed result must not be success.");
        this.c.a.t(b.i.a.f.e.o.f.R1(status, status.q));
    }

    @Override // b.i.a.f.e.h.j.e
    public void b(Object obj) {
        Status status = (Status) obj;
        if (status.w0()) {
            this.c.a.s(null);
            return;
        }
        TaskCompletionSource<Void> taskCompletionSource = this.c;
        taskCompletionSource.a.t(b.i.a.f.e.o.f.R1(status, "User Action indexing error, please try again."));
    }

    @Override // b.i.a.f.e.h.j.p
    public void c(a.b bVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.c = taskCompletionSource;
        d dVar = (d) this;
        ((b.i.a.f.h.k.b) ((g) bVar).w()).S(new h(dVar), dVar.d);
    }
}
