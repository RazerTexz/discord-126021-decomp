package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$setUserSuppressed$1<T, R> implements b<Channel, Observable<? extends Void>> {
    public final /* synthetic */ boolean $isSuppressed;
    public final /* synthetic */ long $userId;

    public WidgetStageRaisedHandsBottomSheetViewModel$setUserSuppressed$1(long j, boolean z2) {
        this.$userId = j;
        this.$isSuppressed = z2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Void> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Void> call2(Channel channel) {
        StageChannelAPI stageChannelAPI = StageChannelAPI.INSTANCE;
        m.checkNotNullExpressionValue(channel, "channel");
        return ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(stageChannelAPI, channel, this.$userId, this.$isSuppressed, 0L, 8, null), false, 1, null);
    }
}
