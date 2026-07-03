package p007b.p225i.p226a.p228b.p231j.p232q;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;

/* JADX INFO: renamed from: b.i.a.b.j.q.a */
/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2450a extends AbstractC2455f {

    /* JADX INFO: renamed from: a */
    public final Iterable<AbstractC2439f> f5300a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5301b;

    public C2450a(Iterable iterable, byte[] bArr, a aVar) {
        this.f5300a = iterable;
        this.f5301b = bArr;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2455f
    /* JADX INFO: renamed from: a */
    public Iterable<AbstractC2439f> mo2362a() {
        return this.f5300a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2455f
    @Nullable
    /* JADX INFO: renamed from: b */
    public byte[] mo2363b() {
        return this.f5301b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2455f)) {
            return false;
        }
        AbstractC2455f abstractC2455f = (AbstractC2455f) obj;
        if (this.f5300a.equals(abstractC2455f.mo2362a())) {
            if (Arrays.equals(this.f5301b, abstractC2455f instanceof C2450a ? ((C2450a) abstractC2455f).f5301b : abstractC2455f.mo2363b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5300a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5301b);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BackendRequest{events=");
        sbM833U.append(this.f5300a);
        sbM833U.append(", extras=");
        sbM833U.append(Arrays.toString(this.f5301b));
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
