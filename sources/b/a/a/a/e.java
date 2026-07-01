package b.a.a.a;

import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e extends d0.z.d.k implements Function2<StoreGuildBoost$State, StoreSubscriptions$SubscriptionsState, f$b> {
    public static final e j = new e();

    public e() {
        super(2, f$b.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public f$b invoke(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        StoreGuildBoost$State storeGuildBoost$State2 = storeGuildBoost$State;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState2 = storeSubscriptions$SubscriptionsState;
        m.checkNotNullParameter(storeGuildBoost$State2, "p1");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState2, "p2");
        return new f$b(storeGuildBoost$State2, storeSubscriptions$SubscriptionsState2);
    }
}
