package b.i.a.b.j.t.h;

import java.util.Set;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b extends f$a$a {
    public Long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f786b;
    public Set<f$b> c;

    @Override // b.i.a.b.j.t.h.f$a$a
    public f$a a() {
        String strW = this.a == null ? " delta" : "";
        if (this.f786b == null) {
            strW = b.d.b.a.a.w(strW, " maxAllowedDelay");
        }
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " flags");
        }
        if (strW.isEmpty()) {
            return new c(this.a.longValue(), this.f786b.longValue(), this.c, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    @Override // b.i.a.b.j.t.h.f$a$a
    public f$a$a b(long j) {
        this.a = Long.valueOf(j);
        return this;
    }

    @Override // b.i.a.b.j.t.h.f$a$a
    public f$a$a c(long j) {
        this.f786b = Long.valueOf(j);
        return this;
    }
}
