package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.l, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.d.AbstractC0049d.a.b {
    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b f1726b;
    public final CrashlyticsReport.d.AbstractC0049d.a.b.c c;
    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a> d;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList3 immutableList3, CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b, CrashlyticsReport.d.AbstractC0049d.a.b.c cVar, ImmutableList3 immutableList4, a aVar) {
        this.a = immutableList3;
        this.f1726b = abstractC0052b;
        this.c = cVar;
        this.d = immutableList4;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b
    @NonNull
    public ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a> a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b
    @NonNull
    public CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b b() {
        return this.f1726b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b
    @NonNull
    public CrashlyticsReport.d.AbstractC0049d.a.b.c c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b
    @NonNull
    public ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d> d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b bVar = (CrashlyticsReport.d.AbstractC0049d.a.b) obj;
        return this.a.equals(bVar.d()) && this.f1726b.equals(bVar.b()) && this.c.equals(bVar.c()) && this.d.equals(bVar.a());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1726b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("Execution{threads=");
        sbU.append(this.a);
        sbU.append(", exception=");
        sbU.append(this.f1726b);
        sbU.append(", signal=");
        sbU.append(this.c);
        sbU.append(", binaries=");
        sbU.append(this.d);
        sbU.append("}");
        return sbU.toString();
    }
}
