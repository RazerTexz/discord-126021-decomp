package com.discord.widgets.chat.list.sheet;

import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel$Companion {
    private WidgetApplicationCommandBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetApplicationCommandBottomSheetViewModel$Companion widgetApplicationCommandBottomSheetViewModel$Companion, ObservationDeck observationDeck, long j, Long l, long j2, long j3, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands) {
        return widgetApplicationCommandBottomSheetViewModel$Companion.observeStores(observationDeck, j, l, j2, j3, storeGuilds, storeChannels, storeUser, storeApplicationInteractions, storeApplicationCommands);
    }

    private final Observable<WidgetApplicationCommandBottomSheetViewModel$StoreState> observeStores(ObservationDeck observationDeck, long interactionId, Long guildId, long userId, long applicationId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUsers, StoreApplicationInteractions storeInteractions, StoreApplicationCommands storeApplicationCommands) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeApplicationCommands, storeChannels, storeInteractions, storeGuilds, storeUsers}, false, null, null, new WidgetApplicationCommandBottomSheetViewModel$Companion$observeStores$1(storeInteractions, interactionId, storeApplicationCommands, applicationId, userId, storeGuilds, guildId, storeUsers, storeChannels), 14, null);
    }

    public /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
