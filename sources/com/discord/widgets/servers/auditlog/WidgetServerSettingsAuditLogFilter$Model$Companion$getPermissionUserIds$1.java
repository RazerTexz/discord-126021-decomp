package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.f0.q;
import d0.t.i0;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1<T1, T2, T3, R> implements Func3<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Set<? extends Long>> {
    public static final WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1 INSTANCE = new WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2) {
        return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2) {
        m.checkNotNullExpressionValue(map2, "members");
        return q.toSet(q.map(q.filter(i0.asSequence(map2), new WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1(guild, map)), WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2.INSTANCE));
    }
}
