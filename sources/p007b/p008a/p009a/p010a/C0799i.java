package p007b.p008a.p009a.p010a;

import com.discord.C5419R;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreSubscriptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p010a.C0801k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a.i */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0799i extends AbstractC12240o implements Function1<C0801k.b, Unit> {
    public final /* synthetic */ C0801k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0799i(C0801k c0801k) {
        super(1);
        this.this$0 = c0801k;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(C0801k.b bVar) {
        Object aVar;
        C0801k.b bVar2 = bVar;
        C12238m.checkNotNullParameter(bVar2, "storeState");
        C0801k c0801k = this.this$0;
        if (!(c0801k.getViewState() instanceof C0801k.c.d) && !(c0801k.getViewState() instanceof C0801k.c.a)) {
            StoreSubscriptions.SubscriptionsState subscriptionsState = bVar2.f217a;
            if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loading) {
                aVar = C0801k.c.C13205c.f222a;
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) {
                aVar = new C0801k.c.a(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile));
            } else if (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) {
                ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription();
                aVar = premiumSubscription == null ? new C0801k.c.a(Integer.valueOf(C5419R.string.premium_guild_subscription_cancel_error_mobile)) : new C0801k.c.b(premiumSubscription, false, false);
            } else {
                aVar = new C0801k.c.a(null, 1);
            }
            c0801k.updateViewState(aVar);
        }
        return Unit.f27425a;
    }
}
