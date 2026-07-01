package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1713b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final CrashlyticsReport.d h;
    public final CrashlyticsReport.c i;

    /* JADX INFO: renamed from: b.i.c.m.d.m.b$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
    public static final class b extends CrashlyticsReport.a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1714b;
        public Integer c;
        public String d;
        public String e;
        public String f;
        public CrashlyticsReport.d g;
        public CrashlyticsReport.c h;

        public b() {
        }

        @Override // b.i.c.m.d.m.CrashlyticsReport.a
        public CrashlyticsReport a() {
            String strW = this.a == null ? " sdkVersion" : "";
            if (this.f1714b == null) {
                strW = outline.w(strW, " gmpAppId");
            }
            if (this.c == null) {
                strW = outline.w(strW, " platform");
            }
            if (this.d == null) {
                strW = outline.w(strW, " installationUuid");
            }
            if (this.e == null) {
                strW = outline.w(strW, " buildVersion");
            }
            if (this.f == null) {
                strW = outline.w(strW, " displayVersion");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.a, this.f1714b, this.c.intValue(), this.d, this.e, this.f, this.g, this.h, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        public b(CrashlyticsReport crashlyticsReport, a aVar) {
            AutoValue_CrashlyticsReport autoValue_CrashlyticsReport = (AutoValue_CrashlyticsReport) crashlyticsReport;
            this.a = autoValue_CrashlyticsReport.f1713b;
            this.f1714b = autoValue_CrashlyticsReport.c;
            this.c = Integer.valueOf(autoValue_CrashlyticsReport.d);
            this.d = autoValue_CrashlyticsReport.e;
            this.e = autoValue_CrashlyticsReport.f;
            this.f = autoValue_CrashlyticsReport.g;
            this.g = autoValue_CrashlyticsReport.h;
            this.h = autoValue_CrashlyticsReport.i;
        }
    }

    public AutoValue_CrashlyticsReport(String str, String str2, int i, String str3, String str4, String str5, CrashlyticsReport.d dVar, CrashlyticsReport.c cVar, a aVar) {
        this.f1713b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = dVar;
        this.i = cVar;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @NonNull
    public String a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @NonNull
    public String b() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @NonNull
    public String c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @NonNull
    public String d() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.c e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f1713b.equals(crashlyticsReport.g()) && this.c.equals(crashlyticsReport.c()) && this.d == crashlyticsReport.f() && this.e.equals(crashlyticsReport.d()) && this.f.equals(crashlyticsReport.a()) && this.g.equals(crashlyticsReport.b()) && ((dVar = this.h) != null ? dVar.equals(crashlyticsReport.h()) : crashlyticsReport.h() == null)) {
            CrashlyticsReport.c cVar = this.i;
            if (cVar == null) {
                if (crashlyticsReport.e() == null) {
                    return true;
                }
            } else if (cVar.equals(crashlyticsReport.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    public int f() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @NonNull
    public String g() {
        return this.f1713b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    @Nullable
    public CrashlyticsReport.d h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f1713b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003;
        CrashlyticsReport.d dVar = this.h;
        int iHashCode2 = (iHashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        CrashlyticsReport.c cVar = this.i;
        return iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0);
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport
    public CrashlyticsReport.a i() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CrashlyticsReport{sdkVersion=");
        sbU.append(this.f1713b);
        sbU.append(", gmpAppId=");
        sbU.append(this.c);
        sbU.append(", platform=");
        sbU.append(this.d);
        sbU.append(", installationUuid=");
        sbU.append(this.e);
        sbU.append(", buildVersion=");
        sbU.append(this.f);
        sbU.append(", displayVersion=");
        sbU.append(this.g);
        sbU.append(", session=");
        sbU.append(this.h);
        sbU.append(", ndkPayload=");
        sbU.append(this.i);
        sbU.append("}");
        return sbU.toString();
    }
}
