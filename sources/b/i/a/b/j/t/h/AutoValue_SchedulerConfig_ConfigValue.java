package b.i.a.b.j.t.h;

import b.d.b.a.outline;
import b.i.a.b.j.t.h.SchedulerConfig;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f785b;
    public final Set<SchedulerConfig.b> c;

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.c$b */
    /* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    public static final class b extends SchedulerConfig.a.AbstractC0026a {
        public Long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f786b;
        public Set<SchedulerConfig.b> c;

        @Override // b.i.a.b.j.t.h.SchedulerConfig.a.AbstractC0026a
        public SchedulerConfig.a a() {
            String strW = this.a == null ? " delta" : "";
            if (this.f786b == null) {
                strW = outline.w(strW, " maxAllowedDelay");
            }
            if (this.c == null) {
                strW = outline.w(strW, " flags");
            }
            if (strW.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.a.longValue(), this.f786b.longValue(), this.c, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        @Override // b.i.a.b.j.t.h.SchedulerConfig.a.AbstractC0026a
        public SchedulerConfig.a.AbstractC0026a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // b.i.a.b.j.t.h.SchedulerConfig.a.AbstractC0026a
        public SchedulerConfig.a.AbstractC0026a c(long j) {
            this.f786b = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set, a aVar) {
        this.a = j;
        this.f785b = j2;
        this.c = set;
    }

    @Override // b.i.a.b.j.t.h.SchedulerConfig.a
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.h.SchedulerConfig.a
    public Set<SchedulerConfig.b> c() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.h.SchedulerConfig.a
    public long d() {
        return this.f785b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.a)) {
            return false;
        }
        SchedulerConfig.a aVar = (SchedulerConfig.a) obj;
        return this.a == aVar.b() && this.f785b == aVar.d() && this.c.equals(aVar.c());
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f785b;
        return this.c.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConfigValue{delta=");
        sbU.append(this.a);
        sbU.append(", maxAllowedDelay=");
        sbU.append(this.f785b);
        sbU.append(", flags=");
        return outline.N(sbU, this.c, "}");
    }
}
