package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.t.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$Model$Companion$get$1<T, R> implements b<MeUser, Observable<? extends WidgetServerSettingsRoles$Model>> {
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsRoles$Model$Companion$get$1(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsRoles$Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsRoles$Model> call2(MeUser meUser) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.h(storeStream$Companion.getGuilds().observeGuild(this.$guildId), storeStream$Companion.getGuilds().observeComputed(this.$guildId, m.listOf(Long.valueOf(meUser.getId()))).G(new WidgetServerSettingsRoles$Model$Companion$get$1$1(meUser)), storeStream$Companion.getPermissions().observePermissionsForGuild(this.$guildId), storeStream$Companion.getGuilds().observeRoles(this.$guildId), new WidgetServerSettingsRoles$Model$Companion$get$1$2(this, meUser));
    }
}
