package b.a.a.a;

import b.a.a.a.GuildBoostUncancelViewModel3;
import com.discord.stores.StoreSubscriptions;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* JADX INFO: renamed from: b.a.a.a.j, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostUncancelViewModel2<T, R> implements Func1<StoreSubscriptions.SubscriptionsState, GuildBoostUncancelViewModel3.b> {
    public static final GuildBoostUncancelViewModel2 j = new GuildBoostUncancelViewModel2();

    @Override // j0.k.Func1
    public GuildBoostUncancelViewModel3.b call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        Intrinsics3.checkNotNullExpressionValue(subscriptionsState2, "it");
        return new GuildBoostUncancelViewModel3.b(subscriptionsState2);
    }
}
