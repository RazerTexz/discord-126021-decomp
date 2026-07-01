package b.g.a.c.h0;

/* JADX INFO: compiled from: TypeBindings.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.j[] f720b;
    public final int c;

    public m$a(Class<?> cls, b.g.a.c.j[] jVarArr, int i) {
        this.a = cls;
        this.f720b = jVarArr;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != m$a.class) {
            return false;
        }
        m$a m_a = (m$a) obj;
        if (this.c == m_a.c && this.a == m_a.a) {
            b.g.a.c.j[] jVarArr = m_a.f720b;
            int length = this.f720b.length;
            if (length == jVarArr.length) {
                for (int i = 0; i < length; i++) {
                    if (!this.f720b[i].equals(jVarArr[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return b.d.b.a.a.o(this.a, new StringBuilder(), "<>");
    }
}
