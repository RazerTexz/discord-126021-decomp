package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.c */
/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2475c extends AbstractC2478f.a {

    /* JADX INFO: renamed from: a */
    public final long f5355a;

    /* JADX INFO: renamed from: b */
    public final long f5356b;

    /* JADX INFO: renamed from: c */
    public final Set<AbstractC2478f.b> f5357c;

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.c$b */
    /* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    public static final class b extends AbstractC2478f.a.AbstractC13221a {

        /* JADX INFO: renamed from: a */
        public Long f5358a;

        /* JADX INFO: renamed from: b */
        public Long f5359b;

        /* JADX INFO: renamed from: c */
        public Set<AbstractC2478f.b> f5360c;

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a.AbstractC13221a
        /* JADX INFO: renamed from: a */
        public AbstractC2478f.a mo2379a() {
            String strM883w = this.f5358a == null ? " delta" : "";
            if (this.f5359b == null) {
                strM883w = C1643a.m883w(strM883w, " maxAllowedDelay");
            }
            if (this.f5360c == null) {
                strM883w = C1643a.m883w(strM883w, " flags");
            }
            if (strM883w.isEmpty()) {
                return new C2475c(this.f5358a.longValue(), this.f5359b.longValue(), this.f5360c, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a.AbstractC13221a
        /* JADX INFO: renamed from: b */
        public AbstractC2478f.a.AbstractC13221a mo2380b(long j) {
            this.f5358a = Long.valueOf(j);
            return this;
        }

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a.AbstractC13221a
        /* JADX INFO: renamed from: c */
        public AbstractC2478f.a.AbstractC13221a mo2381c(long j) {
            this.f5359b = Long.valueOf(j);
            return this;
        }
    }

    public C2475c(long j, long j2, Set set, a aVar) {
        this.f5355a = j;
        this.f5356b = j2;
        this.f5357c = set;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a
    /* JADX INFO: renamed from: b */
    public long mo2376b() {
        return this.f5355a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a
    /* JADX INFO: renamed from: c */
    public Set<AbstractC2478f.b> mo2377c() {
        return this.f5357c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f.a
    /* JADX INFO: renamed from: d */
    public long mo2378d() {
        return this.f5356b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2478f.a)) {
            return false;
        }
        AbstractC2478f.a aVar = (AbstractC2478f.a) obj;
        return this.f5355a == aVar.mo2376b() && this.f5356b == aVar.mo2378d() && this.f5357c.equals(aVar.mo2377c());
    }

    public int hashCode() {
        long j = this.f5355a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f5356b;
        return this.f5357c.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ConfigValue{delta=");
        sbM833U.append(this.f5355a);
        sbM833U.append(", maxAllowedDelay=");
        sbM833U.append(this.f5356b);
        sbM833U.append(", flags=");
        return C1643a.m826N(sbM833U, this.f5357c, "}");
    }
}
