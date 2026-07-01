package s.a.e2;

import d0.d0._Ranges;
import java.util.concurrent.TimeUnit;
import s.a.a.SystemProps;

/* JADX INFO: renamed from: s.a.e2.k, reason: use source file name */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Tasks7 {
    public static final long a = b.i.a.f.e.o.f.m1("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3839b;
    public static final int c;
    public static final long d;
    public static Tasks8 e;

    static {
        b.i.a.f.e.o.f.l1("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int i = SystemProps.a;
        int iL1 = b.i.a.f.e.o.f.l1("kotlinx.coroutines.scheduler.core.pool.size", _Ranges.coerceAtLeast(i, 2), 1, 0, 8, null);
        f3839b = iL1;
        c = b.i.a.f.e.o.f.l1("kotlinx.coroutines.scheduler.max.pool.size", _Ranges.coerceIn(i * 128, iL1, 2097150), 0, 2097150, 4, null);
        d = TimeUnit.SECONDS.toNanos(b.i.a.f.e.o.f.m1("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        e = Tasks2.a;
    }
}
