package b.i.a.c.x2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$a {
    public final u a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f1296b;

    public t$a(u uVar) {
        this.a = uVar;
        this.f1296b = uVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t$a.class != obj.getClass()) {
            return false;
        }
        t$a t_a = (t$a) obj;
        return this.a.equals(t_a.a) && this.f1296b.equals(t_a.f1296b);
    }

    public int hashCode() {
        return this.f1296b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        String strJ;
        String strValueOf = String.valueOf(this.a);
        if (this.a.equals(this.f1296b)) {
            strJ = "";
        } else {
            String strValueOf2 = String.valueOf(this.f1296b);
            strJ = b.d.b.a.a.j(strValueOf2.length() + 2, ", ", strValueOf2);
        }
        return b.d.b.a.a.l(b.d.b.a.a.b(strJ, strValueOf.length() + 2), "[", strValueOf, strJ, "]");
    }

    public t$a(u uVar, u uVar2) {
        this.a = uVar;
        this.f1296b = uVar2;
    }
}
