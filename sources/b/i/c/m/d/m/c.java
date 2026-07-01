package b.i.c.m.d.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends v$b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1715b;

    public c(String str, String str2, c$a c_a) {
        this.a = str;
        this.f1715b = str2;
    }

    @Override // b.i.c.m.d.m.v$b
    @NonNull
    public String a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$b
    @NonNull
    public String b() {
        return this.f1715b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$b)) {
            return false;
        }
        v$b v_b = (v$b) obj;
        return this.a.equals(v_b.a()) && this.f1715b.equals(v_b.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1715b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CustomAttribute{key=");
        sbU.append(this.a);
        sbU.append(", value=");
        return b.d.b.a.a.J(sbU, this.f1715b, "}");
    }
}
