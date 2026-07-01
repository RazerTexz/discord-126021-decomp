package b.a.a.a;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$c$e extends f$c {
    public final ModelSubscription f;
    public final boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c$e(ModelSubscription modelSubscription, boolean z2) {
        super(false, true, true, false, true, null);
        m.checkNotNullParameter(modelSubscription, Traits$Payment$Type.SUBSCRIPTION);
        this.f = modelSubscription;
        this.g = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f$c$e)) {
            return false;
        }
        f$c$e f_c_e = (f$c$e) obj;
        return m.areEqual(this.f, f_c_e.f) && this.g == f_c_e.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ModelSubscription modelSubscription = this.f;
        int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
        boolean z2 = this.g;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Loaded(subscription=");
        sbU.append(this.f);
        sbU.append(", isFromInventory=");
        return b.d.b.a.a.O(sbU, this.g, ")");
    }
}
