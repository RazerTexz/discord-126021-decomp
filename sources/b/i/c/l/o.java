package b.i.c.l;

import java.util.Objects;

/* JADX INFO: compiled from: Dependency.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1668b;
    public final int c;

    public o(Class<?> cls, int i, int i2) {
        Objects.requireNonNull(cls, "Null dependency anInterface.");
        this.a = cls;
        this.f1668b = i;
        this.c = i2;
    }

    public boolean a() {
        return this.f1668b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a == oVar.a && this.f1668b == oVar.f1668b && this.c == oVar.c;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1668b) * 1000003) ^ this.c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.f1668b;
        if (i == 1) {
            str = "required";
        } else {
            str = i == 0 ? "optional" : "set";
        }
        sb.append(str);
        sb.append(", direct=");
        return b.d.b.a.a.O(sb, this.c == 0, "}");
    }
}
