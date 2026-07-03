package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.t */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4693t extends AbstractC4695v.d.e {

    /* JADX INFO: renamed from: a */
    public final int f12642a;

    /* JADX INFO: renamed from: b */
    public final String f12643b;

    /* JADX INFO: renamed from: c */
    public final String f12644c;

    /* JADX INFO: renamed from: d */
    public final boolean f12645d;

    public C4693t(int i, String str, String str2, boolean z2, a aVar) {
        this.f12642a = i;
        this.f12643b = str;
        this.f12644c = str2;
        this.f12645d = z2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.e
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6607a() {
        return this.f12644c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.e
    /* JADX INFO: renamed from: b */
    public int mo6608b() {
        return this.f12642a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.e
    @NonNull
    /* JADX INFO: renamed from: c */
    public String mo6609c() {
        return this.f12643b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.e
    /* JADX INFO: renamed from: d */
    public boolean mo6610d() {
        return this.f12645d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.e)) {
            return false;
        }
        AbstractC4695v.d.e eVar = (AbstractC4695v.d.e) obj;
        return this.f12642a == eVar.mo6608b() && this.f12643b.equals(eVar.mo6609c()) && this.f12644c.equals(eVar.mo6607a()) && this.f12645d == eVar.mo6610d();
    }

    public int hashCode() {
        return ((((((this.f12642a ^ 1000003) * 1000003) ^ this.f12643b.hashCode()) * 1000003) ^ this.f12644c.hashCode()) * 1000003) ^ (this.f12645d ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("OperatingSystem{platform=");
        sbM833U.append(this.f12642a);
        sbM833U.append(", version=");
        sbM833U.append(this.f12643b);
        sbM833U.append(", buildVersion=");
        sbM833U.append(this.f12644c);
        sbM833U.append(", jailbroken=");
        return C1643a.m827O(sbM833U, this.f12645d, "}");
    }
}
