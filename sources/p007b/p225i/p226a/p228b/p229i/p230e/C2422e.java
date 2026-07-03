package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2428k;

/* JADX INFO: renamed from: b.i.a.b.i.e.e */
/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2422e extends AbstractC2428k {

    /* JADX INFO: renamed from: a */
    public final AbstractC2428k.a f5165a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2418a f5166b;

    public C2422e(AbstractC2428k.a aVar, AbstractC2418a abstractC2418a, a aVar2) {
        this.f5165a = aVar;
        this.f5166b = abstractC2418a;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2428k
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC2418a mo2314a() {
        return this.f5166b;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2428k
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC2428k.a mo2315b() {
        return this.f5165a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2428k)) {
            return false;
        }
        AbstractC2428k abstractC2428k = (AbstractC2428k) obj;
        AbstractC2428k.a aVar = this.f5165a;
        if (aVar != null ? aVar.equals(abstractC2428k.mo2315b()) : abstractC2428k.mo2315b() == null) {
            AbstractC2418a abstractC2418a = this.f5166b;
            if (abstractC2418a == null) {
                if (abstractC2428k.mo2314a() == null) {
                    return true;
                }
            } else if (abstractC2418a.equals(abstractC2428k.mo2314a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC2428k.a aVar = this.f5165a;
        int iHashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC2418a abstractC2418a = this.f5166b;
        return iHashCode ^ (abstractC2418a != null ? abstractC2418a.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ClientInfo{clientType=");
        sbM833U.append(this.f5165a);
        sbM833U.append(", androidClientInfo=");
        sbM833U.append(this.f5166b);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
