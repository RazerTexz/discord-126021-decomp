package b.i.a.c.x2.j0;

import b.i.a.c.f3.x;
import b.i.a.c.x2.w;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: StreamReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f1239b;
    public b.i.a.c.x2.j c;
    public g d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;
    public final e a = new e();
    public i$b j = new i$b();

    public long a(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    public void b(long j) {
        this.g = j;
    }

    public abstract long c(x xVar);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean d(x xVar, long j, i$b i_b) throws IOException;

    public void e(boolean z2) {
        if (z2) {
            this.j = new i$b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }
}
