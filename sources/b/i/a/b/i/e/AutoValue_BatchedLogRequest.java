package b.i.a.b.i.e;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.i.e.d, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    public final List<LogRequest> a;

    public AutoValue_BatchedLogRequest(List<LogRequest> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Override // b.i.a.b.i.e.BatchedLogRequest
    @NonNull
    public List<LogRequest> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.a.equals(((BatchedLogRequest) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return outline.L(outline.U("BatchedLogRequest{logRequests="), this.a, "}");
    }
}
