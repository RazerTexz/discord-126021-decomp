package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2432o;

/* JADX INFO: renamed from: b.i.a.b.i.e.i */
/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2426i extends AbstractC2432o {

    /* JADX INFO: renamed from: a */
    public final AbstractC2432o.b f5189a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2432o.a f5190b;

    public C2426i(AbstractC2432o.b bVar, AbstractC2432o.a aVar, a aVar2) {
        this.f5189a = bVar;
        this.f5190b = aVar;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2432o
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC2432o.a mo2331a() {
        return this.f5190b;
    }

    @Override // p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2432o
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC2432o.b mo2332b() {
        return this.f5189a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2432o)) {
            return false;
        }
        AbstractC2432o abstractC2432o = (AbstractC2432o) obj;
        AbstractC2432o.b bVar = this.f5189a;
        if (bVar != null ? bVar.equals(abstractC2432o.mo2332b()) : abstractC2432o.mo2332b() == null) {
            AbstractC2432o.a aVar = this.f5190b;
            if (aVar == null) {
                if (abstractC2432o.mo2331a() == null) {
                    return true;
                }
            } else if (aVar.equals(abstractC2432o.mo2331a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC2432o.b bVar = this.f5189a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC2432o.a aVar = this.f5190b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("NetworkConnectionInfo{networkType=");
        sbM833U.append(this.f5189a);
        sbM833U.append(", mobileSubtype=");
        sbM833U.append(this.f5190b);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
