package com.discord.stores;

import android.content.Context;
import com.discord.app.AppComponent;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions {
    public static final StoreGuilds$Actions INSTANCE = new StoreGuilds$Actions();

    private StoreGuilds$Actions() {
    }

    public static final void requestMembers(AppComponent fragment, Observable<String> partialUserNameTokenEmitted, boolean autocomplete) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(partialUserNameTokenEmitted, "partialUserNameTokenEmitted");
        Observable observableY = partialUserNameTokenEmitted.p(1000L, TimeUnit.MILLISECONDS).G(new StoreGuilds$Actions$requestMembers$1(autocomplete)).y(StoreGuilds$Actions$requestMembers$2.INSTANCE).r().Y(StoreGuilds$Actions$requestMembers$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "partialUserNameTokenEmit…            }\n          }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), fragment, null, 2, null), (Context) null, "requestGuildMembers", (Function1) null, StoreGuilds$Actions$requestMembers$4.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    public static final void requestRoleMembers(long guildId, long roleId, AppComponent appComponent, RestAPI restApi, StoreGatewayConnection storeGatewayConnection) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(restApi, "restApi");
        m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(restApi.getGuildRoleMemberIds(guildId, roleId)), appComponent, null, 2, null), INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuilds$Actions$requestRoleMembers$1(storeGatewayConnection, guildId), 62, (Object) null);
    }
}
