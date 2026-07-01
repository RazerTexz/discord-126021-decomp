package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends v$d$d$a {
    public final v$d$d$a$b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w<v$b> f1724b;
    public final Boolean c;
    public final int d;

    public k(v$d$d$a$b v_d_d_a_b, w wVar, Boolean bool, int i, k$a k_a) {
        this.a = v_d_d_a_b;
        this.f1724b = wVar;
        this.c = bool;
        this.d = i;
    }

    @Override // b.i.c.m.d.m.v$d$d$a
    @Nullable
    public Boolean a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v$d$d$a
    @Nullable
    public w<v$b> b() {
        return this.f1724b;
    }

    @Override // b.i.c.m.d.m.v$d$d$a
    @NonNull
    public v$d$d$a$b c() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$d$d$a
    public int d() {
        return this.d;
    }

    public v$d$d$a$a e() {
        return new k$b(this, null);
    }

    public boolean equals(Object obj) {
        w<v$b> wVar;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$d$d$a)) {
            return false;
        }
        v$d$d$a v_d_d_a = (v$d$d$a) obj;
        return this.a.equals(v_d_d_a.c()) && ((wVar = this.f1724b) != null ? wVar.equals(v_d_d_a.b()) : v_d_d_a.b() == null) && ((bool = this.c) != null ? bool.equals(v_d_d_a.a()) : v_d_d_a.a() == null) && this.d == v_d_d_a.d();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        w<v$b> wVar = this.f1724b;
        int iHashCode2 = (iHashCode ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        Boolean bool = this.c;
        return ((iHashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.d;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Application{execution=");
        sbU.append(this.a);
        sbU.append(", customAttributes=");
        sbU.append(this.f1724b);
        sbU.append(", background=");
        sbU.append(this.c);
        sbU.append(", uiOrientation=");
        return b.d.b.a.a.B(sbU, this.d, "}");
    }
}
