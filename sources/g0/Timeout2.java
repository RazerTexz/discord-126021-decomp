package g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: g0.y, reason: use source file name */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Timeout2 {
    public static final Timeout2 a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3695b;
    public long c;
    public long d;

    /* JADX INFO: renamed from: g0.y$a */
    /* JADX INFO: compiled from: Timeout.kt */
    public static final class a extends Timeout2 {
        @Override // g0.Timeout2
        public Timeout2 d(long j) {
            return this;
        }

        @Override // g0.Timeout2
        public void f() {
        }

        @Override // g0.Timeout2
        public Timeout2 g(long j, TimeUnit timeUnit) {
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            return this;
        }
    }

    public Timeout2 a() {
        this.f3695b = false;
        return this;
    }

    public Timeout2 b() {
        this.d = 0L;
        return this;
    }

    public long c() {
        if (this.f3695b) {
            return this.c;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public Timeout2 d(long j) {
        this.f3695b = true;
        this.c = j;
        return this;
    }

    public boolean e() {
        return this.f3695b;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3695b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout2 g(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.t("timeout < 0: ", j).toString());
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long h() {
        return this.d;
    }
}
