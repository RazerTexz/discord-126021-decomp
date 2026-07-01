package b.a.a.a;

import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Failure;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loading;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i extends o implements Function1<k$b, Unit> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(k$b k_b) {
        Object k_c_a;
        k$b k_b2 = k_b;
        m.checkNotNullParameter(k_b2, "storeState");
        k kVar = this.this$0;
        if (!(kVar.getViewState() instanceof k$c$d) && !(kVar.getViewState() instanceof k$c$a)) {
            StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = k_b2.a;
            if (storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loading) {
                k_c_a = k$c$c.a;
            } else if (storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Failure) {
                k_c_a = new k$c$a(2131894091);
            } else if (storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loaded) {
                ModelSubscription premiumSubscription = ((StoreSubscriptions$SubscriptionsState$Loaded) storeSubscriptions$SubscriptionsState).getPremiumSubscription();
                k_c_a = premiumSubscription == null ? new k$c$a(2131894091) : new k$c$b(premiumSubscription, false, false);
            } else {
                k_c_a = new k$c$a(null, 1);
            }
            kVar.updateViewState(k_c_a);
        }
        return Unit.a;
    }
}
