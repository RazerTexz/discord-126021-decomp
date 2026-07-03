package p659s.p660a.p666e2;

import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p512d0.C11226f;
import p659s.p660a.p661a.C13038u;

/* JADX INFO: renamed from: s.a.e2.k */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13105k {

    /* JADX INFO: renamed from: a */
    public static final long f27831a = C3404f.m4317m1("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: b */
    public static final int f27832b;

    /* JADX INFO: renamed from: c */
    public static final int f27833c;

    /* JADX INFO: renamed from: d */
    public static final long f27834d;

    /* JADX INFO: renamed from: e */
    public static AbstractC13106l f27835e;

    static {
        C3404f.m4313l1("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int i = C13038u.f27706a;
        int iM4313l1 = C3404f.m4313l1("kotlinx.coroutines.scheduler.core.pool.size", C11226f.coerceAtLeast(i, 2), 1, 0, 8, null);
        f27832b = iM4313l1;
        f27833c = C3404f.m4313l1("kotlinx.coroutines.scheduler.max.pool.size", C11226f.coerceIn(i * 128, iM4313l1, 2097150), 0, 2097150, 4, null);
        f27834d = TimeUnit.SECONDS.toNanos(C3404f.m4317m1("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f27835e = C13100f.f27826a;
    }
}
