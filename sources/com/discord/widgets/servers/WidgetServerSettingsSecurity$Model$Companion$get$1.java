package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$Model$Companion$get$1<T1, T2, R> implements Func2<MeUser, Guild, WidgetServerSettingsSecurity$Model> {
    public static final WidgetServerSettingsSecurity$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsSecurity$Model$Companion$get$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetServerSettingsSecurity$Model call(MeUser meUser, Guild guild) {
        return call2(meUser, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsSecurity$Model call2(MeUser meUser, Guild guild) {
        if (meUser == null || guild == null || guild.getOwnerId() != meUser.getId()) {
            return null;
        }
        return new WidgetServerSettingsSecurity$Model(guild.getId(), guild.getName(), guild.getMfaLevel() > 0);
    }
}
