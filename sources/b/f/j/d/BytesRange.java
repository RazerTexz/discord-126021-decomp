package b.f.j.d;

import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.f.j.d.a, reason: use source file name */
/* JADX INFO: compiled from: BytesRange.java */
/* JADX INFO: loaded from: classes.dex */
public class BytesRange {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563b;

    public BytesRange(int i, int i2) {
        this.a = i;
        this.f563b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        return this.a == bytesRange.a && this.f563b == bytesRange.f563b;
    }

    public int hashCode() {
        return AnimatableValueParser.J0(this.a, this.f563b);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        int i = this.a;
        objArr[0] = i == Integer.MAX_VALUE ? "" : Integer.toString(i);
        int i2 = this.f563b;
        objArr[1] = i2 != Integer.MAX_VALUE ? Integer.toString(i2) : "";
        return String.format(null, "%s-%s", objArr);
    }
}
