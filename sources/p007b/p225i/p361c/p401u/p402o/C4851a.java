package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p401u.p402o.AbstractC4854d;
import p007b.p225i.p361c.p401u.p402o.C4853c;

/* JADX INFO: renamed from: b.i.c.u.o.a */
/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4851a extends AbstractC4854d {

    /* JADX INFO: renamed from: b */
    public final String f12952b;

    /* JADX INFO: renamed from: c */
    public final C4853c.a f12953c;

    /* JADX INFO: renamed from: d */
    public final String f12954d;

    /* JADX INFO: renamed from: e */
    public final String f12955e;

    /* JADX INFO: renamed from: f */
    public final long f12956f;

    /* JADX INFO: renamed from: g */
    public final long f12957g;

    /* JADX INFO: renamed from: h */
    public final String f12958h;

    /* JADX INFO: renamed from: b.i.c.u.o.a$b */
    /* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
    public static final class b extends AbstractC4854d.a {

        /* JADX INFO: renamed from: a */
        public String f12959a;

        /* JADX INFO: renamed from: b */
        public C4853c.a f12960b;

        /* JADX INFO: renamed from: c */
        public String f12961c;

        /* JADX INFO: renamed from: d */
        public String f12962d;

        /* JADX INFO: renamed from: e */
        public Long f12963e;

        /* JADX INFO: renamed from: f */
        public Long f12964f;

        /* JADX INFO: renamed from: g */
        public String f12965g;

        public b() {
        }

        @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d.a
        /* JADX INFO: renamed from: a */
        public AbstractC4854d mo6782a() {
            String strM883w = this.f12960b == null ? " registrationStatus" : "";
            if (this.f12963e == null) {
                strM883w = C1643a.m883w(strM883w, " expiresInSecs");
            }
            if (this.f12964f == null) {
                strM883w = C1643a.m883w(strM883w, " tokenCreationEpochInSecs");
            }
            if (strM883w.isEmpty()) {
                return new C4851a(this.f12959a, this.f12960b, this.f12961c, this.f12962d, this.f12963e.longValue(), this.f12964f.longValue(), this.f12965g, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d.a
        /* JADX INFO: renamed from: b */
        public AbstractC4854d.a mo6783b(C4853c.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f12960b = aVar;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public AbstractC4854d.a m6784c(long j) {
            this.f12963e = Long.valueOf(j);
            return this;
        }

        /* JADX INFO: renamed from: d */
        public AbstractC4854d.a m6785d(long j) {
            this.f12964f = Long.valueOf(j);
            return this;
        }

        public b(AbstractC4854d abstractC4854d, a aVar) {
            C4851a c4851a = (C4851a) abstractC4854d;
            this.f12959a = c4851a.f12952b;
            this.f12960b = c4851a.f12953c;
            this.f12961c = c4851a.f12954d;
            this.f12962d = c4851a.f12955e;
            this.f12963e = Long.valueOf(c4851a.f12956f);
            this.f12964f = Long.valueOf(c4851a.f12957g);
            this.f12965g = c4851a.f12958h;
        }
    }

    public C4851a(String str, C4853c.a aVar, String str2, String str3, long j, long j2, String str4, a aVar2) {
        this.f12952b = str;
        this.f12953c = aVar;
        this.f12954d = str2;
        this.f12955e = str3;
        this.f12956f = j;
        this.f12957g = j2;
        this.f12958h = str4;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo6774a() {
        return this.f12954d;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    /* JADX INFO: renamed from: b */
    public long mo6775b() {
        return this.f12956f;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    @Nullable
    /* JADX INFO: renamed from: c */
    public String mo6776c() {
        return this.f12952b;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    @Nullable
    /* JADX INFO: renamed from: d */
    public String mo6777d() {
        return this.f12958h;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    @Nullable
    /* JADX INFO: renamed from: e */
    public String mo6778e() {
        return this.f12955e;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4854d)) {
            return false;
        }
        AbstractC4854d abstractC4854d = (AbstractC4854d) obj;
        String str3 = this.f12952b;
        if (str3 != null ? str3.equals(abstractC4854d.mo6776c()) : abstractC4854d.mo6776c() == null) {
            if (this.f12953c.equals(abstractC4854d.mo6779f()) && ((str = this.f12954d) != null ? str.equals(abstractC4854d.mo6774a()) : abstractC4854d.mo6774a() == null) && ((str2 = this.f12955e) != null ? str2.equals(abstractC4854d.mo6778e()) : abstractC4854d.mo6778e() == null) && this.f12956f == abstractC4854d.mo6775b() && this.f12957g == abstractC4854d.mo6780g()) {
                String str4 = this.f12958h;
                if (str4 == null) {
                    if (abstractC4854d.mo6777d() == null) {
                        return true;
                    }
                } else if (str4.equals(abstractC4854d.mo6777d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    @NonNull
    /* JADX INFO: renamed from: f */
    public C4853c.a mo6779f() {
        return this.f12953c;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    /* JADX INFO: renamed from: g */
    public long mo6780g() {
        return this.f12957g;
    }

    public int hashCode() {
        String str = this.f12952b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f12953c.hashCode()) * 1000003;
        String str2 = this.f12954d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12955e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f12956f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f12957g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f12958h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // p007b.p225i.p361c.p401u.p402o.AbstractC4854d
    /* JADX INFO: renamed from: k */
    public AbstractC4854d.a mo6781k() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PersistedInstallationEntry{firebaseInstallationId=");
        sbM833U.append(this.f12952b);
        sbM833U.append(", registrationStatus=");
        sbM833U.append(this.f12953c);
        sbM833U.append(", authToken=");
        sbM833U.append(this.f12954d);
        sbM833U.append(", refreshToken=");
        sbM833U.append(this.f12955e);
        sbM833U.append(", expiresInSecs=");
        sbM833U.append(this.f12956f);
        sbM833U.append(", tokenCreationEpochInSecs=");
        sbM833U.append(this.f12957g);
        sbM833U.append(", fisError=");
        return C1643a.m822J(sbM833U, this.f12958h, "}");
    }
}
