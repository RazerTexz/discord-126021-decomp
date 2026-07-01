package com.discord.widgets.chat.list;

import com.discord.stores.StoreChannelFollowerStats;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel$Companion {
    private PublishActionDialogViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeChannelFollowerStatsStoreState(PublishActionDialogViewModel$Companion publishActionDialogViewModel$Companion, long j, StoreChannelFollowerStats storeChannelFollowerStats) {
        return publishActionDialogViewModel$Companion.observeChannelFollowerStatsStoreState(j, storeChannelFollowerStats);
    }

    private final Observable<PublishActionDialogViewModel$StoreState> observeChannelFollowerStatsStoreState(long channelId, StoreChannelFollowerStats storeChannelFollowerStats) {
        Observable<PublishActionDialogViewModel$StoreState> observableR = storeChannelFollowerStats.observeChannelFollowerStats(channelId).G(PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeChannelFollowerStat…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ PublishActionDialogViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
