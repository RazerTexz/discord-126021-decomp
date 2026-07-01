package com.discord.widgets.guilds.list;

import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion {
    private WidgetGuildsList$AddGuildHint$Companion() {
    }

    public final Observable<WidgetGuildsList$AddGuildHint> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableY = Observable.i(storeStream$Companion.getNux().getNuxState(), StoreConnectionOpen.observeConnectionOpen$default(storeStream$Companion.getConnectionOpen(), false, 1, null), storeStream$Companion.getChannels().observeGuildAndPrivateChannels(), WidgetGuildsList$AddGuildHint$Companion$get$1.INSTANCE).y(WidgetGuildsList$AddGuildHint$Companion$get$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable\n             ….filter { it.isEligible }");
        Observable<WidgetGuildsList$AddGuildHint> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null).M(WidgetGuildsList$AddGuildHint$Companion$get$3.INSTANCE);
        m.checkNotNullExpressionValue(observableM, "Observable\n             … = false)\n              }");
        return observableM;
    }

    public final Observable<Boolean> getDismissAction() {
        Observable observableG = StoreStream.Companion.getNavigation().observeLeftPanelState().G(WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n            …te == PanelState.Closed }");
        return observableG;
    }

    public /* synthetic */ WidgetGuildsList$AddGuildHint$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
