package b.i.a.b.j;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.b.j.EventInternal;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_EventInternal extends EventInternal {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f761b;
    public final EncodedPayload c;
    public final long d;
    public final long e;
    public final Map<String, String> f;

    /* JADX INFO: renamed from: b.i.a.b.j.a$b */
    /* JADX INFO: compiled from: AutoValue_EventInternal.java */
    public static final class b extends EventInternal.a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f762b;
        public EncodedPayload c;
        public Long d;
        public Long e;
        public Map<String, String> f;

        @Override // b.i.a.b.j.EventInternal.a
        public EventInternal b() {
            String strW = this.a == null ? " transportName" : "";
            if (this.c == null) {
                strW = outline.w(strW, " encodedPayload");
            }
            if (this.d == null) {
                strW = outline.w(strW, " eventMillis");
            }
            if (this.e == null) {
                strW = outline.w(strW, " uptimeMillis");
            }
            if (this.f == null) {
                strW = outline.w(strW, " autoMetadata");
            }
            if (strW.isEmpty()) {
                return new AutoValue_EventInternal(this.a, this.f762b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        @Override // b.i.a.b.j.EventInternal.a
        public Map<String, String> c() {
            Map<String, String> map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public EventInternal.a d(EncodedPayload encodedPayload) {
            Objects.requireNonNull(encodedPayload, "Null encodedPayload");
            this.c = encodedPayload;
            return this;
        }

        public EventInternal.a e(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        public EventInternal.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        public EventInternal.a g(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, Map map, a aVar) {
        this.a = str;
        this.f761b = num;
        this.c = encodedPayload;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    @Override // b.i.a.b.j.EventInternal
    public Map<String, String> b() {
        return this.f;
    }

    @Override // b.i.a.b.j.EventInternal
    @Nullable
    public Integer c() {
        return this.f761b;
    }

    @Override // b.i.a.b.j.EventInternal
    public EncodedPayload d() {
        return this.c;
    }

    @Override // b.i.a.b.j.EventInternal
    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        return this.a.equals(eventInternal.g()) && ((num = this.f761b) != null ? num.equals(eventInternal.c()) : eventInternal.c() == null) && this.c.equals(eventInternal.d()) && this.d == eventInternal.e() && this.e == eventInternal.h() && this.f.equals(eventInternal.b());
    }

    @Override // b.i.a.b.j.EventInternal
    public String g() {
        return this.a;
    }

    @Override // b.i.a.b.j.EventInternal
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
        StringBuilder sbU = outline.U("EventInternal{transportName=");
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
        return outline.M(sbU, this.f, "}");
    }
}
