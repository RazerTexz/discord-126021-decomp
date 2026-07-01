package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.u, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.d.f {
    public final String a;

    public AutoValue_CrashlyticsReport_Session_User(String str, a aVar) {
        this.a = str;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.f
    @NonNull
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.d.f) {
            return this.a.equals(((CrashlyticsReport.d.f) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return outline.J(outline.U("User{identifier="), this.a, "}");
    }
}
