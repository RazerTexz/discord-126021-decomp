package b.i.a.b.j;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f761b;
    public final e c;
    public final long d;
    public final long e;
    public final Map<String, String> f;

    public a(String str, Integer num, e eVar, long j, long j2, Map map, a$a a_a) {
        this.a = str;
        this.f761b = num;
        this.c = eVar;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    @Override // b.i.a.b.j.f
    public Map<String, String> b() {
        return this.f;
    }

    @Override // b.i.a.b.j.f
    @Nullable
    public Integer c() {
        return this.f761b;
    }

    @Override // b.i.a.b.j.f
    public e d() {
        return this.c;
    }

    @Override // b.i.a.b.j.f
    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.g()) && ((num = this.f761b) != null ? num.equals(fVar.c()) : fVar.c() == null) && this.c.equals(fVar.d()) && this.d == fVar.e() && this.e == fVar.h() && this.f.equals(fVar.b());
    }

    @Override // b.i.a.b.j.f
    public String g() {
        return this.a;
    }

    @Override // b.i.a.b.j.f
    public long h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f761b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EventInternal{transportName=");
        sbU.append(this.a);
        sbU.append(", code=");
        sbU.append(this.f761b);
        sbU.append(", encodedPayload=");
        sbU.append(this.c);
        sbU.append(", eventMillis=");
        sbU.append(this.d);
        sbU.append(", uptimeMillis=");
        sbU.append(this.e);
        sbU.append(", autoMetadata=");
        return b.d.b.a.a.M(sbU, this.f, "}");
    }
}
