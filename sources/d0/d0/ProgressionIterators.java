package d0.d0;

import d0.t.Iterators4;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: d0.d0.b, reason: use source file name */
/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressionIterators extends Iterators4 {
    public final int j;
    public boolean k;
    public int l;
    public final int m;

    public ProgressionIterators(int i, int i2, int i3) {
        this.m = i3;
        this.j = i2;
        boolean z2 = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z2 = false;
        }
        this.k = z2;
        this.l = z2 ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k;
    }

    @Override // d0.t.Iterators4
    public int nextInt() {
        int i = this.l;
        if (i != this.j) {
            this.l = this.m + i;
        } else {
            if (!this.k) {
                throw new NoSuchElementException();
            }
            this.k = false;
        }
        return i;
    }
}
