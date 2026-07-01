package b.a.a.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k extends d0<k$c> {
    public static final k$a j = new k$a(null);
    public final long k;
    public final StoreSubscriptions l;
    public final StoreGuildBoost m;
    public final RestAPI n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(long j2, StoreSubscriptions storeSubscriptions, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i) {
        Observable observableG;
        super(k$c$c.a);
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.Companion.getSubscriptions() : null;
        StoreGuildBoost guildBoosts = (i & 4) != 0 ? StoreStream.Companion.getGuildBoosts() : null;
        RestAPI api = (i & 8) != 0 ? RestAPI.Companion.getApi() : null;
        if ((i & 16) != 0) {
            observableG = subscriptions.observeSubscriptions().G(j.j);
            m.checkNotNullExpressionValue(observableG, "storeSubscriptions\n     …toreState(it)\n          }");
        } else {
            observableG = null;
        }
        m.checkNotNullParameter(subscriptions, "storeSubscriptions");
        m.checkNotNullParameter(guildBoosts, "storeGuildBoost");
        m.checkNotNullParameter(api, "restAPI");
        m.checkNotNullParameter(observableG, "storeObservable");
        this.k = j2;
        this.l = subscriptions;
        this.m = guildBoosts;
        this.n = api;
        subscriptions.fetchSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), k.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new i(this), 62, (Object) null);
    }
}
