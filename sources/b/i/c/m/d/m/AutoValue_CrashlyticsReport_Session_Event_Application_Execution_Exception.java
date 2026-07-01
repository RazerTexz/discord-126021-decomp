package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.n, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1728b;
    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> c;
    public final CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b d;
    public final int e;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList3 immutableList3, CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b, int i, a aVar) {
        this.a = str;
        this.f1728b = str2;
        this.c = immutableList3;
        this.d = abstractC0052b;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b
    @Nullable
    public CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b
    @NonNull
    public ImmutableList3<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b
    public int c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b
    @Nullable
    public String d() {
        return this.f1728b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b2 = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b) obj;
        return this.a.equals(abstractC0052b2.e()) && ((str = this.f1728b) != null ? str.equals(abstractC0052b2.d()) : abstractC0052b2.d() == null) && this.c.equals(abstractC0052b2.b()) && ((abstractC0052b = this.d) != null ? abstractC0052b.equals(abstractC0052b2.a()) : abstractC0052b2.a() == null) && this.e == abstractC0052b2.c();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f1728b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b = this.d;
        return ((iHashCode2 ^ (abstractC0052b != null ? abstractC0052b.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Exception{type=");
        sbU.append(this.a);
        sbU.append(", reason=");
        sbU.append(this.f1728b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append(", causedBy=");
        sbU.append(this.d);
        sbU.append(", overflowCount=");
        return outline.B(sbU, this.e, "}");
    }
}
