package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.t, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.d.e {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1735b;
    public final String c;
    public final boolean d;

    public AutoValue_CrashlyticsReport_Session_OperatingSystem(int i, String str, String str2, boolean z2, a aVar) {
        this.a = i;
        this.f1735b = str;
        this.c = str2;
        this.d = z2;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.e
    @NonNull
    public String a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.e
    public int b() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.e
    @NonNull
    public String c() {
        return this.f1735b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.e
    public boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.e)) {
            return false;
        }
        CrashlyticsReport.d.e eVar = (CrashlyticsReport.d.e) obj;
        return this.a == eVar.b() && this.f1735b.equals(eVar.c()) && this.c.equals(eVar.a()) && this.d == eVar.d();
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.f1735b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ (this.d ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OperatingSystem{platform=");
        sbU.append(this.a);
        sbU.append(", version=");
        sbU.append(this.f1735b);
        sbU.append(", buildVersion=");
        sbU.append(this.c);
        sbU.append(", jailbroken=");
        return outline.O(sbU, this.d, "}");
    }
}
