package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel$Companion {
    private PriceTierPickerBottomSheetViewModel$Companion() {
    }

    private final Observable<PriceTierPickerBottomSheetViewModel$StoreState> observeStoreState(ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions), 14, null);
    }

    public static /* synthetic */ Observable observeStoreState$default(PriceTierPickerBottomSheetViewModel$Companion priceTierPickerBottomSheetViewModel$Companion, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, Object obj) {
        if ((i & 1) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        if ((i & 2) != 0) {
            storeGuildRoleSubscriptions = StoreStream.Companion.getGuildRoleSubscriptions();
        }
        return priceTierPickerBottomSheetViewModel$Companion.observeStoreState(observationDeck, storeGuildRoleSubscriptions);
    }

    public /* synthetic */ PriceTierPickerBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
