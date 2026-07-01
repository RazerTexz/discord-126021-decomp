package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.k, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.d.AbstractC0049d.a {
    public final CrashlyticsReport.d.AbstractC0049d.a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList3<CrashlyticsReport.b> f1724b;
    public final Boolean c;
    public final int d;

    /* JADX INFO: renamed from: b.i.c.m.d.m.k$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    public static final class b extends CrashlyticsReport.d.AbstractC0049d.a.AbstractC0050a {
        public CrashlyticsReport.d.AbstractC0049d.a.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImmutableList3<CrashlyticsReport.b> f1725b;
        public Boolean c;
        public Integer d;

        public b() {
        }

        public CrashlyticsReport.d.AbstractC0049d.a a() {
            String strW = this.a == null ? " execution" : "";
            if (this.d == null) {
                strW = outline.w(strW, " uiOrientation");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.a, this.f1725b, this.c, this.d.intValue(), null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        public b(CrashlyticsReport.d.AbstractC0049d.a aVar, a aVar2) {
            AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = (AutoValue_CrashlyticsReport_Session_Event_Application) aVar;
            this.a = autoValue_CrashlyticsReport_Session_Event_Application.a;
            this.f1725b = autoValue_CrashlyticsReport_Session_Event_Application.f1724b;
            this.c = autoValue_CrashlyticsReport_Session_Event_Application.c;
            this.d = Integer.valueOf(autoValue_CrashlyticsReport_Session_Event_Application.d);
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.d.AbstractC0049d.a.b bVar, ImmutableList3 immutableList3, Boolean bool, int i, a aVar) {
        this.a = bVar;
        this.f1724b = immutableList3;
        this.c = bool;
        this.d = i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a
    @Nullable
    public Boolean a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a
    @Nullable
    public ImmutableList3<CrashlyticsReport.b> b() {
        return this.f1724b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a
    @NonNull
    public CrashlyticsReport.d.AbstractC0049d.a.b c() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.AbstractC0049d.a
    public int d() {
        return this.d;
    }

    public CrashlyticsReport.d.AbstractC0049d.a.AbstractC0050a e() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        ImmutableList3<CrashlyticsReport.b> immutableList3;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC0049d.a)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC0049d.a aVar = (CrashlyticsReport.d.AbstractC0049d.a) obj;
        return this.a.equals(aVar.c()) && ((immutableList3 = this.f1724b) != null ? immutableList3.equals(aVar.b()) : aVar.b() == null) && ((bool = this.c) != null ? bool.equals(aVar.a()) : aVar.a() == null) && this.d == aVar.d();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        ImmutableList3<CrashlyticsReport.b> immutableList3 = this.f1724b;
        int iHashCode2 = (iHashCode ^ (immutableList3 == null ? 0 : immutableList3.hashCode())) * 1000003;
        Boolean bool = this.c;
        return ((iHashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.d;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Application{execution=");
        sbU.append(this.a);
        sbU.append(", customAttributes=");
        sbU.append(this.f1724b);
        sbU.append(", background=");
        sbU.append(this.c);
        sbU.append(", uiOrientation=");
        return outline.B(sbU, this.d, "}");
    }
}
