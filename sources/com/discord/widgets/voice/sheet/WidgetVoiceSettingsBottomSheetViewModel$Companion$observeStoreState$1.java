package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStageChannels;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1<T, R> implements b<CallModel, Observable<? extends WidgetVoiceSettingsBottomSheetViewModel$StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreStageChannels $stageChannelsStore;

    public WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1(StoreStageChannels storeStageChannels, long j) {
        this.$stageChannelsStore = storeStageChannels;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceSettingsBottomSheetViewModel$StoreState> call(CallModel callModel) {
        return call2(callModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceSettingsBottomSheetViewModel$StoreState> call2(CallModel callModel) {
        return callModel == null ? new k(WidgetVoiceSettingsBottomSheetViewModel$StoreState$Invalid.INSTANCE) : this.$stageChannelsStore.observeMyRoles(this.$channelId).G(new WidgetVoiceSettingsBottomSheetViewModel$Companion$observeStoreState$1$1(callModel));
    }
}
