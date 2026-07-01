package b.i.c.m.d.k;

import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.m.d.k.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {
    public final CrashlyticsReport a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1678b;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str) {
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.a = crashlyticsReport;
        Objects.requireNonNull(str, "Null sessionId");
        this.f1678b = str;
    }

    @Override // b.i.c.m.d.k.CrashlyticsReportWithSessionId
    public CrashlyticsReport a() {
        return this.a;
    }

    @Override // b.i.c.m.d.k.CrashlyticsReportWithSessionId
    public String b() {
        return this.f1678b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        return this.a.equals(crashlyticsReportWithSessionId.a()) && this.f1678b.equals(crashlyticsReportWithSessionId.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1678b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("CrashlyticsReportWithSessionId{report=");
        sbU.append(this.a);
        sbU.append(", sessionId=");
        return outline.J(sbU, this.f1678b, "}");
    }
}
