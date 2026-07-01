package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0 implements Callable<Task<Void>> {
    public final /* synthetic */ b.i.c.m.d.s.d j;
    public final /* synthetic */ k0 k;

    public j0(k0 k0Var, b.i.c.m.d.s.d dVar) {
        this.k = k0Var;
        this.j = dVar;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return k0.a(this.k, this.j);
    }
}
