package b.i.a.b.j.t.h;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {
    public final b.i.a.b.j.v.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<b.i.a.b.d, f$a> f784b;

    public b(b.i.a.b.j.v.a aVar, Map<b.i.a.b.d, f$a> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f784b = map;
    }

    @Override // b.i.a.b.j.t.h.f
    public b.i.a.b.j.v.a a() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.h.f
    public Map<b.i.a.b.d, f$a> c() {
        return this.f784b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.a()) && this.f784b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f784b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("SchedulerConfig{clock=");
        sbU.append(this.a);
        sbU.append(", values=");
        return b.d.b.a.a.M(sbU, this.f784b, "}");
    }
}
