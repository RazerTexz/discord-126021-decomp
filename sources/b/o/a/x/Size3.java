package b.o.a.x;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.x.b, reason: use source file name */
/* JADX INFO: compiled from: Size.java */
/* JADX INFO: loaded from: classes3.dex */
public class Size3 implements Comparable<Size3> {
    public final int j;
    public final int k;

    public Size3(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Size3 size3) {
        Size3 size4 = size3;
        return (this.j * this.k) - (size4.j * size4.k);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size3)) {
            return false;
        }
        Size3 size3 = (Size3) obj;
        return this.j == size3.j && this.k == size3.k;
    }

    public Size3 f() {
        return new Size3(this.k, this.j);
    }

    public int hashCode() {
        int i = this.k;
        int i2 = this.j;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @NonNull
    public String toString() {
        return this.j + "x" + this.k;
    }
}
