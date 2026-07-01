package b.o.a.n.v;

import b.i.a.f.n.c0;
import b.o.a.n.i$c;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$b<T> implements Callable<Task<T>> {
    public final /* synthetic */ e j;
    public final /* synthetic */ String k;
    public final /* synthetic */ e l;
    public final /* synthetic */ Callable m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ f o;

    public f$b(f fVar, e eVar, String str, e eVar2, Callable callable, boolean z2) {
        this.o = fVar;
        this.j = eVar;
        this.k = str;
        this.l = eVar2;
        this.m = callable;
        this.n = z2;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        f fVar = this.o;
        if (fVar.f == this.j) {
            return ((Task) this.m.call()).j(((i$c) fVar.f1941b).a.k.g, new g(this));
        }
        a.a.a(2, this.k.toUpperCase(), "- State mismatch, aborting. current:", this.o.f, "from:", this.j, "to:", this.l);
        c0 c0Var = new c0();
        c0Var.u();
        return c0Var;
    }
}
