package b.a.a.d;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.d0;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d0<f$d> {
    public static final f$a j = new f$a(null);
    public final PublishSubject<f$b> k;
    public final long l;
    public final RestAPI m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j2, long j3, RestAPI restAPI, Observable observable, int i) {
        Observable observableR;
        super(f$d$b.a);
        RestAPI api = (i & 4) != 0 ? RestAPI.Companion.getApi() : null;
        if ((i & 8) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            StoreUser users = storeStream$Companion.getUsers();
            StoreUserRelationships userRelationships = storeStream$Companion.getUserRelationships();
            StoreGuilds guilds = storeStream$Companion.getGuilds();
            StoreChannels channels = storeStream$Companion.getChannels();
            Observable<User> observableObserveUser = users.observeUser(j2);
            Observable<Integer> observableObserve = userRelationships.observe(j2);
            Observable observableR2 = channels.observeChannel(j3).Y(new d(guilds, j2)).r();
            m.checkNotNullExpressionValue(observableR2, "storeChannels\n          …  .distinctUntilChanged()");
            observableR = Observable.i(observableObserveUser, observableObserve, observableR2, e.a).r();
            m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        } else {
            observableR = null;
        }
        m.checkNotNullParameter(api, "restAPI");
        m.checkNotNullParameter(observableR, "storeObservable");
        this.l = j2;
        this.m = api;
        this.k = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(this), 62, (Object) null);
    }

    public final void removeRelationship(@StringRes int i) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.m.removeRelationship("User Profile", this.l), false, 1, null), this, null, 2, null), f.class, (Context) null, (Function1) null, new f$f(this), (Function0) null, (Function0) null, new f$e(this, i), 54, (Object) null);
    }
}
