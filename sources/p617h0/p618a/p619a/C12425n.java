package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: h0.a.a.n */
/* JADX INFO: compiled from: Handle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12425n {

    /* JADX INFO: renamed from: a */
    public final int f26237a;

    /* JADX INFO: renamed from: b */
    public final String f26238b;

    /* JADX INFO: renamed from: c */
    public final String f26239c;

    /* JADX INFO: renamed from: d */
    public final String f26240d;

    /* JADX INFO: renamed from: e */
    public final boolean f26241e;

    public C12425n(int i, String str, String str2, String str3, boolean z2) {
        this.f26237a = i;
        this.f26238b = str;
        this.f26239c = str2;
        this.f26240d = str3;
        this.f26241e = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C12425n)) {
            return false;
        }
        C12425n c12425n = (C12425n) obj;
        return this.f26237a == c12425n.f26237a && this.f26241e == c12425n.f26241e && this.f26238b.equals(c12425n.f26238b) && this.f26239c.equals(c12425n.f26239c) && this.f26240d.equals(c12425n.f26240d);
    }

    public int hashCode() {
        return (this.f26240d.hashCode() * this.f26239c.hashCode() * this.f26238b.hashCode()) + this.f26237a + (this.f26241e ? 64 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26238b);
        sb.append('.');
        sb.append(this.f26239c);
        sb.append(this.f26240d);
        sb.append(" (");
        sb.append(this.f26237a);
        return C1643a.m820H(sb, this.f26241e ? " itf" : "", ')');
    }
}
