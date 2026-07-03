package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.i.e.d */
/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2421d extends AbstractC2427j {

    /* JADX INFO: renamed from: a */
    public final List<AbstractC2430m> f5164a;

    public C2421d(List<AbstractC2430m> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f5164a = list;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2427j
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<AbstractC2430m> mo2313a() {
        return this.f5164a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2427j) {
            return this.f5164a.equals(((AbstractC2427j) obj).mo2313a());
        }
        return false;
    }

    public int hashCode() {
        return this.f5164a.hashCode() ^ 1000003;
    }

    public String toString() {
        return C1643a.m824L(C1643a.m833U("BatchedLogRequest{logRequests="), this.f5164a, "}");
    }
}
