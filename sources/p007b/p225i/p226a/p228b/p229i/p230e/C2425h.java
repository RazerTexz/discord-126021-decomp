package p007b.p225i.p226a.p228b.p229i.p230e;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.i.e.h */
/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2425h extends AbstractC2431n {

    /* JADX INFO: renamed from: a */
    public final long f5188a;

    public C2425h(long j) {
        this.f5188a = j;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2431n
    /* JADX INFO: renamed from: b */
    public long mo2330b() {
        return this.f5188a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AbstractC2431n) && this.f5188a == ((AbstractC2431n) obj).mo2330b();
    }

    public int hashCode() {
        long j = this.f5188a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("LogResponse{nextRequestWaitMillis="), this.f5188a, "}");
    }
}
