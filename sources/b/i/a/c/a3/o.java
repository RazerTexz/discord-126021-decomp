package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o<T> extends l {
    public final HashMap<T, o$b<T>> g = new HashMap<>();

    @Nullable
    public Handler h;

    @Nullable
    public b.i.a.c.e3.a0 i;

    @Override // b.i.a.c.a3.l
    @CallSuper
    public void o() {
        for (o$b<T> o_b : this.g.values()) {
            o_b.a.d(o_b.f831b);
        }
    }

    @Override // b.i.a.c.a3.l
    @CallSuper
    public void p() {
        for (o$b<T> o_b : this.g.values()) {
            o_b.a.m(o_b.f831b);
        }
    }

    public final void t(T t, a0 a0Var) {
        b.c.a.a0.d.j(!this.g.containsKey(null));
        a0$b aVar = new a(this, null);
        o$a o_a = new o$a(this, null);
        this.g.put(null, new o$b<>(a0Var, aVar, o_a));
        Handler handler = this.h;
        Objects.requireNonNull(handler);
        a0Var.b(handler, o_a);
        Handler handler2 = this.h;
        Objects.requireNonNull(handler2);
        a0Var.f(handler2, o_a);
        a0Var.l(aVar, this.i);
        if (!this.f827b.isEmpty()) {
            return;
        }
        a0Var.d(aVar);
    }
}
