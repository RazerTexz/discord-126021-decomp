package com.discord.widgets.channels;

import com.discord.stores.StoreChannels;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel$Companion {
    private WidgetChannelPickerBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetChannelPickerBottomSheetViewModel$Companion widgetChannelPickerBottomSheetViewModel$Companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, boolean z2) {
        return widgetChannelPickerBottomSheetViewModel$Companion.observeStoreState(j, observationDeck, storeChannels, z2);
    }

    private final Observable<WidgetChannelPickerBottomSheetViewModel$StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels, boolean hideAnnouncementChannels) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeChannels}, false, null, null, new WidgetChannelPickerBottomSheetViewModel$Companion$observeStoreState$1(storeChannels, guildId, hideAnnouncementChannels), 14, null);
    }

    public /* synthetic */ WidgetChannelPickerBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
