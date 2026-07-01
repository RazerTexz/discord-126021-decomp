package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$Model$Companion {
    private WidgetServerDeleteDialog$Model$Companion() {
    }

    public final Observable<WidgetServerDeleteDialog$Model> get$app_productionGoogleRelease(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Guild> observableObserveGuild = storeStream$Companion.getGuilds().observeGuild(guildId);
        WidgetServerDeleteDialog$Model$Companion$get$1 widgetServerDeleteDialog$Model$Companion$get$1 = WidgetServerDeleteDialog$Model$Companion$get$1.INSTANCE;
        Object widgetServerDeleteDialog$sam$rx_functions_Func2$0 = widgetServerDeleteDialog$Model$Companion$get$1;
        if (widgetServerDeleteDialog$Model$Companion$get$1 != null) {
            widgetServerDeleteDialog$sam$rx_functions_Func2$0 = new WidgetServerDeleteDialog$sam$rx_functions_Func2$0(widgetServerDeleteDialog$Model$Companion$get$1);
        }
        Observable observableJ = Observable.j(observableObserveMe$default, observableObserveGuild, (Func2) widgetServerDeleteDialog$sam$rx_functions_Func2$0);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      ::Model\n          )");
        return ObservableExtensionsKt.computationLatest(observableJ).r();
    }

    public /* synthetic */ WidgetServerDeleteDialog$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
