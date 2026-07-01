package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$Companion {
    private WidgetServerNotifications$Companion() {
    }

    public static final /* synthetic */ Observable access$getNotificationOverrides(WidgetServerNotifications$Companion widgetServerNotifications$Companion, long j) {
        return widgetServerNotifications$Companion.getNotificationOverrides(j);
    }

    private final Observable<List<NotificationsOverridesAdapter$Item>> getNotificationOverrides(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getUserGuildSettings().observeGuildSettings(guildId).G(WidgetServerNotifications$Companion$getNotificationOverrides$1.INSTANCE), StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), guildId, null, 2, null), GuildChannelsInfo.Companion.get(guildId), WidgetServerNotifications$Companion$getNotificationOverrides$2.INSTANCE);
    }

    public final void launch(long guildId, Context context) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerNotifications.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerNotifications$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
