package b.a.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x extends d0<x$d> {
    public static final x$a j = new x$a(null);
    public final PublishSubject<x$b> k;
    public final RestAPI l;

    public x() {
        this(null, null, null, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableG;
        super(null, 1, null);
        RestAPI api = (i & 1) != 0 ? RestAPI.Companion.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.Companion.getUsers() : null;
        if ((i & 4) != 0) {
            observableG = StoreUser.observeMe$default(users, false, 1, null).G(w.j);
            d0.z.d.m.checkNotNullExpressionValue(observableG, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableG = null;
        }
        d0.z.d.m.checkNotNullParameter(api, "restAPI");
        d0.z.d.m.checkNotNullParameter(users, "storeUser");
        d0.z.d.m.checkNotNullParameter(observableG, "storeObservable");
        this.l = api;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), x.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new v(this), 62, (Object) null);
        this.k = PublishSubject.k0();
    }
}
