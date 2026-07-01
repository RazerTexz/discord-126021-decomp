package d0.d0;

import d0.t.d0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends d0 {
    public final long j;
    public boolean k;
    public long l;
    public final long m;

    public d(long j, long j2, long j3) {
        this.m = j3;
        this.j = j2;
        boolean z2 = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z2 = false;
        }
        this.k = z2;
        this.l = z2 ? j : j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k;
    }

    @Override // d0.t.d0
    public long nextLong() {
        long j = this.l;
        if (j != this.j) {
            this.l = this.m + j;
        } else {
            if (!this.k) {
                throw new NoSuchElementException();
            }
            this.k = false;
        }
        return j;
    }
}
