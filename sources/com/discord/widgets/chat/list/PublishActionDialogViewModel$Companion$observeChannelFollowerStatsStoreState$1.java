package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelChannelFollowerStats;
import j0.k.b;

/* JADX INFO: compiled from: PublishActionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1<T, R> implements b<ModelChannelFollowerStats, PublishActionDialogViewModel$StoreState> {
    public static final PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1 INSTANCE = new PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ PublishActionDialogViewModel$StoreState call(ModelChannelFollowerStats modelChannelFollowerStats) {
        return call2(modelChannelFollowerStats);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PublishActionDialogViewModel$StoreState call2(ModelChannelFollowerStats modelChannelFollowerStats) {
        return new PublishActionDialogViewModel$StoreState(modelChannelFollowerStats);
    }
}
