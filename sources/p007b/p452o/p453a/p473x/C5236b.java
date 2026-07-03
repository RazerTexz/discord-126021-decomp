package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.x.b */
/* JADX INFO: compiled from: Size.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5236b implements Comparable<C5236b> {

    /* JADX INFO: renamed from: j */
    public final int f14251j;

    /* JADX INFO: renamed from: k */
    public final int f14252k;

    public C5236b(int i, int i2) {
        this.f14251j = i;
        this.f14252k = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull C5236b c5236b) {
        C5236b c5236b2 = c5236b;
        return (this.f14251j * this.f14252k) - (c5236b2.f14251j * c5236b2.f14252k);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5236b)) {
            return false;
        }
        C5236b c5236b = (C5236b) obj;
        return this.f14251j == c5236b.f14251j && this.f14252k == c5236b.f14252k;
    }

    /* JADX INFO: renamed from: f */
    public C5236b m7451f() {
        return new C5236b(this.f14252k, this.f14251j);
    }

    public int hashCode() {
        int i = this.f14252k;
        int i2 = this.f14251j;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @NonNull
    public String toString() {
        return this.f14251j + "x" + this.f14252k;
    }
}
