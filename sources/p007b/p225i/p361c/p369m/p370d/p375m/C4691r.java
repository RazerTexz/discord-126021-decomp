package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.r */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4691r extends AbstractC4695v.d.AbstractC13233d.b {

    /* JADX INFO: renamed from: a */
    public final Double f12629a;

    /* JADX INFO: renamed from: b */
    public final int f12630b;

    /* JADX INFO: renamed from: c */
    public final boolean f12631c;

    /* JADX INFO: renamed from: d */
    public final int f12632d;

    /* JADX INFO: renamed from: e */
    public final long f12633e;

    /* JADX INFO: renamed from: f */
    public final long f12634f;

    /* JADX INFO: renamed from: b.i.c.m.d.m.r$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
    public static final class b extends AbstractC4695v.d.AbstractC13233d.b.a {

        /* JADX INFO: renamed from: a */
        public Double f12635a;

        /* JADX INFO: renamed from: b */
        public Integer f12636b;

        /* JADX INFO: renamed from: c */
        public Boolean f12637c;

        /* JADX INFO: renamed from: d */
        public Integer f12638d;

        /* JADX INFO: renamed from: e */
        public Long f12639e;

        /* JADX INFO: renamed from: f */
        public Long f12640f;

        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d.AbstractC13233d.b m6605a() {
            String strM883w = this.f12636b == null ? " batteryVelocity" : "";
            if (this.f12637c == null) {
                strM883w = C1643a.m883w(strM883w, " proximityOn");
            }
            if (this.f12638d == null) {
                strM883w = C1643a.m883w(strM883w, " orientation");
            }
            if (this.f12639e == null) {
                strM883w = C1643a.m883w(strM883w, " ramUsed");
            }
            if (this.f12640f == null) {
                strM883w = C1643a.m883w(strM883w, " diskUsed");
            }
            if (strM883w.isEmpty()) {
                return new C4691r(this.f12635a, this.f12636b.intValue(), this.f12637c.booleanValue(), this.f12638d.intValue(), this.f12639e.longValue(), this.f12640f.longValue(), null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
    }

    public C4691r(Double d, int i, boolean z2, int i2, long j, long j2, a aVar) {
        this.f12629a = d;
        this.f12630b = i;
        this.f12631c = z2;
        this.f12632d = i2;
        this.f12633e = j;
        this.f12634f = j2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    @Nullable
    /* JADX INFO: renamed from: a */
    public Double mo6599a() {
        return this.f12629a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    /* JADX INFO: renamed from: b */
    public int mo6600b() {
        return this.f12630b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    /* JADX INFO: renamed from: c */
    public long mo6601c() {
        return this.f12634f;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    /* JADX INFO: renamed from: d */
    public int mo6602d() {
        return this.f12632d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    /* JADX INFO: renamed from: e */
    public long mo6603e() {
        return this.f12633e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.b)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.b bVar = (AbstractC4695v.d.AbstractC13233d.b) obj;
        Double d = this.f12629a;
        if (d != null ? d.equals(bVar.mo6599a()) : bVar.mo6599a() == null) {
            if (this.f12630b == bVar.mo6600b() && this.f12631c == bVar.mo6604f() && this.f12632d == bVar.mo6602d() && this.f12633e == bVar.mo6603e() && this.f12634f == bVar.mo6601c()) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.b
    /* JADX INFO: renamed from: f */
    public boolean mo6604f() {
        return this.f12631c;
    }

    public int hashCode() {
        Double d = this.f12629a;
        int iHashCode = ((((((((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003) ^ this.f12630b) * 1000003) ^ (this.f12631c ? 1231 : 1237)) * 1000003) ^ this.f12632d) * 1000003;
        long j = this.f12633e;
        long j2 = this.f12634f;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Device{batteryLevel=");
        sbM833U.append(this.f12629a);
        sbM833U.append(", batteryVelocity=");
        sbM833U.append(this.f12630b);
        sbM833U.append(", proximityOn=");
        sbM833U.append(this.f12631c);
        sbM833U.append(", orientation=");
        sbM833U.append(this.f12632d);
        sbM833U.append(", ramUsed=");
        sbM833U.append(this.f12633e);
        sbM833U.append(", diskUsed=");
        return C1643a.m815C(sbM833U, this.f12634f, "}");
    }
}
