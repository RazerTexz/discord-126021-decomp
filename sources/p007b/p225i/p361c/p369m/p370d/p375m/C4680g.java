package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.g */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4680g extends AbstractC4695v.d.a {

    /* JADX INFO: renamed from: a */
    public final String f12562a;

    /* JADX INFO: renamed from: b */
    public final String f12563b;

    /* JADX INFO: renamed from: c */
    public final String f12564c;

    /* JADX INFO: renamed from: d */
    public final AbstractC4695v.d.a.AbstractC13232a f12565d = null;

    /* JADX INFO: renamed from: e */
    public final String f12566e;

    /* JADX INFO: renamed from: f */
    public final String f12567f;

    /* JADX INFO: renamed from: g */
    public final String f12568g;

    public C4680g(String str, String str2, String str3, AbstractC4695v.d.a.AbstractC13232a abstractC13232a, String str4, String str5, String str6, a aVar) {
        this.f12562a = str;
        this.f12563b = str2;
        this.f12564c = str3;
        this.f12566e = str4;
        this.f12567f = str5;
        this.f12568g = str6;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo6545a() {
        return this.f12567f;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @Nullable
    /* JADX INFO: renamed from: b */
    public String mo6546b() {
        return this.f12568g;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @Nullable
    /* JADX INFO: renamed from: c */
    public String mo6547c() {
        return this.f12564c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @NonNull
    /* JADX INFO: renamed from: d */
    public String mo6548d() {
        return this.f12562a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @Nullable
    /* JADX INFO: renamed from: e */
    public String mo6549e() {
        return this.f12566e;
    }

    public boolean equals(Object obj) {
        String str;
        AbstractC4695v.d.a.AbstractC13232a abstractC13232a;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.a)) {
            return false;
        }
        AbstractC4695v.d.a aVar = (AbstractC4695v.d.a) obj;
        if (this.f12562a.equals(aVar.mo6548d()) && this.f12563b.equals(aVar.mo6551g()) && ((str = this.f12564c) != null ? str.equals(aVar.mo6547c()) : aVar.mo6547c() == null) && ((abstractC13232a = this.f12565d) != null ? abstractC13232a.equals(aVar.mo6550f()) : aVar.mo6550f() == null) && ((str2 = this.f12566e) != null ? str2.equals(aVar.mo6549e()) : aVar.mo6549e() == null) && ((str3 = this.f12567f) != null ? str3.equals(aVar.mo6545a()) : aVar.mo6545a() == null)) {
            String str4 = this.f12568g;
            if (str4 == null) {
                if (aVar.mo6546b() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.mo6546b())) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @Nullable
    /* JADX INFO: renamed from: f */
    public AbstractC4695v.d.a.AbstractC13232a mo6550f() {
        return this.f12565d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.a
    @NonNull
    /* JADX INFO: renamed from: g */
    public String mo6551g() {
        return this.f12563b;
    }

    public int hashCode() {
        int iHashCode = (((this.f12562a.hashCode() ^ 1000003) * 1000003) ^ this.f12563b.hashCode()) * 1000003;
        String str = this.f12564c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        AbstractC4695v.d.a.AbstractC13232a abstractC13232a = this.f12565d;
        int iHashCode3 = (iHashCode2 ^ (abstractC13232a == null ? 0 : abstractC13232a.hashCode())) * 1000003;
        String str2 = this.f12566e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12567f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f12568g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Application{identifier=");
        sbM833U.append(this.f12562a);
        sbM833U.append(", version=");
        sbM833U.append(this.f12563b);
        sbM833U.append(", displayVersion=");
        sbM833U.append(this.f12564c);
        sbM833U.append(", organization=");
        sbM833U.append(this.f12565d);
        sbM833U.append(", installationUuid=");
        sbM833U.append(this.f12566e);
        sbM833U.append(", developmentPlatform=");
        sbM833U.append(this.f12567f);
        sbM833U.append(", developmentPlatformVersion=");
        return C1643a.m822J(sbM833U, this.f12568g, "}");
    }
}
