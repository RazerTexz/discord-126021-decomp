package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$Model$Companion$get$1<T, R> implements b<MeUser, Observable<? extends WidgetServerSettingsEditRole$Model>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $roleId;

    public WidgetServerSettingsEditRole$Model$Companion$get$1(long j, long j2) {
        this.$guildId = j;
        this.$roleId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEditRole$Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEditRole$Model> call2(MeUser meUser) {
        m.checkNotNullParameter(meUser, "meUser");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.f(storeStream$Companion.getGuilds().observeGuild(this.$guildId), storeStream$Companion.getGuilds().observeComputed(this.$guildId, d0.t.m.listOf(Long.valueOf(meUser.getId()))), storeStream$Companion.getGuilds().observeRoles(this.$guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(this.$guildId), NewThreadsPermissionsFeatureFlag.Companion.getINSTANCE().observeEnabled(this.$guildId), GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(this.$guildId), new WidgetServerSettingsEditRole$Model$Companion$get$1$1(this, meUser));
    }
}
