package b.a.a.a;

import b.a.a.a.GuildBoostCancelViewModel3;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GuildBoostCancelViewModel2 extends FunctionReferenceImpl implements Function2<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, GuildBoostCancelViewModel3.b> {
    public static final GuildBoostCancelViewModel2 j = new GuildBoostCancelViewModel2();

    public GuildBoostCancelViewModel2() {
        super(2, GuildBoostCancelViewModel3.b.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public GuildBoostCancelViewModel3.b invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreGuildBoost.State state2 = state;
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        Intrinsics3.checkNotNullParameter(state2, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState2, "p2");
        return new GuildBoostCancelViewModel3.b(state2, subscriptionsState2);
    }
}
