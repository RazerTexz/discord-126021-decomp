package b.i.a.c.a3;

import androidx.annotation.VisibleForTesting;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;

/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class v$b extends o2 {
    public final o1 k;

    public v$b(o1 o1Var) {
        this.k = o1Var;
    }

    @Override // b.i.a.c.o2
    public int b(Object obj) {
        return obj == v$a.l ? 0 : -1;
    }

    @Override // b.i.a.c.o2
    public o2$b g(int i, o2$b o2_b, boolean z2) {
        o2_b.f(z2 ? 0 : null, z2 ? v$a.l : null, 0, -9223372036854775807L, 0L, b.i.a.c.a3.p0.c.j, true);
        return o2_b;
    }

    @Override // b.i.a.c.o2
    public int i() {
        return 1;
    }

    @Override // b.i.a.c.o2
    public Object m(int i) {
        return v$a.l;
    }

    @Override // b.i.a.c.o2
    public o2$c o(int i, o2$c o2_c, long j) {
        o2_c.e(o2$c.j, this.k, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        o2_c.f1044y = true;
        return o2_c;
    }

    @Override // b.i.a.c.o2
    public int p() {
        return 1;
    }
}
