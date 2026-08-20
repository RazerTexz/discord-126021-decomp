package p007b.p008a.p009a.p010a;

import com.discord.C5419R;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a.d */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0794d extends AbstractC12240o implements Function1<C0796f.b, Unit> {
    public final /* synthetic */ C0796f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0794d(C0796f c0796f) {
        super(1);
        this.this$0 = c0796f;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(C0796f.b bVar) {
        C0796f.c c13204c;
        ModelSubscription premiumSubscription;
        ModelAppliedGuildBoost premiumGuildSubscription;
        C0796f.b bVar2 = bVar;
        C12238m.checkNotNullParameter(bVar2, "storeState");
        C0796f c0796f = this.this$0;
        Objects.requireNonNull(c0796f);
        StoreGuildBoost.State state = bVar2.f196a;
        StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.f197b;
        if (!(c0796f.getViewState() instanceof C0796f.c.b) && !(c0796f.getViewState() instanceof C0796f.c.C13204c)) {
            if ((state instanceof StoreGuildBoost.State.Loading) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading)) {
                c13204c = C0796f.c.f.f209f;
            } else if ((state instanceof StoreGuildBoost.State.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(state instanceof StoreGuildBoost.State.Loaded) || !(subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) || (premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription()) == null) {
                c13204c = new C0796f.c.C13204c(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (c0796f.getViewState() instanceof C0796f.c.b) {
                c13204c = new C0796f.c.b(premiumSubscription);
            } else {
                ModelGuildBoostSlot modelGuildBoostSlot = ((StoreGuildBoost.State.Loaded) state).getBoostSlotMap().get(Long.valueOf(c0796f.f192k));
                c13204c = new C0796f.c.e(premiumSubscription, ((modelGuildBoostSlot == null || (premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription()) == null) ? null : Long.valueOf(premiumGuildSubscription.getGuildId())) != null);
            }
            c0796f.updateViewState(c13204c);
        }
        return Unit.f27425a;
    }
}
