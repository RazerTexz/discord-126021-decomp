package b.a.a.a;

import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreGuildBoost$State$Failure;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StoreGuildBoost$State$Loading;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Failure;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loading;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends o implements Function1<f$b, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f$b f_b) {
        f$c f_c_c;
        ModelSubscription premiumSubscription;
        ModelAppliedGuildBoost premiumGuildSubscription;
        f$b f_b2 = f_b;
        m.checkNotNullParameter(f_b2, "storeState");
        f fVar = this.this$0;
        Objects.requireNonNull(fVar);
        StoreGuildBoost$State storeGuildBoost$State = f_b2.a;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = f_b2.f41b;
        if (!(fVar.getViewState() instanceof f$c$b) && !(fVar.getViewState() instanceof f$c$c)) {
            if ((storeGuildBoost$State instanceof StoreGuildBoost$State$Loading) || (storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loading)) {
                f_c_c = f$c$f.f;
            } else if ((storeGuildBoost$State instanceof StoreGuildBoost$State$Failure) || (storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Failure) || !(storeGuildBoost$State instanceof StoreGuildBoost$State$Loaded) || !(storeSubscriptions$SubscriptionsState instanceof StoreSubscriptions$SubscriptionsState$Loaded) || (premiumSubscription = ((StoreSubscriptions$SubscriptionsState$Loaded) storeSubscriptions$SubscriptionsState).getPremiumSubscription()) == null) {
                f_c_c = new f$c$c(2131894091);
            } else if (fVar.getViewState() instanceof f$c$b) {
                f_c_c = new f$c$b(premiumSubscription);
            } else {
                ModelGuildBoostSlot modelGuildBoostSlot = ((StoreGuildBoost$State$Loaded) storeGuildBoost$State).getBoostSlotMap().get(Long.valueOf(fVar.k));
                f_c_c = new f$c$e(premiumSubscription, ((modelGuildBoostSlot == null || (premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription()) == null) ? null : Long.valueOf(premiumGuildSubscription.getGuildId())) != null);
            }
            fVar.updateViewState(f_c_c);
        }
        return Unit.a;
    }
}
