package b.o.a.x;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Size.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Comparable<b> {
    public final int j;
    public final int k;

    public b(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull b bVar) {
        b bVar2 = bVar;
        return (this.j * this.k) - (bVar2.j * bVar2.k);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.j == bVar.j && this.k == bVar.k;
    }

    public b f() {
        return new b(this.k, this.j);
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
