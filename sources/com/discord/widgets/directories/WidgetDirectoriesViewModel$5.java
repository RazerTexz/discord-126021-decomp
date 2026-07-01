package com.discord.widgets.directories;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$5<T, R> implements b<Long, Boolean> {
    public final /* synthetic */ StoreChannels $channelsStore;

    public WidgetDirectoriesViewModel$5(StoreChannels storeChannels) {
        this.$channelsStore = storeChannels;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        StoreChannels storeChannels = this.$channelsStore;
        m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
        Channel channelFindChannelById = storeChannels.findChannelById(l.longValue());
        return Boolean.valueOf(channelFindChannelById != null && ChannelUtils.o(channelFindChannelById));
    }
}
