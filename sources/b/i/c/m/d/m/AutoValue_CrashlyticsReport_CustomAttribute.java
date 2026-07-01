package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1715b;

    public AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2, a aVar) {
        this.a = str;
        this.f1715b = str2;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.b
    @NonNull
    public String a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.b
    @NonNull
    public String b() {
        return this.f1715b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.b)) {
            return false;
        }
        CrashlyticsReport.b bVar = (CrashlyticsReport.b) obj;
        return this.a.equals(bVar.a()) && this.f1715b.equals(bVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1715b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("CustomAttribute{key=");
        sbU.append(this.a);
        sbU.append(", value=");
        return outline.J(sbU, this.f1715b, "}");
    }
}
