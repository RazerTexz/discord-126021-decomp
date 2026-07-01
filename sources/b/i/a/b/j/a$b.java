package b.i.a.b.j;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b extends f$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f762b;
    public e c;
    public Long d;
    public Long e;
    public Map<String, String> f;

    @Override // b.i.a.b.j.f$a
    public f b() {
        String strW = this.a == null ? " transportName" : "";
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " encodedPayload");
        }
        if (this.d == null) {
            strW = b.d.b.a.a.w(strW, " eventMillis");
        }
        if (this.e == null) {
            strW = b.d.b.a.a.w(strW, " uptimeMillis");
        }
        if (this.f == null) {
            strW = b.d.b.a.a.w(strW, " autoMetadata");
        }
        if (strW.isEmpty()) {
            return new a(this.a, this.f762b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    @Override // b.i.a.b.j.f$a
    public Map<String, String> c() {
        Map<String, String> map = this.f;
        if (map != null) {
            return map;
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    public f$a d(e eVar) {
        Objects.requireNonNull(eVar, "Null encodedPayload");
        this.c = eVar;
        return this;
    }

    public f$a e(long j) {
        this.d = Long.valueOf(j);
        return this;
    }

    public f$a f(String str) {
        Objects.requireNonNull(str, "Null transportName");
        this.a = str;
        return this;
    }

    public f$a g(long j) {
        this.e = Long.valueOf(j);
        return this;
    }
}
