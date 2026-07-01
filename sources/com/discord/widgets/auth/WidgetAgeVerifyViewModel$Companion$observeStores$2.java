package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$Companion$observeStores$2<T1, T2, T3, R> implements Func3<MeUser, Boolean, Channel, WidgetAgeVerifyViewModel$StoreState> {
    public static final WidgetAgeVerifyViewModel$Companion$observeStores$2 INSTANCE = new WidgetAgeVerifyViewModel$Companion$observeStores$2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetAgeVerifyViewModel$StoreState call(MeUser meUser, Boolean bool, Channel channel) {
        return call(meUser, bool.booleanValue(), channel);
    }

    public final WidgetAgeVerifyViewModel$StoreState call(MeUser meUser, boolean z2, Channel channel) {
        m.checkNotNullParameter(meUser, "me");
        return new WidgetAgeVerifyViewModel$StoreState(channel, meUser.getNsfwAllowance(), z2);
    }
}
