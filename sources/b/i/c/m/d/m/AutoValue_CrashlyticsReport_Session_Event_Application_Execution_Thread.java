package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.p, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1730b;
    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> c;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, int i, ImmutableList3 immutableList3, a aVar) {
        this.a = str;
        this.f1730b = i;
        this.c = immutableList3;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d
    @NonNull
    public ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d
    public int b() {
        return this.f1730b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d
    @NonNull
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d abstractC0053d = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d) obj;
        return this.a.equals(abstractC0053d.c()) && this.f1730b == abstractC0053d.b() && this.c.equals(abstractC0053d.a());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1730b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("Thread{name=");
        sbU.append(this.a);
        sbU.append(", importance=");
        sbU.append(this.f1730b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
