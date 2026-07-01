package b.a.a.a;

import com.discord.models.domain.ModelSubscription;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$c$d extends f$c {
    public final ModelSubscription f;

    public f$c$d(ModelSubscription modelSubscription) {
        super(true, true, true, false, true, null);
        this.f = modelSubscription;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof f$c$d) && m.areEqual(this.f, ((f$c$d) obj).f);
        }
        return true;
    }

    public int hashCode() {
        ModelSubscription modelSubscription = this.f;
        if (modelSubscription != null) {
            return modelSubscription.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("FailureCancelling(subscription=");
        sbU.append(this.f);
        sbU.append(")");
        return sbU.toString();
    }
}
