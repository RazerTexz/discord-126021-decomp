package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.m.m */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4686m extends AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a {

    /* JADX INFO: renamed from: a */
    public final long f12604a;

    /* JADX INFO: renamed from: b */
    public final long f12605b;

    /* JADX INFO: renamed from: c */
    public final String f12606c;

    /* JADX INFO: renamed from: d */
    public final String f12607d;

    public C4686m(long j, long j2, String str, String str2, a aVar) {
        this.f12604a = j;
        this.f12605b = j2;
        this.f12606c = str;
        this.f12607d = str2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a
    @NonNull
    /* JADX INFO: renamed from: a */
    public long mo6578a() {
        return this.f12604a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo6579b() {
        return this.f12606c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a
    /* JADX INFO: renamed from: c */
    public long mo6580c() {
        return this.f12605b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a
    @Nullable
    /* JADX INFO: renamed from: d */
    public String mo6581d() {
        return this.f12607d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a abstractC13235a = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a) obj;
        if (this.f12604a == abstractC13235a.mo6578a() && this.f12605b == abstractC13235a.mo6580c() && this.f12606c.equals(abstractC13235a.mo6579b())) {
            String str = this.f12607d;
            if (str == null) {
                if (abstractC13235a.mo6581d() == null) {
                    return true;
                }
            } else if (str.equals(abstractC13235a.mo6581d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f12604a;
        long j2 = this.f12605b;
        int iHashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f12606c.hashCode()) * 1000003;
        String str = this.f12607d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BinaryImage{baseAddress=");
        sbM833U.append(this.f12604a);
        sbM833U.append(", size=");
        sbM833U.append(this.f12605b);
        sbM833U.append(", name=");
        sbM833U.append(this.f12606c);
        sbM833U.append(", uuid=");
        return C1643a.m822J(sbM833U, this.f12607d, "}");
    }
}
