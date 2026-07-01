package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreNux$NuxState;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion$get$1<T1, T2, T3, R> implements Func3<StoreNux$NuxState, Boolean, Map<Long, ? extends Channel>, WidgetGuildsList$AddGuildHint> {
    public static final WidgetGuildsList$AddGuildHint$Companion$get$1 INSTANCE = new WidgetGuildsList$AddGuildHint$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetGuildsList$AddGuildHint call(StoreNux$NuxState storeNux$NuxState, Boolean bool, Map<Long, ? extends Channel> map) {
        return call2(storeNux$NuxState, bool, (Map<Long, Channel>) map);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsList$AddGuildHint call2(StoreNux$NuxState storeNux$NuxState, Boolean bool, Map<Long, Channel> map) {
        boolean z2;
        if (storeNux$NuxState.getAddGuildHint()) {
            m.checkNotNullExpressionValue(bool, "connectionOpen");
            if (bool.booleanValue() && map.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return new WidgetGuildsList$AddGuildHint(z2, storeNux$NuxState.getAddGuildHint());
    }
}
