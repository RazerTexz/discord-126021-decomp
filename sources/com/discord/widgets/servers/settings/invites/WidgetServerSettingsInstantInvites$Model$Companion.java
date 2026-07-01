package com.discord.widgets.servers.settings.invites;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Model$Companion {
    private WidgetServerSettingsInstantInvites$Model$Companion() {
    }

    public static /* synthetic */ Observable get$default(WidgetServerSettingsInstantInvites$Model$Companion widgetServerSettingsInstantInvites$Model$Companion, long j, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        if ((i & 4) != 0) {
            storeInstantInvites = StoreStream.Companion.getInstantInvites();
        }
        return widgetServerSettingsInstantInvites$Model$Companion.get(j, storeGuilds, storeInstantInvites);
    }

    public final Observable<WidgetServerSettingsInstantInvites$Model> get(long guildId, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites) {
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Observable<WidgetServerSettingsInstantInvites$Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{storeGuilds, storeInstantInvites}, false, null, null, new WidgetServerSettingsInstantInvites$Model$Companion$get$1(storeGuilds, guildId, storeInstantInvites), 14, null)).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsInstantInvites$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
