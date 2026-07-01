package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$c implements Comparable<h1$c> {
    public final b2 j;
    public int k;
    public long l;

    @Nullable
    public Object m;

    /* JADX WARN: Code duplicated, block: B:13:0x0017  */
    @Override // java.lang.Comparable
    public int compareTo(h1$c h1_c) {
        h1$c h1_c2 = h1_c;
        Object obj = this.m;
        int i = 1;
        if ((obj == null) != (h1_c2.m == null)) {
            if (obj != null) {
                i = -1;
            }
        } else {
            if (obj == null) {
                return 0;
            }
            int i2 = this.k - h1_c2.k;
            if (i2 != 0) {
                return i2;
            }
            long j = this.l;
            long j2 = h1_c2.l;
            int i3 = b.i.a.c.f3.e0.a;
            if (j < j2) {
                i = -1;
            } else if (j == j2) {
                i = 0;
            }
        }
        return i;
    }

    public void f(int i, long j, Object obj) {
        this.k = i;
        this.l = j;
        this.m = obj;
    }
}
