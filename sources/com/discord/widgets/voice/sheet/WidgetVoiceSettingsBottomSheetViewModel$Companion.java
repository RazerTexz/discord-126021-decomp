package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreStageChannels;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel$Companion {
    private WidgetVoiceSettingsBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetVoiceSettingsBottomSheetViewModel$Companion widgetVoiceSettingsBottomSheetViewModel$Companion, long j, StoreStageChannels storeStageChannels) {
        return widgetVoiceSettingsBottomSheetViewModel$Companion.observeStoreState(j, storeStageChannels);
    }

    private final Observable<WidgetVoiceSettingsBottomSheetViewModel$StoreState> observeStoreState(long channelId, StoreStageChannels stageChannelsStore) {
        Observable<WidgetVoiceSettingsBottomSheetViewModel$StoreState> observableY = ObservableExtensionsKt.computationLatest(CallModel.Companion.get(channelId)).r().Y(new WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1(stageChannelsStore, channelId));
        m.checkNotNullExpressionValue(observableY, "CallModel.get(channelId)…          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
