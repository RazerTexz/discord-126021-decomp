package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.o */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4688o extends AbstractC4695v.d.AbstractC13233d.a.b.c {

    /* JADX INFO: renamed from: a */
    public final String f12613a;

    /* JADX INFO: renamed from: b */
    public final String f12614b;

    /* JADX INFO: renamed from: c */
    public final long f12615c;

    public C4688o(String str, String str2, long j, a aVar) {
        this.f12613a = str;
        this.f12614b = str2;
        this.f12615c = j;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.c
    @NonNull
    /* JADX INFO: renamed from: a */
    public long mo6587a() {
        return this.f12615c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.c
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo6588b() {
        return this.f12614b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.c
    @NonNull
    /* JADX INFO: renamed from: c */
    public String mo6589c() {
        return this.f12613a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a.b.c)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a.b.c cVar = (AbstractC4695v.d.AbstractC13233d.a.b.c) obj;
        return this.f12613a.equals(cVar.mo6589c()) && this.f12614b.equals(cVar.mo6588b()) && this.f12615c == cVar.mo6587a();
    }

    public int hashCode() {
        int iHashCode = (((this.f12613a.hashCode() ^ 1000003) * 1000003) ^ this.f12614b.hashCode()) * 1000003;
        long j = this.f12615c;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Signal{name=");
        sbM833U.append(this.f12613a);
        sbM833U.append(", code=");
        sbM833U.append(this.f12614b);
        sbM833U.append(", address=");
        return C1643a.m815C(sbM833U, this.f12615c, "}");
    }
}
