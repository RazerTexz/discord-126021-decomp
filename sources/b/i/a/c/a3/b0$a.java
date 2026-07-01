package b.i.a.c.a3;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MediaSourceEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final a0$a f807b;
    public final CopyOnWriteArrayList<b0$a$a> c;
    public final long d;

    public b0$a() {
        this.c = new CopyOnWriteArrayList<>();
        this.a = 0;
        this.f807b = null;
        this.d = 0L;
    }

    public final long a(long j) {
        long jM = b.i.a.c.f3.e0.M(j);
        if (jM == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d + jM;
    }

    public void b(w wVar) {
        for (b0$a$a b0_a_a : this.c) {
            b.i.a.c.f3.e0.E(b0_a_a.a, new d(this, b0_a_a.f808b, wVar));
        }
    }

    public void c(t tVar, w wVar) {
        for (b0$a$a b0_a_a : this.c) {
            b.i.a.c.f3.e0.E(b0_a_a.a, new f(this, b0_a_a.f808b, tVar, wVar));
        }
    }

    public void d(t tVar, w wVar) {
        for (b0$a$a b0_a_a : this.c) {
            b.i.a.c.f3.e0.E(b0_a_a.a, new c(this, b0_a_a.f808b, tVar, wVar));
        }
    }

    public void e(t tVar, w wVar, IOException iOException, boolean z2) {
        for (b0$a$a b0_a_a : this.c) {
            b.i.a.c.f3.e0.E(b0_a_a.a, new b(this, b0_a_a.f808b, tVar, wVar, iOException, z2));
        }
    }

    public void f(t tVar, w wVar) {
        for (b0$a$a b0_a_a : this.c) {
            b.i.a.c.f3.e0.E(b0_a_a.a, new e(this, b0_a_a.f808b, tVar, wVar));
        }
    }

    @CheckResult
    public b0$a g(int i, @Nullable a0$a a0_a, long j) {
        return new b0$a(this.c, i, a0_a, j);
    }

    public b0$a(CopyOnWriteArrayList<b0$a$a> copyOnWriteArrayList, int i, @Nullable a0$a a0_a, long j) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.f807b = a0_a;
        this.d = j;
    }
}
