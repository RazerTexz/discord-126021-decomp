package p007b.p225i.p361c.p368l;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.l.o */
/* JADX INFO: compiled from: Dependency.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4583o {

    /* JADX INFO: renamed from: a */
    public final Class<?> f12201a;

    /* JADX INFO: renamed from: b */
    public final int f12202b;

    /* JADX INFO: renamed from: c */
    public final int f12203c;

    public C4583o(Class<?> cls, int i, int i2) {
        Objects.requireNonNull(cls, "Null dependency anInterface.");
        this.f12201a = cls;
        this.f12202b = i;
        this.f12203c = i2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6358a() {
        return this.f12202b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4583o)) {
            return false;
        }
        C4583o c4583o = (C4583o) obj;
        return this.f12201a == c4583o.f12201a && this.f12202b == c4583o.f12202b && this.f12203c == c4583o.f12203c;
    }

    public int hashCode() {
        return ((((this.f12201a.hashCode() ^ 1000003) * 1000003) ^ this.f12202b) * 1000003) ^ this.f12203c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f12201a);
        sb.append(", type=");
        int i = this.f12202b;
        if (i == 1) {
            str = "required";
        } else {
            str = i == 0 ? "optional" : "set";
        }
        sb.append(str);
        sb.append(", direct=");
        return C1643a.m827O(sb, this.f12203c == 0, "}");
    }
}
