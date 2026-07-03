package p617h0.p618a.p619a;

import java.util.Arrays;

/* JADX INFO: renamed from: h0.a.a.g */
/* JADX INFO: compiled from: ConstantDynamic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12418g {

    /* JADX INFO: renamed from: a */
    public final String f26190a;

    /* JADX INFO: renamed from: b */
    public final String f26191b;

    /* JADX INFO: renamed from: c */
    public final C12425n f26192c;

    /* JADX INFO: renamed from: d */
    public final Object[] f26193d;

    public C12418g(String str, String str2, C12425n c12425n, Object... objArr) {
        this.f26190a = str;
        this.f26191b = str2;
        this.f26192c = c12425n;
        this.f26193d = objArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C12418g)) {
            return false;
        }
        C12418g c12418g = (C12418g) obj;
        return this.f26190a.equals(c12418g.f26190a) && this.f26191b.equals(c12418g.f26191b) && this.f26192c.equals(c12418g.f26192c) && Arrays.equals(this.f26193d, c12418g.f26193d);
    }

    public int hashCode() {
        return ((this.f26190a.hashCode() ^ Integer.rotateLeft(this.f26191b.hashCode(), 8)) ^ Integer.rotateLeft(this.f26192c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.f26193d), 24);
    }

    public String toString() {
        return this.f26190a + " : " + this.f26191b + ' ' + this.f26192c + ' ' + Arrays.toString(this.f26193d);
    }
}
