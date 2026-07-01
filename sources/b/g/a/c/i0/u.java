package b.g.a.c.i0;

/* JADX INFO: compiled from: TypeKey.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f730b;
    public b.g.a.c.j c;
    public boolean d;

    public u() {
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != u.class) {
            return false;
        }
        u uVar = (u) obj;
        if (uVar.d != this.d) {
            return false;
        }
        Class<?> cls = this.f730b;
        if (cls != null) {
            return uVar.f730b == cls;
        }
        return this.c.equals(uVar.c);
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        if (this.f730b != null) {
            StringBuilder sbU = b.d.b.a.a.U("{class: ");
            b.d.b.a.a.k0(this.f730b, sbU, ", typed? ");
            return b.d.b.a.a.O(sbU, this.d, "}");
        }
        StringBuilder sbU2 = b.d.b.a.a.U("{type: ");
        sbU2.append(this.c);
        sbU2.append(", typed? ");
        return b.d.b.a.a.O(sbU2, this.d, "}");
    }

    public u(Class<?> cls, boolean z2) {
        this.f730b = cls;
        this.c = null;
        this.d = z2;
        this.a = z2 ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public u(b.g.a.c.j jVar, boolean z2) {
        int i;
        this.c = jVar;
        this.f730b = null;
        this.d = z2;
        if (z2) {
            i = jVar._hash - 2;
        } else {
            i = jVar._hash - 1;
        }
        this.a = i;
    }
}
