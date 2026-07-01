package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$Model$Companion$get$1$1<T, R> implements b<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ MeUser $meUser;

    public WidgetServerSettingsRoles$Model$Companion$get$1$1(MeUser meUser) {
        this.$meUser = meUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, GuildMember> map) {
        return map.get(Long.valueOf(this.$meUser.getId()));
    }
}
