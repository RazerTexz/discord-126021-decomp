package h0.a.a;

/* JADX INFO: compiled from: Handle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3712b;
    public final String c;
    public final String d;
    public final boolean e;

    public n(int i, String str, String str2, String str3, boolean z2) {
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
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.e == nVar.e && this.f3712b.equals(nVar.f3712b) && this.c.equals(nVar.c) && this.d.equals(nVar.d);
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
        return b.d.b.a.a.H(sb, this.e ? " itf" : "", ')');
    }
}
