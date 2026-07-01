package h0.a.a;

import b.d.b.a.outline;

/* JADX INFO: renamed from: h0.a.a.n, reason: use source file name */
/* JADX INFO: compiled from: Handle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Handle2 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3712b;
    public final String c;
    public final String d;
    public final boolean e;

    public Handle2(int i, String str, String str2, String str3, boolean z2) {
        this.a = i;
        this.f3712b = str;
        this.c = str2;
        this.d = str3;
        this.e = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle2)) {
            return false;
        }
        Handle2 handle2 = (Handle2) obj;
        return this.a == handle2.a && this.e == handle2.e && this.f3712b.equals(handle2.f3712b) && this.c.equals(handle2.c) && this.d.equals(handle2.d);
    }

    public int hashCode() {
        return (this.d.hashCode() * this.c.hashCode() * this.f3712b.hashCode()) + this.a + (this.e ? 64 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3712b);
        sb.append('.');
        sb.append(this.c);
        sb.append(this.d);
        sb.append(" (");
        sb.append(this.a);
        return outline.H(sb, this.e ? " itf" : "", ')');
    }
}
