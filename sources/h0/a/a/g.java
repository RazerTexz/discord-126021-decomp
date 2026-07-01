package h0.a.a;

import java.util.Arrays;

/* JADX INFO: compiled from: ConstantDynamic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3706b;
    public final n c;
    public final Object[] d;

    public g(String str, String str2, n nVar, Object... objArr) {
        this.a = str;
        this.f3706b = str2;
        this.c = nVar;
        this.d = objArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.a) && this.f3706b.equals(gVar.f3706b) && this.c.equals(gVar.c) && Arrays.equals(this.d, gVar.d);
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ Integer.rotateLeft(this.f3706b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.d), 24);
    }

    public String toString() {
        return this.a + " : " + this.f3706b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
