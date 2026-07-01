package h0.a.a;

import java.util.Arrays;

/* JADX INFO: renamed from: h0.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: ConstantDynamic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantDynamic2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3706b;
    public final Handle2 c;
    public final Object[] d;

    public ConstantDynamic2(String str, String str2, Handle2 handle2, Object... objArr) {
        this.a = str;
        this.f3706b = str2;
        this.c = handle2;
        this.d = objArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantDynamic2)) {
            return false;
        }
        ConstantDynamic2 constantDynamic2 = (ConstantDynamic2) obj;
        return this.a.equals(constantDynamic2.a) && this.f3706b.equals(constantDynamic2.f3706b) && this.c.equals(constantDynamic2.c) && Arrays.equals(this.d, constantDynamic2.d);
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ Integer.rotateLeft(this.f3706b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.d), 24);
    }

    public String toString() {
        return this.a + " : " + this.f3706b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
