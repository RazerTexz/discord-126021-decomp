package com.discord.widgets.channels.threads;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet$Model$Companion$get$1<T1, T2, T3, R> implements Func3<StoreThreadDraft$ThreadDraftState, Guild, Channel, WidgetThreadDraftArchiveSheet$Model> {
    public static final WidgetThreadDraftArchiveSheet$Model$Companion$get$1 INSTANCE = new WidgetThreadDraftArchiveSheet$Model$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadDraftArchiveSheet$Model call(StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Guild guild, Channel channel) {
        return call2(storeThreadDraft$ThreadDraftState, guild, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadDraftArchiveSheet$Model call2(StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Guild guild, Channel channel) {
        m.checkNotNullExpressionValue(storeThreadDraft$ThreadDraftState, "draftState");
        return new WidgetThreadDraftArchiveSheet$Model(storeThreadDraft$ThreadDraftState, guild, channel);
    }
}
