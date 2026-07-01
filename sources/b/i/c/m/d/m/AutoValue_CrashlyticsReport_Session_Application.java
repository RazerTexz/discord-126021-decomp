package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.g, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.d.a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1720b;
    public final String c;
    public final CrashlyticsReport.d.a.AbstractC0048a d = null;
    public final String e;
    public final String f;
    public final String g;

    public AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, CrashlyticsReport.d.a.AbstractC0048a abstractC0048a, String str4, String str5, String str6, a aVar) {
        this.a = str;
        this.f1720b = str2;
        this.c = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @Nullable
    public String a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @Nullable
    public String b() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @Nullable
    public String c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @NonNull
    public String d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @Nullable
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.d.a.AbstractC0048a abstractC0048a;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.a)) {
            return false;
        }
        CrashlyticsReport.d.a aVar = (CrashlyticsReport.d.a) obj;
        if (this.a.equals(aVar.d()) && this.f1720b.equals(aVar.g()) && ((str = this.c) != null ? str.equals(aVar.c()) : aVar.c() == null) && ((abstractC0048a = this.d) != null ? abstractC0048a.equals(aVar.f()) : aVar.f() == null) && ((str2 = this.e) != null ? str2.equals(aVar.e()) : aVar.e() == null) && ((str3 = this.f) != null ? str3.equals(aVar.a()) : aVar.a() == null)) {
            String str4 = this.g;
            if (str4 == null) {
                if (aVar.b() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @Nullable
    public CrashlyticsReport.d.a.AbstractC0048a f() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d.a
    @NonNull
    public String g() {
        return this.f1720b;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1720b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.d.a.AbstractC0048a abstractC0048a = this.d;
        int iHashCode3 = (iHashCode2 ^ (abstractC0048a == null ? 0 : abstractC0048a.hashCode())) * 1000003;
        String str2 = this.e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Application{identifier=");
        sbU.append(this.a);
        sbU.append(", version=");
        sbU.append(this.f1720b);
        sbU.append(", displayVersion=");
        sbU.append(this.c);
        sbU.append(", organization=");
        sbU.append(this.d);
        sbU.append(", installationUuid=");
        sbU.append(this.e);
        sbU.append(", developmentPlatform=");
        sbU.append(this.f);
        sbU.append(", developmentPlatformVersion=");
        return outline.J(sbU, this.g, "}");
    }
}
