package b.a.a.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d0<f$c> {
    public static final f$a j = new f$a(null);
    public final long k;
    public final StoreGuildBoost l;
    public final StoreSubscriptions m;
    public final RestAPI n;

    public f(long j2, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, RestAPI restAPI, Observable observable, int i) {
        Observable observableJ;
        Object hVar;
        StoreGuildBoost guildBoosts = (i & 2) != 0 ? StoreStream.Companion.getGuildBoosts() : null;
        StoreSubscriptions subscriptions = (i & 4) != 0 ? StoreStream.Companion.getSubscriptions() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.Companion.getApi() : null;
        if ((i & 16) != 0) {
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(guildBoosts, null, 1, null);
            Observable<StoreSubscriptions$SubscriptionsState> observableObserveSubscriptions = subscriptions.observeSubscriptions();
            e eVar = e.j;
            if (eVar != null) {
                hVar = eVar;
                hVar = new h(eVar);
            }
            hVar = eVar;
            observableJ = Observable.j(observableObserveGuildBoostState$default, observableObserveSubscriptions, (Func2) hVar);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…   ::StoreState\n        )");
        } else {
            observableJ = null;
        }
        m.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        m.checkNotNullParameter(subscriptions, "storeSubscriptions");
        m.checkNotNullParameter(api, "api");
        m.checkNotNullParameter(observableJ, "storeObservable");
        super(f$c$f.f);
        this.k = j2;
        this.l = guildBoosts;
        this.m = subscriptions;
        this.n = api;
        guildBoosts.fetchUserGuildBoostState();
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(this), 62, (Object) null);
    }
}
