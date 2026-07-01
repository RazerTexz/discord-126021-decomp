package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion {
    private WidgetStageRaisedHandsBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetStageRaisedHandsBottomSheetViewModel$Companion widgetStageRaisedHandsBottomSheetViewModel$Companion, long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock) {
        return widgetStageRaisedHandsBottomSheetViewModel$Companion.observeStoreState(j, storeVoiceParticipants, storeChannels, storeGuilds, storeStageChannels, clock);
    }

    private final Observable<WidgetStageRaisedHandsBottomSheetViewModel$StoreState> observeStoreState(long channelId, StoreVoiceParticipants voiceParticipants, StoreChannels channelsStore, StoreGuilds guildsStore, StoreStageChannels stageChannels, Clock clock) {
        Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<WidgetStageRaisedHandsBottomSheetViewModel$StoreState> observableY = observableG.r().Y(new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1(guildsStore, voiceParticipants, channelId, stageChannels, clock));
        m.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
