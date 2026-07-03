package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.a */
/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2491a extends AbstractC2495d {

    /* JADX INFO: renamed from: b */
    public final long f5409b;

    /* JADX INFO: renamed from: c */
    public final int f5410c;

    /* JADX INFO: renamed from: d */
    public final int f5411d;

    /* JADX INFO: renamed from: e */
    public final long f5412e;

    /* JADX INFO: renamed from: f */
    public final int f5413f;

    public C2491a(long j, int i, int i2, long j2, int i3, a aVar) {
        this.f5409b = j;
        this.f5410c = i;
        this.f5411d = i2;
        this.f5412e = j2;
        this.f5413f = i3;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2495d
    /* JADX INFO: renamed from: a */
    public int mo2386a() {
        return this.f5411d;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2495d
    /* JADX INFO: renamed from: b */
    public long mo2387b() {
        return this.f5412e;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2495d
    /* JADX INFO: renamed from: c */
    public int mo2388c() {
        return this.f5410c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2495d
    /* JADX INFO: renamed from: d */
    public int mo2389d() {
        return this.f5413f;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2495d
    /* JADX INFO: renamed from: e */
    public long mo2390e() {
        return this.f5409b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2495d)) {
            return false;
        }
        AbstractC2495d abstractC2495d = (AbstractC2495d) obj;
        return this.f5409b == abstractC2495d.mo2390e() && this.f5410c == abstractC2495d.mo2388c() && this.f5411d == abstractC2495d.mo2386a() && this.f5412e == abstractC2495d.mo2387b() && this.f5413f == abstractC2495d.mo2389d();
    }

    public int hashCode() {
        long j = this.f5409b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f5410c) * 1000003) ^ this.f5411d) * 1000003;
        long j2 = this.f5412e;
        return this.f5413f ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EventStoreConfig{maxStorageSizeInBytes=");
        sbM833U.append(this.f5409b);
        sbM833U.append(", loadBatchSize=");
        sbM833U.append(this.f5410c);
        sbM833U.append(", criticalSectionEnterTimeoutMs=");
        sbM833U.append(this.f5411d);
        sbM833U.append(", eventCleanUpAge=");
        sbM833U.append(this.f5412e);
        sbM833U.append(", maxBlobByteSizePerRow=");
        return C1643a.m814B(sbM833U, this.f5413f, "}");
    }
}
