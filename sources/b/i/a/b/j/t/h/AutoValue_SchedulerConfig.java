package b.i.a.b.j.t.h;

import b.d.b.a.outline;
import b.i.a.b.Priority3;
import b.i.a.b.j.t.h.SchedulerConfig;
import b.i.a.b.j.v.Clock3;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_SchedulerConfig extends SchedulerConfig {
    public final Clock3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Priority3, SchedulerConfig.a> f784b;

    public AutoValue_SchedulerConfig(Clock3 clock3, Map<Priority3, SchedulerConfig.a> map) {
        Objects.requireNonNull(clock3, "Null clock");
        this.a = clock3;
        Objects.requireNonNull(map, "Null values");
        this.f784b = map;
    }

    @Override // b.i.a.b.j.t.h.SchedulerConfig
    public Clock3 a() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.h.SchedulerConfig
    public Map<Priority3, SchedulerConfig.a> c() {
        return this.f784b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.a.equals(schedulerConfig.a()) && this.f784b.equals(schedulerConfig.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f784b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("SchedulerConfig{clock=");
        sbU.append(this.a);
        sbU.append(", values=");
        return outline.M(sbU, this.f784b, "}");
    }
}
