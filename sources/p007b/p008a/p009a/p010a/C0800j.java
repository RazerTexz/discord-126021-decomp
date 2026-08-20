package p007b.p008a.p009a.p010a;

import com.discord.stores.StoreSubscriptions;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.a.a.j */
/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0800j<T, R> implements InterfaceC12589b<StoreSubscriptions.SubscriptionsState, C0801k.b> {

    /* JADX INFO: renamed from: j */
    public static final C0800j f211j = new C0800j();

    @Override // p637j0.p641k.InterfaceC12589b
    public C0801k.b call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
        C12238m.checkNotNullExpressionValue(subscriptionsState2, "it");
        return new C0801k.b(subscriptionsState2);
    }
}
