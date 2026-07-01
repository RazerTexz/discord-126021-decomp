package b.i.a.b.j.q;

import b.d.b.a.outline;
import b.i.a.b.j.q.BackendResponse;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.q.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BackendResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BackendResponse extends BackendResponse {
    public final BackendResponse.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f772b;

    public AutoValue_BackendResponse(BackendResponse.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.a = aVar;
        this.f772b = j;
    }

    @Override // b.i.a.b.j.q.BackendResponse
    public long b() {
        return this.f772b;
    }

    @Override // b.i.a.b.j.q.BackendResponse
    public BackendResponse.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.a.equals(backendResponse.c()) && this.f772b == backendResponse.b();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.f772b;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("BackendResponse{status=");
        sbU.append(this.a);
        sbU.append(", nextRequestWaitMillis=");
        return outline.C(sbU, this.f772b, "}");
    }
}
