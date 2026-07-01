package b.i.a.c;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;

/* JADX INFO: compiled from: PlaybackInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w1 {
    public static final a0$a a = new a0$a(new Object());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2 f1146b;
    public final a0$a c;
    public final long d;
    public final long e;
    public final int f;

    @Nullable
    public final ExoPlaybackException g;
    public final boolean h;
    public final b.i.a.c.a3.o0 i;
    public final b.i.a.c.c3.r j;
    public final List<Metadata> k;
    public final a0$a l;
    public final boolean m;
    public final int n;
    public final x1 o;
    public final boolean p;
    public final boolean q;
    public volatile long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f1147s;
    public volatile long t;

    public w1(o2 o2Var, a0$a a0_a, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z2, b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.r rVar, List<Metadata> list, a0$a a0_a2, boolean z3, int i2, x1 x1Var, long j3, long j4, long j5, boolean z4, boolean z5) {
        this.f1146b = o2Var;
        this.c = a0_a;
        this.d = j;
        this.e = j2;
        this.f = i;
        this.g = exoPlaybackException;
        this.h = z2;
        this.i = o0Var;
        this.j = rVar;
        this.k = list;
        this.l = a0_a2;
        this.m = z3;
        this.n = i2;
        this.o = x1Var;
        this.r = j3;
        this.f1147s = j4;
        this.t = j5;
        this.p = z4;
        this.q = z5;
    }

    public static w1 h(b.i.a.c.c3.r rVar) {
        o2 o2Var = o2.j;
        a0$a a0_a = a;
        b.i.a.c.a3.o0 o0Var = b.i.a.c.a3.o0.j;
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        return new w1(o2Var, a0_a, -9223372036854775807L, 0L, 1, null, false, o0Var, rVar, b.i.b.b.h0.l, a0_a, false, 0, x1.j, 0L, 0L, 0L, false, false);
    }

    @CheckResult
    public w1 a(a0$a a0_a) {
        return new w1(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, a0_a, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public w1 b(a0$a a0_a, long j, long j2, long j3, long j4, b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.r rVar, List<Metadata> list) {
        return new w1(this.f1146b, a0_a, j2, j3, this.f, this.g, this.h, o0Var, rVar, list, this.l, this.m, this.n, this.o, this.r, j4, j, this.p, this.q);
    }

    @CheckResult
    public w1 c(boolean z2) {
        return new w1(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, z2, this.q);
    }

    @CheckResult
    public w1 d(boolean z2, int i) {
        return new w1(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, z2, i, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public w1 e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new w1(this.f1146b, this.c, this.d, this.e, this.f, exoPlaybackException, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public w1 f(int i) {
        return new w1(this.f1146b, this.c, this.d, this.e, i, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public w1 g(o2 o2Var) {
        return new w1(o2Var, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }
}
