package com.discord.widgets.servers.settings.members;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import j0.k.b;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel$Companion$get$1<T, R> implements b<Map<Long, ? extends GuildMember>, Observable<? extends WidgetServerSettingsMembersModel>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Observable $roleFilterPublisher;

    public WidgetServerSettingsMembersModel$Companion$get$1(long j, Observable observable, Observable observable2) {
        this.$guildId = j;
        this.$filterPublisher = observable;
        this.$roleFilterPublisher = observable2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsMembersModel> call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsMembersModel> call2(Map<Long, GuildMember> map) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.e(storeStream$Companion.getGuilds().observeGuild(this.$guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(this.$guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getUsers().observeUsers(map.keySet()), storeStream$Companion.getGuilds().observeRoles(this.$guildId), this.$filterPublisher.p(300L, TimeUnit.MILLISECONDS), this.$roleFilterPublisher, new WidgetServerSettingsMembersModel$Companion$get$1$1(map));
    }
}
