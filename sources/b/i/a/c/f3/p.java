package b.i.a.c.f3;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p<T> {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f973b;
    public final p$b<T> c;
    public final CopyOnWriteArraySet<p$c<T>> d;
    public final ArrayDeque<Runnable> e = new ArrayDeque<>();
    public final ArrayDeque<Runnable> f = new ArrayDeque<>();
    public boolean g;

    public p(CopyOnWriteArraySet<p$c<T>> copyOnWriteArraySet, Looper looper, g gVar, p$b<T> p_b) {
        this.a = gVar;
        this.d = copyOnWriteArraySet;
        this.c = p_b;
        this.f973b = gVar.b(looper, new b(this));
    }

    public void a() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.f973b.e(0)) {
            o oVar = this.f973b;
            oVar.d(oVar.c(0));
        }
        boolean z2 = !this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (z2) {
            return;
        }
        while (!this.e.isEmpty()) {
            this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }

    public void b(int i, p$a<T> p_a) {
        this.f.add(new a(new CopyOnWriteArraySet(this.d), i, p_a));
    }

    public void c() {
        for (p$c<T> p_c : this.d) {
            p$b<T> p_b = this.c;
            p_c.d = true;
            if (p_c.c) {
                p_b.a(p_c.a, p_c.f974b.b());
            }
        }
        this.d.clear();
        this.g = true;
    }
}
