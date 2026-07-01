package com.discord.widgets.voice.settings;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildVoiceRegions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$Model$Companion {
    private WidgetVoiceChannelSettings$Model$Companion() {
    }

    public final Observable<WidgetVoiceChannelSettings$Model> get(long channelId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreChannels channels = storeStream$Companion.getChannels();
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        StoreUser users = storeStream$Companion.getUsers();
        StorePermissions permissions = storeStream$Companion.getPermissions();
        StoreGuildVoiceRegions guildVoiceRegions = storeStream$Companion.getGuildVoiceRegions();
        Observable<WidgetVoiceChannelSettings$Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{channels, guilds, StoreUser.Companion.getMeUpdate(), permissions, guildVoiceRegions, storeStream$Companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings$Model$Companion$get$1(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetVoiceChannelSettings$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
