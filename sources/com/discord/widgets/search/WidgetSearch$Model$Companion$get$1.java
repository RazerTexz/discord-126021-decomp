package com.discord.widgets.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch$DisplayState;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$Model$Companion$get$1<T1, T2, T3, T4, R> implements Func4<Guild, Channel, StoreSearch$DisplayState, Boolean, WidgetSearch$Model> {
    public static final WidgetSearch$Model$Companion$get$1 INSTANCE = new WidgetSearch$Model$Companion$get$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSearch$Model call(Guild guild, Channel channel, StoreSearch$DisplayState storeSearch$DisplayState, Boolean bool) {
        return call2(guild, channel, storeSearch$DisplayState, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearch$Model call2(Guild guild, Channel channel, StoreSearch$DisplayState storeSearch$DisplayState, Boolean bool) {
        if ((guild == null && channel == null) || storeSearch$DisplayState == null) {
            return null;
        }
        m.checkNotNullExpressionValue(bool, "isQueryValid");
        return new WidgetSearch$Model(guild, channel, storeSearch$DisplayState, bool.booleanValue());
    }
}
