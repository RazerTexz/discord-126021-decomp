package b.i.a.c.b3.s;

import b.c.a.a0.d;
import b.i.a.c.b3.g;
import b.i.a.c.f3.e0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SubripSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {
    public final b.i.a.c.b3.b[] j;
    public final long[] k;

    public b(b.i.a.c.b3.b[] bVarArr, long[] jArr) {
        this.j = bVarArr;
        this.k = jArr;
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        int iB = e0.b(this.k, j, false, false);
        if (iB < this.k.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        d.j(i >= 0);
        d.j(i < this.k.length);
        return this.k[i];
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j) {
        int iE = e0.e(this.k, j, true, false);
        if (iE != -1) {
            b.i.a.c.b3.b[] bVarArr = this.j;
            if (bVarArr[iE] != b.i.a.c.b3.b.j) {
                return Collections.singletonList(bVarArr[iE]);
            }
        }
        return Collections.emptyList();
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return this.k.length;
    }
}
