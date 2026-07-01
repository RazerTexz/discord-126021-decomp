package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.m, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1727b;
    public final String c;
    public final String d;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j, long j2, String str, String str2, a aVar) {
        this.a = j;
        this.f1727b = j2;
        this.c = str;
        this.d = str2;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a
    @NonNull
    public long a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a
    @NonNull
    public String b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a
    public long c() {
        return this.f1727b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a
    @Nullable
    public String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a abstractC0051a = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a) obj;
        if (this.a == abstractC0051a.a() && this.f1727b == abstractC0051a.c() && this.c.equals(abstractC0051a.b())) {
            String str = this.d;
            if (str == null) {
                if (abstractC0051a.d() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0051a.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f1727b;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str = this.d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbU = outline.U("BinaryImage{baseAddress=");
        sbU.append(this.a);
        sbU.append(", size=");
        sbU.append(this.f1727b);
        sbU.append(", name=");
        sbU.append(this.c);
        sbU.append(", uuid=");
        return outline.J(sbU, this.d, "}");
    }
}
