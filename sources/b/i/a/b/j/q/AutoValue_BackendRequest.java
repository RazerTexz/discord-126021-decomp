package b.i.a.b.j.q;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.b.j.EventInternal;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.b.j.q.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BackendRequest extends BackendRequest {
    public final Iterable<EventInternal> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f771b;

    public AutoValue_BackendRequest(Iterable iterable, byte[] bArr, a aVar) {
        this.a = iterable;
        this.f771b = bArr;
    }

    @Override // b.i.a.b.j.q.BackendRequest
    public Iterable<EventInternal> a() {
        return this.a;
    }

    @Override // b.i.a.b.j.q.BackendRequest
    @Nullable
    public byte[] b() {
        return this.f771b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.a.equals(backendRequest.a())) {
            if (Arrays.equals(this.f771b, backendRequest instanceof AutoValue_BackendRequest ? ((AutoValue_BackendRequest) backendRequest).f771b : backendRequest.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f771b);
    }

    public String toString() {
        StringBuilder sbU = outline.U("BackendRequest{events=");
        sbU.append(this.a);
        sbU.append(", extras=");
        sbU.append(Arrays.toString(this.f771b));
        sbU.append("}");
        return sbU.toString();
    }
}
