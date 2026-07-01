package b.i.a.c.a3;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.o2;
import b.i.a.c.w2.s$a$a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: BaseMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements a0 {
    public final ArrayList<a0$b> a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<a0$b> f827b = new HashSet<>(1);
    public final b0$a c = new b0$a();
    public final b.i.a.c.w2.s$a d = new b.i.a.c.w2.s$a();

    @Nullable
    public Looper e;

    @Nullable
    public o2 f;

    @Override // b.i.a.c.a3.a0
    public final void a(a0$b a0_b) {
        this.a.remove(a0_b);
        if (!this.a.isEmpty()) {
            d(a0_b);
            return;
        }
        this.e = null;
        this.f = null;
        this.f827b.clear();
        s();
    }

    @Override // b.i.a.c.a3.a0
    public final void b(Handler handler, b0 b0Var) {
        b0$a b0_a = this.c;
        Objects.requireNonNull(b0_a);
        b0_a.c.add(new b0$a$a(handler, b0Var));
    }

    @Override // b.i.a.c.a3.a0
    public final void c(b0 b0Var) {
        b0$a b0_a = this.c;
        for (b0$a$a b0_a_a : b0_a.c) {
            if (b0_a_a.f808b == b0Var) {
                b0_a.c.remove(b0_a_a);
            }
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void d(a0$b a0_b) {
        boolean z2 = !this.f827b.isEmpty();
        this.f827b.remove(a0_b);
        if (z2 && this.f827b.isEmpty()) {
            o();
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void f(Handler handler, b.i.a.c.w2.s sVar) {
        b.i.a.c.w2.s$a s_a = this.d;
        Objects.requireNonNull(s_a);
        s_a.c.add(new s$a$a(handler, sVar));
    }

    @Override // b.i.a.c.a3.a0
    public final void g(b.i.a.c.w2.s sVar) {
        b.i.a.c.w2.s$a s_a = this.d;
        for (s$a$a s_a_a : s_a.c) {
            if (s_a_a.f1157b == sVar) {
                s_a.c.remove(s_a_a);
            }
        }
    }

    @Override // b.i.a.c.a3.a0
    public /* synthetic */ boolean i() {
        return z.b(this);
    }

    @Override // b.i.a.c.a3.a0
    public /* synthetic */ o2 k() {
        return z.a(this);
    }

    @Override // b.i.a.c.a3.a0
    public final void l(a0$b a0_b, @Nullable b.i.a.c.e3.a0 a0Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        b.c.a.a0.d.j(looper == null || looper == looperMyLooper);
        o2 o2Var = this.f;
        this.a.add(a0_b);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.f827b.add(a0_b);
            q(a0Var);
        } else if (o2Var != null) {
            m(a0_b);
            a0_b.a(this, o2Var);
        }
    }

    @Override // b.i.a.c.a3.a0
    public final void m(a0$b a0_b) {
        Objects.requireNonNull(this.e);
        boolean zIsEmpty = this.f827b.isEmpty();
        this.f827b.add(a0_b);
        if (zIsEmpty) {
            p();
        }
    }

    public void o() {
    }

    public void p() {
    }

    public abstract void q(@Nullable b.i.a.c.e3.a0 a0Var);

    public final void r(o2 o2Var) {
        this.f = o2Var;
        Iterator<a0$b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, o2Var);
        }
    }

    public abstract void s();
}
