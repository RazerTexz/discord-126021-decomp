package b.a.a.a;

import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$c$a extends f$c {
    public final ModelSubscription f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c$a(ModelSubscription modelSubscription) {
        super(false, true, false, true, false, null);
        m.checkNotNullParameter(modelSubscription, Traits$Payment$Type.SUBSCRIPTION);
        this.f = modelSubscription;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof f$c$a) && m.areEqual(this.f, ((f$c$a) obj).f);
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
        StringBuilder sbU = b.d.b.a.a.U("CancelInProgress(subscription=");
        sbU.append(this.f);
        sbU.append(")");
        return sbU.toString();
    }
}
