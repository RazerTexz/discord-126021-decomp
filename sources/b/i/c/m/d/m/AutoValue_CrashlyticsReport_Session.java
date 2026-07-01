package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.f, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1718b;
    public final long c;
    public final Long d;
    public final boolean e;
    public final CrashlyticsReport.d.a f;
    public final CrashlyticsReport.d.f g;
    public final CrashlyticsReport.d.e h;
    public final CrashlyticsReport.d.c i;
    public final ImmutableList3<CrashlyticsReport.d.AbstractC0049d> j;
    public final int k;

    /* JADX INFO: renamed from: b.i.c.m.d.m.f$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session.java */
    public static final class b extends CrashlyticsReport.d.b {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1719b;
        public Long c;
        public Long d;
        public Boolean e;
        public CrashlyticsReport.d.a f;
        public CrashlyticsReport.d.f g;
        public CrashlyticsReport.d.e h;
        public CrashlyticsReport.d.c i;
        public ImmutableList3<CrashlyticsReport.d.AbstractC0049d> j;
        public Integer k;

        public b() {
        }

        @Override // b.i.c.m.d.m.CrashlyticsReport.d.b
        public CrashlyticsReport.d a() {
            String strW = this.a == null ? " generator" : "";
            if (this.f1719b == null) {
                strW = outline.w(strW, " identifier");
            }
            if (this.c == null) {
                strW = outline.w(strW, " startedAt");
            }
            if (this.e == null) {
                strW = outline.w(strW, " crashed");
            }
            if (this.f == null) {
                strW = outline.w(strW, " app");
            }
            if (this.k == null) {
                strW = outline.w(strW, " generatorType");
            }
            if (strW.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.a, this.f1719b, this.c.longValue(), this.d, this.e.booleanValue(), this.f, this.g, this.h, this.i, this.j, this.k.intValue(), null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        public CrashlyticsReport.d.b b(boolean z2) {
            this.e = Boolean.valueOf(z2);
            return this;
        }

        public b(CrashlyticsReport.d dVar, a aVar) {
            AutoValue_CrashlyticsReport_Session autoValue_CrashlyticsReport_Session = (AutoValue_CrashlyticsReport_Session) dVar;
            this.a = autoValue_CrashlyticsReport_Session.a;
            this.f1719b = autoValue_CrashlyticsReport_Session.f1718b;
            this.c = Long.valueOf(autoValue_CrashlyticsReport_Session.c);
            this.d = autoValue_CrashlyticsReport_Session.d;
            this.e = Boolean.valueOf(autoValue_CrashlyticsReport_Session.e);
            this.f = autoValue_CrashlyticsReport_Session.f;
            this.g = autoValue_CrashlyticsReport_Session.g;
            this.h = autoValue_CrashlyticsReport_Session.h;
            this.i = autoValue_CrashlyticsReport_Session.i;
            this.j = autoValue_CrashlyticsReport_Session.j;
            this.k = Integer.valueOf(autoValue_CrashlyticsReport_Session.k);
        }
    }

    public AutoValue_CrashlyticsReport_Session(String str, String str2, long j, Long l, boolean z2, CrashlyticsReport.d.a aVar, CrashlyticsReport.d.f fVar, CrashlyticsReport.d.e eVar, CrashlyticsReport.d.c cVar, ImmutableList3 immutableList3, int i, a aVar2) {
        this.a = str;
        this.f1718b = str2;
        this.c = j;
        this.d = l;
        this.e = z2;
        this.f = aVar;
        this.g = fVar;
        this.h = eVar;
        this.i = cVar;
        this.j = immutableList3;
        this.k = i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @NonNull
    public CrashlyticsReport.d.a a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @Nullable
    public CrashlyticsReport.d.c b() {
        return this.i;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @Nullable
    public Long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @Nullable
    public ImmutableList3<CrashlyticsReport.d.AbstractC0049d> d() {
        return this.j;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        Long l;
        CrashlyticsReport.d.f fVar;
        CrashlyticsReport.d.e eVar;
        CrashlyticsReport.d.c cVar;
        ImmutableList3<CrashlyticsReport.d.AbstractC0049d> immutableList3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d)) {
            return false;
        }
        CrashlyticsReport.d dVar = (CrashlyticsReport.d) obj;
        return this.a.equals(dVar.e()) && this.f1718b.equals(dVar.g()) && this.c == dVar.i() && ((l = this.d) != null ? l.equals(dVar.c()) : dVar.c() == null) && this.e == dVar.k() && this.f.equals(dVar.a()) && ((fVar = this.g) != null ? fVar.equals(dVar.j()) : dVar.j() == null) && ((eVar = this.h) != null ? eVar.equals(dVar.h()) : dVar.h() == null) && ((cVar = this.i) != null ? cVar.equals(dVar.b()) : dVar.b() == null) && ((immutableList3 = this.j) != null ? immutableList3.equals(dVar.d()) : dVar.d() == null) && this.k == dVar.f();
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    public int f() {
        return this.k;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @NonNull
    public String g() {
        return this.f1718b;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @Nullable
    public CrashlyticsReport.d.e h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1718b.hashCode()) * 1000003;
        long j = this.c;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.d;
        int iHashCode2 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f.hashCode()) * 1000003;
        CrashlyticsReport.d.f fVar = this.g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        CrashlyticsReport.d.e eVar = this.h;
        int iHashCode4 = (iHashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        CrashlyticsReport.d.c cVar = this.i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        ImmutableList3<CrashlyticsReport.d.AbstractC0049d> immutableList3 = this.j;
        return ((iHashCode5 ^ (immutableList3 != null ? immutableList3.hashCode() : 0)) * 1000003) ^ this.k;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    public long i() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    @Nullable
    public CrashlyticsReport.d.f j() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    public boolean k() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.d
    public CrashlyticsReport.d.b l() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Session{generator=");
        sbU.append(this.a);
        sbU.append(", identifier=");
        sbU.append(this.f1718b);
        sbU.append(", startedAt=");
        sbU.append(this.c);
        sbU.append(", endedAt=");
        sbU.append(this.d);
        sbU.append(", crashed=");
        sbU.append(this.e);
        sbU.append(", app=");
        sbU.append(this.f);
        sbU.append(", user=");
        sbU.append(this.g);
        sbU.append(", os=");
        sbU.append(this.h);
        sbU.append(", device=");
        sbU.append(this.i);
        sbU.append(", events=");
        sbU.append(this.j);
        sbU.append(", generatorType=");
        return outline.B(sbU, this.k, "}");
    }
}
