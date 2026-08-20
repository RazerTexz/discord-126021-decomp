package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.m.f */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4679f extends AbstractC4695v.d {

    /* JADX INFO: renamed from: a */
    public final String f12540a;

    /* JADX INFO: renamed from: b */
    public final String f12541b;

    /* JADX INFO: renamed from: c */
    public final long f12542c;

    /* JADX INFO: renamed from: d */
    public final Long f12543d;

    /* JADX INFO: renamed from: e */
    public final boolean f12544e;

    /* JADX INFO: renamed from: f */
    public final AbstractC4695v.d.a f12545f;

    /* JADX INFO: renamed from: g */
    public final AbstractC4695v.d.f f12546g;

    /* JADX INFO: renamed from: h */
    public final AbstractC4695v.d.e f12547h;

    /* JADX INFO: renamed from: i */
    public final AbstractC4695v.d.c f12548i;

    /* JADX INFO: renamed from: j */
    public final C4696w<AbstractC4695v.d.AbstractC13233d> f12549j;

    /* JADX INFO: renamed from: k */
    public final int f12550k;

    /* JADX INFO: renamed from: b.i.c.m.d.m.f$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
    public static final class b extends AbstractC4695v.d.b {

        /* JADX INFO: renamed from: a */
        public String f12551a;

        /* JADX INFO: renamed from: b */
        public String f12552b;

        /* JADX INFO: renamed from: c */
        public Long f12553c;

        /* JADX INFO: renamed from: d */
        public Long f12554d;

        /* JADX INFO: renamed from: e */
        public Boolean f12555e;

        /* JADX INFO: renamed from: f */
        public AbstractC4695v.d.a f12556f;

        /* JADX INFO: renamed from: g */
        public AbstractC4695v.d.f f12557g;

        /* JADX INFO: renamed from: h */
        public AbstractC4695v.d.e f12558h;

        /* JADX INFO: renamed from: i */
        public AbstractC4695v.d.c f12559i;

        /* JADX INFO: renamed from: j */
        public C4696w<AbstractC4695v.d.AbstractC13233d> f12560j;

        /* JADX INFO: renamed from: k */
        public Integer f12561k;

        public b() {
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.b
        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d mo6543a() {
            String strM883w = this.f12551a == null ? " generator" : "";
            if (this.f12552b == null) {
                strM883w = C1643a.m883w(strM883w, " identifier");
            }
            if (this.f12553c == null) {
                strM883w = C1643a.m883w(strM883w, " startedAt");
            }
            if (this.f12555e == null) {
                strM883w = C1643a.m883w(strM883w, " crashed");
            }
            if (this.f12556f == null) {
                strM883w = C1643a.m883w(strM883w, " app");
            }
            if (this.f12561k == null) {
                strM883w = C1643a.m883w(strM883w, " generatorType");
            }
            if (strM883w.isEmpty()) {
                return new C4679f(this.f12551a, this.f12552b, this.f12553c.longValue(), this.f12554d, this.f12555e.booleanValue(), this.f12556f, this.f12557g, this.f12558h, this.f12559i, this.f12560j, this.f12561k.intValue(), null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        /* JADX INFO: renamed from: b */
        public AbstractC4695v.d.b m6544b(boolean z2) {
            this.f12555e = Boolean.valueOf(z2);
            return this;
        }

        public b(AbstractC4695v.d dVar, a aVar) {
            C4679f c4679f = (C4679f) dVar;
            this.f12551a = c4679f.f12540a;
            this.f12552b = c4679f.f12541b;
            this.f12553c = Long.valueOf(c4679f.f12542c);
            this.f12554d = c4679f.f12543d;
            this.f12555e = Boolean.valueOf(c4679f.f12544e);
            this.f12556f = c4679f.f12545f;
            this.f12557g = c4679f.f12546g;
            this.f12558h = c4679f.f12547h;
            this.f12559i = c4679f.f12548i;
            this.f12560j = c4679f.f12549j;
            this.f12561k = Integer.valueOf(c4679f.f12550k);
        }
    }

    public C4679f(String str, String str2, long j, Long l, boolean z2, AbstractC4695v.d.a aVar, AbstractC4695v.d.f fVar, AbstractC4695v.d.e eVar, AbstractC4695v.d.c cVar, C4696w c4696w, int i, a aVar2) {
        this.f12540a = str;
        this.f12541b = str2;
        this.f12542c = j;
        this.f12543d = l;
        this.f12544e = z2;
        this.f12545f = aVar;
        this.f12546g = fVar;
        this.f12547h = eVar;
        this.f12548i = cVar;
        this.f12549j = c4696w;
        this.f12550k = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @NonNull
    /* JADX INFO: renamed from: a */
    public AbstractC4695v.d.a mo6531a() {
        return this.f12545f;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC4695v.d.c mo6532b() {
        return this.f12548i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @Nullable
    /* JADX INFO: renamed from: c */
    public Long mo6533c() {
        return this.f12543d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @Nullable
    /* JADX INFO: renamed from: d */
    public C4696w<AbstractC4695v.d.AbstractC13233d> mo6534d() {
        return this.f12549j;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @NonNull
    /* JADX INFO: renamed from: e */
    public String mo6535e() {
        return this.f12540a;
    }

    public boolean equals(Object obj) {
        Long l;
        AbstractC4695v.d.f fVar;
        AbstractC4695v.d.e eVar;
        AbstractC4695v.d.c cVar;
        C4696w<AbstractC4695v.d.AbstractC13233d> c4696w;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d)) {
            return false;
        }
        AbstractC4695v.d dVar = (AbstractC4695v.d) obj;
        return this.f12540a.equals(dVar.mo6535e()) && this.f12541b.equals(dVar.mo6537g()) && this.f12542c == dVar.mo6539i() && ((l = this.f12543d) != null ? l.equals(dVar.mo6533c()) : dVar.mo6533c() == null) && this.f12544e == dVar.mo6541k() && this.f12545f.equals(dVar.mo6531a()) && ((fVar = this.f12546g) != null ? fVar.equals(dVar.mo6540j()) : dVar.mo6540j() == null) && ((eVar = this.f12547h) != null ? eVar.equals(dVar.mo6538h()) : dVar.mo6538h() == null) && ((cVar = this.f12548i) != null ? cVar.equals(dVar.mo6532b()) : dVar.mo6532b() == null) && ((c4696w = this.f12549j) != null ? c4696w.equals(dVar.mo6534d()) : dVar.mo6534d() == null) && this.f12550k == dVar.mo6536f();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    /* JADX INFO: renamed from: f */
    public int mo6536f() {
        return this.f12550k;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @NonNull
    /* JADX INFO: renamed from: g */
    public String mo6537g() {
        return this.f12541b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @Nullable
    /* JADX INFO: renamed from: h */
    public AbstractC4695v.d.e mo6538h() {
        return this.f12547h;
    }

    public int hashCode() {
        int iHashCode = (((this.f12540a.hashCode() ^ 1000003) * 1000003) ^ this.f12541b.hashCode()) * 1000003;
        long j = this.f12542c;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.f12543d;
        int iHashCode2 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f12544e ? 1231 : 1237)) * 1000003) ^ this.f12545f.hashCode()) * 1000003;
        AbstractC4695v.d.f fVar = this.f12546g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        AbstractC4695v.d.e eVar = this.f12547h;
        int iHashCode4 = (iHashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        AbstractC4695v.d.c cVar = this.f12548i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        C4696w<AbstractC4695v.d.AbstractC13233d> c4696w = this.f12549j;
        return ((iHashCode5 ^ (c4696w != null ? c4696w.hashCode() : 0)) * 1000003) ^ this.f12550k;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    /* JADX INFO: renamed from: i */
    public long mo6539i() {
        return this.f12542c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    @Nullable
    /* JADX INFO: renamed from: j */
    public AbstractC4695v.d.f mo6540j() {
        return this.f12546g;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    /* JADX INFO: renamed from: k */
    public boolean mo6541k() {
        return this.f12544e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d
    /* JADX INFO: renamed from: l */
    public AbstractC4695v.d.b mo6542l() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Session{generator=");
        sbM833U.append(this.f12540a);
        sbM833U.append(", identifier=");
        sbM833U.append(this.f12541b);
        sbM833U.append(", startedAt=");
        sbM833U.append(this.f12542c);
        sbM833U.append(", endedAt=");
        sbM833U.append(this.f12543d);
        sbM833U.append(", crashed=");
        sbM833U.append(this.f12544e);
        sbM833U.append(", app=");
        sbM833U.append(this.f12545f);
        sbM833U.append(", user=");
        sbM833U.append(this.f12546g);
        sbM833U.append(", os=");
        sbM833U.append(this.f12547h);
        sbM833U.append(", device=");
        sbM833U.append(this.f12548i);
        sbM833U.append(", events=");
        sbM833U.append(this.f12549j);
        sbM833U.append(", generatorType=");
        return C1643a.m814B(sbM833U, this.f12550k, "}");
    }
}
