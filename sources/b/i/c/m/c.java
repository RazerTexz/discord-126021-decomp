package b.i.c.m;

import b.i.c.m.d.e;
import b.i.c.m.d.f;
import b.i.c.m.d.h;
import b.i.c.m.d.k.h1;
import b.i.c.m.d.k.j0;
import b.i.c.m.d.k.j1;
import b.i.c.m.d.k.k0;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: FirebaseCrashlytics.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Callable<Void> {
    public final /* synthetic */ h j;
    public final /* synthetic */ ExecutorService k;
    public final /* synthetic */ b.i.c.m.d.s.c l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ k0 n;

    public c(h hVar, ExecutorService executorService, b.i.c.m.d.s.c cVar, boolean z2, k0 k0Var) {
        this.j = hVar;
        this.k = executorService;
        this.l = cVar;
        this.m = z2;
        this.n = k0Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        h hVar = this.j;
        ExecutorService executorService = this.k;
        b.i.c.m.d.s.c cVar = this.l;
        b.i.c.c cVar2 = hVar.f1674b;
        cVar2.a();
        hVar.m.c().r(executorService, new f(hVar, cVar)).r(executorService, new e(hVar, cVar2.f.f1655b, cVar, executorService));
        if (!this.m) {
            return null;
        }
        k0 k0Var = this.n;
        b.i.c.m.d.s.c cVar3 = this.l;
        ExecutorService executorService2 = k0Var.l;
        j0 j0Var = new j0(k0Var, cVar3);
        FilenameFilter filenameFilter = h1.a;
        executorService2.execute(new j1(j0Var, new TaskCompletionSource()));
        return null;
    }
}
