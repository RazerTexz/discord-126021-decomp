package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel$Companion$observeStoreState$1<T1, T2, T3, R> implements Func3<Channel, Guild, Long, WidgetThreadBrowserViewModel$StoreState> {
    public static final WidgetThreadBrowserViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetThreadBrowserViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadBrowserViewModel$StoreState call(Channel channel, Guild guild, Long l) {
        return call2(channel, guild, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserViewModel$StoreState call2(Channel channel, Guild guild, Long l) {
        return new WidgetThreadBrowserViewModel$StoreState(channel, guild, l);
    }
}
