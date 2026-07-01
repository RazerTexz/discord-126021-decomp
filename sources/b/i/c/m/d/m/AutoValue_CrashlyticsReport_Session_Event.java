package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.j, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.d.AbstractC0049d {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1723b;
    public final CrashlyticsReport.d.AbstractC0049d.a c;
    public final CrashlyticsReport.d.AbstractC0049d.b d;
    public final CrashlyticsReport.d.AbstractC0049d.c e;

    public AutoValue_CrashlyticsReport_Session_Event(long j, String str, CrashlyticsReport.d.AbstractC0049d.a aVar, CrashlyticsReport.d.AbstractC0049d.b bVar, CrashlyticsReport.d.AbstractC0049d.c cVar, a aVar2) {
        this.a = j;
        this.f1723b = str;
        this.c = aVar;
        this.d = bVar;
        this.e = cVar;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d
    @NonNull
    public CrashlyticsReport.d.AbstractC0049d.a a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d
    @NonNull
    public CrashlyticsReport.d.AbstractC0049d.b b() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d
    @Nullable
    public CrashlyticsReport.d.AbstractC0049d.c c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d
    @NonNull
    public String e() {
        return this.f1723b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d abstractC0049d = (CrashlyticsReport.d.AbstractC0049d) obj;
        if (this.a == abstractC0049d.d() && this.f1723b.equals(abstractC0049d.e()) && this.c.equals(abstractC0049d.a()) && this.d.equals(abstractC0049d.b())) {
            CrashlyticsReport.d.AbstractC0049d.c cVar = this.e;
            if (cVar == null) {
                if (abstractC0049d.c() == null) {
                    return true;
                }
            } else if (cVar.equals(abstractC0049d.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1723b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        CrashlyticsReport.d.AbstractC0049d.c cVar = this.e;
        return (cVar == null ? 0 : cVar.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Event{timestamp=");
        sbU.append(this.a);
        sbU.append(", type=");
        sbU.append(this.f1723b);
        sbU.append(", app=");
        sbU.append(this.c);
        sbU.append(", device=");
        sbU.append(this.d);
        sbU.append(", log=");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
