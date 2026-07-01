package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureFirstOpen$1<T1, T2, R> implements Func2<Boolean, Map<Long, ? extends Channel>, Boolean> {
    public static final WidgetHome$configureFirstOpen$1 INSTANCE = new WidgetHome$configureFirstOpen$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Map<Long, ? extends Channel> map) {
        return call2(bool, (Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Map<Long, Channel> map) {
        m.checkNotNullExpressionValue(bool, "connectionOpen");
        if (bool.booleanValue()) {
            return Boolean.valueOf(map.isEmpty());
        }
        return null;
    }
}
