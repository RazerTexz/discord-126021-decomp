package b.i.a.b.j;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.d.b.a.outline;
import b.i.a.b.Priority3;
import b.i.a.b.j.TransportContext;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_TransportContext extends TransportContext {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f763b;
    public final Priority3 c;

    /* JADX INFO: renamed from: b.i.a.b.j.b$b */
    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    public static final class b extends TransportContext.a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f764b;
        public Priority3 c;

        @Override // b.i.a.b.j.TransportContext.a
        public TransportContext a() {
            String strW = this.a == null ? " backendName" : "";
            if (this.c == null) {
                strW = outline.w(strW, " priority");
            }
            if (strW.isEmpty()) {
                return new AutoValue_TransportContext(this.a, this.f764b, this.c, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }

        @Override // b.i.a.b.j.TransportContext.a
        public TransportContext.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // b.i.a.b.j.TransportContext.a
        public TransportContext.a c(Priority3 priority3) {
            Objects.requireNonNull(priority3, "Null priority");
            this.c = priority3;
            return this;
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority3 priority3, a aVar) {
        this.a = str;
        this.f763b = bArr;
        this.c = priority3;
    }

    @Override // b.i.a.b.j.TransportContext
    public String b() {
        return this.a;
    }

    @Override // b.i.a.b.j.TransportContext
    @Nullable
    public byte[] c() {
        return this.f763b;
    }

    @Override // b.i.a.b.j.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority3 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.a.equals(transportContext.b())) {
            if (Arrays.equals(this.f763b, transportContext instanceof AutoValue_TransportContext ? ((AutoValue_TransportContext) transportContext).f763b : transportContext.c()) && this.c.equals(transportContext.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f763b)) * 1000003) ^ this.c.hashCode();
    }
}
