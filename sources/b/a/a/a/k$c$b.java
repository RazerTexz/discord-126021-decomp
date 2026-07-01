package b.a.a.a;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c$b extends k$c {
    public final ModelSubscription a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f43b;
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c$b(ModelSubscription modelSubscription, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(modelSubscription, Traits$Payment$Type.SUBSCRIPTION);
        this.a = modelSubscription;
        this.f43b = z2;
        this.c = z3;
    }

    public static k$c$b a(k$c$b k_c_b, ModelSubscription modelSubscription, boolean z2, boolean z3, int i) {
        ModelSubscription modelSubscription2 = (i & 1) != 0 ? k_c_b.a : null;
        if ((i & 2) != 0) {
            z2 = k_c_b.f43b;
        }
        if ((i & 4) != 0) {
            z3 = k_c_b.c;
        }
        Objects.requireNonNull(k_c_b);
        m.checkNotNullParameter(modelSubscription2, Traits$Payment$Type.SUBSCRIPTION);
        return new k$c$b(modelSubscription2, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k$c$b)) {
            return false;
        }
        k$c$b k_c_b = (k$c$b) obj;
        return m.areEqual(this.a, k_c_b.a) && this.f43b == k_c_b.f43b && this.c == k_c_b.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        ModelSubscription modelSubscription = this.a;
        int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
        boolean z2 = this.f43b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.c;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Loaded(subscription=");
        sbU.append(this.a);
        sbU.append(", uncancelInProgress=");
        sbU.append(this.f43b);
        sbU.append(", error=");
        return b.d.b.a.a.O(sbU, this.c, ")");
    }
}
