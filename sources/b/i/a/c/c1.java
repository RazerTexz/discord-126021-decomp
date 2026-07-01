package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 implements w0 {
    public final int j;
    public final int k;
    public final int l;

    public c1(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.j == c1Var.j && this.k == c1Var.k && this.l == c1Var.l;
    }

    public int hashCode() {
        return ((((527 + this.j) * 31) + this.k) * 31) + this.l;
    }
}
