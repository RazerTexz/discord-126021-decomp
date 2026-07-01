package com.discord.widgets.guilds.join;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel$Companion {
    private WidgetGuildWelcomeSheetViewModel$Companion() {
    }

    public final Observable<WidgetGuildWelcomeSheetViewModel$StoreState> observeStores(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetGuildWelcomeSheetViewModel$StoreState> observableJ = Observable.j(storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuildWelcomeScreens().observeGuildWelcomeScreen(guildId), WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n            .…          )\n            }");
        return observableJ;
    }

    public /* synthetic */ WidgetGuildWelcomeSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
