package b.i.a.c.s2;

import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import b.i.a.c.o2;
import java.util.Arrays;

/* JADX INFO: compiled from: AnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2 f1084b;
    public final int c;

    @Nullable
    public final a0$a d;
    public final long e;
    public final o2 f;
    public final int g;

    @Nullable
    public final a0$a h;
    public final long i;
    public final long j;

    public h1$a(long j, o2 o2Var, int i, @Nullable a0$a a0_a, long j2, o2 o2Var2, int i2, @Nullable a0$a a0_a2, long j3, long j4) {
        this.a = j;
        this.f1084b = o2Var;
        this.c = i;
        this.d = a0_a;
        this.e = j2;
        this.f = o2Var2;
        this.g = i2;
        this.h = a0_a2;
        this.i = j3;
        this.j = j4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1$a.class != obj.getClass()) {
            return false;
        }
        h1$a h1_a = (h1$a) obj;
        return this.a == h1_a.a && this.c == h1_a.c && this.e == h1_a.e && this.g == h1_a.g && this.i == h1_a.i && this.j == h1_a.j && b.i.a.f.e.o.f.V(this.f1084b, h1_a.f1084b) && b.i.a.f.e.o.f.V(this.d, h1_a.d) && b.i.a.f.e.o.f.V(this.f, h1_a.f) && b.i.a.f.e.o.f.V(this.h, h1_a.h);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), this.f1084b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
    }
}
