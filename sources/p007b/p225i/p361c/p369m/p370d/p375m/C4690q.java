package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.q */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4690q extends AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a {

    /* JADX INFO: renamed from: a */
    public final long f12619a;

    /* JADX INFO: renamed from: b */
    public final String f12620b;

    /* JADX INFO: renamed from: c */
    public final String f12621c;

    /* JADX INFO: renamed from: d */
    public final long f12622d;

    /* JADX INFO: renamed from: e */
    public final int f12623e;

    /* JADX INFO: renamed from: b.i.c.m.d.m.q$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
    public static final class b extends AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a.AbstractC13239a {

        /* JADX INFO: renamed from: a */
        public Long f12624a;

        /* JADX INFO: renamed from: b */
        public String f12625b;

        /* JADX INFO: renamed from: c */
        public String f12626c;

        /* JADX INFO: renamed from: d */
        public Long f12627d;

        /* JADX INFO: renamed from: e */
        public Integer f12628e;

        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a m6598a() {
            String strM883w = this.f12624a == null ? " pc" : "";
            if (this.f12625b == null) {
                strM883w = C1643a.m883w(strM883w, " symbol");
            }
            if (this.f12627d == null) {
                strM883w = C1643a.m883w(strM883w, " offset");
            }
            if (this.f12628e == null) {
                strM883w = C1643a.m883w(strM883w, " importance");
            }
            if (strM883w.isEmpty()) {
                return new C4690q(this.f12624a.longValue(), this.f12625b, this.f12626c, this.f12627d.longValue(), this.f12628e.intValue(), null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
    }

    public C4690q(long j, String str, String str2, long j2, int i, a aVar) {
        this.f12619a = j;
        this.f12620b = str;
        this.f12621c = str2;
        this.f12622d = j2;
        this.f12623e = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo6593a() {
        return this.f12621c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a
    /* JADX INFO: renamed from: b */
    public int mo6594b() {
        return this.f12623e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a
    /* JADX INFO: renamed from: c */
    public long mo6595c() {
        return this.f12622d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a
    /* JADX INFO: renamed from: d */
    public long mo6596d() {
        return this.f12619a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a
    @NonNull
    /* JADX INFO: renamed from: e */
    public String mo6597e() {
        return this.f12620b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a abstractC13238a = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a) obj;
        return this.f12619a == abstractC13238a.mo6596d() && this.f12620b.equals(abstractC13238a.mo6597e()) && ((str = this.f12621c) != null ? str.equals(abstractC13238a.mo6593a()) : abstractC13238a.mo6593a() == null) && this.f12622d == abstractC13238a.mo6595c() && this.f12623e == abstractC13238a.mo6594b();
    }

    public int hashCode() {
        long j = this.f12619a;
        int iHashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f12620b.hashCode()) * 1000003;
        String str = this.f12621c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.f12622d;
        return this.f12623e ^ ((iHashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Frame{pc=");
        sbM833U.append(this.f12619a);
        sbM833U.append(", symbol=");
        sbM833U.append(this.f12620b);
        sbM833U.append(", file=");
        sbM833U.append(this.f12621c);
        sbM833U.append(", offset=");
        sbM833U.append(this.f12622d);
        sbM833U.append(", importance=");
        return C1643a.m814B(sbM833U, this.f12623e, "}");
    }
}
