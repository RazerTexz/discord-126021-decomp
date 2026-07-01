package b.i.a.c.x2;

import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: compiled from: ChunkIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements t {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1164b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public c(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f1164b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        int iE = e0.e(this.e, j, true, true);
        long[] jArr = this.e;
        long j2 = jArr[iE];
        long[] jArr2 = this.c;
        u uVar = new u(j2, jArr2[iE]);
        if (j2 >= j || iE == this.a - 1) {
            return new t$a(uVar);
        }
        int i = iE + 1;
        return new t$a(uVar, new u(jArr[i], jArr2[i]));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.f;
    }

    public String toString() {
        int i = this.a;
        String string = Arrays.toString(this.f1164b);
        String string2 = Arrays.toString(this.c);
        String string3 = Arrays.toString(this.e);
        String string4 = Arrays.toString(this.d);
        StringBuilder sb = new StringBuilder(b.d.b.a.a.b(string4, b.d.b.a.a.b(string3, b.d.b.a.a.b(string2, b.d.b.a.a.b(string, 71)))));
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(string);
        b.d.b.a.a.s0(sb, ", offsets=", string2, ", timeUs=", string3);
        return b.d.b.a.a.K(sb, ", durationsUs=", string4, ")");
    }
}
