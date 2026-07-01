package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.q.b$d;
import com.google.android.gms.tasks.Task;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 implements b.i.a.f.n.f<b.i.c.m.d.s.h.b, Void> {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1682b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ g0 d;

    public f0(g0 g0Var, List list, boolean z2, Executor executor) {
        this.d = g0Var;
        this.a = list;
        this.f1682b = z2;
        this.c = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable b.i.c.m.d.s.h.b bVar) throws Exception {
        b.i.c.m.d.s.h.b bVar2 = bVar;
        if (bVar2 == null) {
            b.i.c.m.d.b.a.g("Received null app settings, cannot send reports during app startup.");
            return b.i.a.f.e.o.f.Z(null);
        }
        for (b.i.c.m.d.q.c.c cVar : this.a) {
            if (cVar.d() == 1) {
                x.c(bVar2.e, cVar.c());
            }
        }
        x.b(this.d.k.c);
        b.i.c.m.d.q.b bVarA = ((h0) this.d.k.c.r).a(bVar2);
        List list = this.a;
        boolean z2 = this.f1682b;
        float f = this.d.k.f1704b;
        synchronized (bVarA) {
            if (bVarA.h != null) {
                b.i.c.m.d.b.a.b("Report upload has already been started.");
            } else {
                Thread thread = new Thread(new b$d(bVarA, list, z2, f), "Crashlytics Report Uploader");
                bVarA.h = thread;
                thread.start();
            }
        }
        this.d.k.c.A.b(this.c, b.c.a.y.b.m(bVar2));
        this.d.k.c.E.b(null);
        return b.i.a.f.e.o.f.Z(null);
    }
}
