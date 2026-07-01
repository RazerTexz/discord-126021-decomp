package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends v$c {
    public final w<v$c$a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1716b;

    public d(w wVar, String str, d$a d_a) {
        this.a = wVar;
        this.f1716b = str;
    }

    @Override // b.i.c.m.d.m.v$c
    @NonNull
    public w<v$c$a> a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v$c
    @Nullable
    public String b() {
        return this.f1716b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$c)) {
            return false;
        }
        v$c v_c = (v$c) obj;
        if (this.a.equals(v_c.a())) {
            String str = this.f1716b;
            if (str == null) {
                if (v_c.b() == null) {
                    return true;
                }
            } else if (str.equals(v_c.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f1716b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("FilesPayload{files=");
        sbU.append(this.a);
        sbU.append(", orgId=");
        return b.d.b.a.a.J(sbU, this.f1716b, "}");
    }
}
