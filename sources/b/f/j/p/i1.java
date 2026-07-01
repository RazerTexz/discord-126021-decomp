package b.f.j.p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1<T> implements w0<T> {
    public final w0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f616b;
    public final ConcurrentLinkedQueue<Pair<l<T>, x0>> c;
    public final Executor d;

    public i1(int i, Executor executor, w0<T> w0Var) {
        Objects.requireNonNull(executor);
        this.d = executor;
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.c = new ConcurrentLinkedQueue<>();
        this.f616b = 0;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        boolean z2;
        x0Var.o().e(x0Var, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f616b;
            z2 = true;
            if (i >= 5) {
                this.c.add(Pair.create(lVar, x0Var));
            } else {
                this.f616b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        x0Var.o().j(x0Var, "ThrottlingProducer", null);
        this.a.b(new i1$b(this, lVar, null), x0Var);
    }
}
