package p007b.p008a.p009a.p010a;

import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.a.e */
/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0795e extends C12236k implements Function2<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, C0796f.b> {

    /* JADX INFO: renamed from: j */
    public static final C0795e f190j = new C0795e();

    public C0795e() {
        super(2, C0796f.b.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public C0796f.b invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreGuildBoost.State state2 = state;
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        C12238m.checkNotNullParameter(state2, "p1");
        C12238m.checkNotNullParameter(subscriptionsState2, "p2");
        return new C0796f.b(state2, subscriptionsState2);
    }
}
