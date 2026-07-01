package b.i.a.b.i.e;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends j {
    public final List<m> a;

    public d(List<m> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Override // b.i.a.b.i.e.j
    @NonNull
    public List<m> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.a.equals(((j) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return b.d.b.a.a.L(b.d.b.a.a.U("BatchedLogRequest{logRequests="), this.a, "}");
    }
}
