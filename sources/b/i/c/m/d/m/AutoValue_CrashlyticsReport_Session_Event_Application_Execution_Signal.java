package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.o, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.d.AbstractC0049d.a.b.c {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1729b;
    public final long c;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j, a aVar) {
        this.a = str;
        this.f1729b = str2;
        this.c = j;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.c
    @NonNull
    public long a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.c
    @NonNull
    public String b() {
        return this.f1729b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.c
    @NonNull
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b.c)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.c cVar = (CrashlyticsReport.d.AbstractC0049d.a.b.c) obj;
        return this.a.equals(cVar.c()) && this.f1729b.equals(cVar.b()) && this.c == cVar.a();
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1729b.hashCode()) * 1000003;
        long j = this.c;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("Signal{name=");
        sbU.append(this.a);
        sbU.append(", code=");
        sbU.append(this.f1729b);
        sbU.append(", address=");
        return outline.C(sbU, this.c, "}");
    }
}
