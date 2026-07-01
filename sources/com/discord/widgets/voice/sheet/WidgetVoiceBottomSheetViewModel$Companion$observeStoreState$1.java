package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StorePermissions;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetVoiceBottomSheetViewModel$StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePermissions $permissionsStore;

    public WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1(long j, StorePermissions storePermissions) {
        this.$channelId = j;
        this.$permissionsStore = storePermissions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceBottomSheetViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceBottomSheetViewModel$StoreState> call2(Channel channel) {
        return Observable.i(CallModel.Companion.get(this.$channelId), this.$permissionsStore.observePermissionsForChannel(this.$channelId), TextInVoiceFeatureFlag.Companion.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1.INSTANCE);
    }
}
